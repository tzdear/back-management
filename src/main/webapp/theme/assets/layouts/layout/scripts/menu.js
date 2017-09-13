var ctx = App.domain();
$.ajax({
	url:ctx+"/getMenu",
	type:"post",
	success: function(data){
		var html = '';
		for(var i in data){
			html += '<li class="nav-item lymenu">';
			var g = data[i];
			if(g.url==null&&g.chilens.length>0){
				html+='<a href="javascript:;" class="nav-link nav-toggle"><i class="'+g.icon+'"></i><span class="title">'+g.name+'</span><span class="arrow"></span></a>';
				html+='<ul class="sub-menu">';
				for(var j in g.chilens){
					html += '<li class="nav-item lymenu">';
					var o = g.chilens[j];
					if(o.url==null&&o.chilens.length>0){
						html+='<a href="javascript:;" class="nav-link nav-toggle"><i class="'+o.icon+'"></i><span class="title">'+o.name+'</span><span class="arrow"></span></a>';
						html+='<ul class="sub-menu">';
						for(var q in o.chilens){
							
							var p = o.chilens[q];
							html += '<li class="nav-item lymenu">';
							html += '<a href="'+ctx+'/'+q.url+'" data-url="'+ctx+'/'+q.url+'" class="nav-link"><i class="'+q.icon+'"></i><span class="title">'+q.name+'</span></a>';
							html+="</li>";
						}
						html+="</ul>";
					}else{
						html += '<a href="'+ctx+'/'+o.url+'" data-url="'+ctx+'/'+o.url+'" class="nav-link"><i class="'+o.icon+'"></i><span class="title">'+o.name+'</span></a>';
					}
					html+="</li>";
				}
				html+="</ul>";
			}else{
				html += '<a href="'+ctx+'/'+g.url+'" data-url="'+ctx+'/'+g.url+'" class="nav-link"><i class="'+g.icon+'"></i><span class="title">'+g.name+'</span></a>';
			}
			html+="</li>";
		}
		$(".page-sidebar-menu.page-header-fixed").append(html);
		outhMenu();
	},
	error: function(a,b,c){
		console.info(a);
	}
});

function outhMenu(){
	var url = location.pathname;//域名之后    参数之前 如  ：http://www.baidu.com/aglj/daog.do?agej   得到   /aglj/daog.do
	var lis = $("ul.page-sidebar-menu").find(".lymenu");
	lis.each(function(){
		var lia = $(this).find("a");
		var dom = this;
		lia.each(function(){
			var liaHref = $(this).data("url");
			if(liaHref!=null&&liaHref!=undefined){
				var num = liaHref.indexOf(url);
				if(num>0){
					$(this).css({"cssText":"background-color:#7f868e !important"});
					$(this).parent().addClass("active");
					$(this).parent().addClass("open");
					parentLi(dom);
				}
			}
		});
	});
}

var parentLi = function(li){
	var liP = $(li).parent();
	if($(liP).hasClass("sub-menu")){
		parentLi(liP);
	}else{
		if(!$(liP).hasClass("page-sidebar-menu")){
			$(liP).css({"":""});
			$(liP).addClass("open");
			$(liP).addClass("active");
			var liPa = $(liP).children().first();
			$(liPa).append("<span class='selected'></span>");
//			$(liPa).children().find(".arrow").addClass("open");
			$(liPa).children().each(function(){
				if($(this).hasClass("arrow")){
					$(this).addClass("open");
				}
			});
			var liPP = $(liP).parent();
			if(!$(liPP).hasClass("page-sidebar-menu")){
				parentLi(liP);
			}
		}
	}
}

var menuClickFun = function(){
	$(".nav-item .nav-link").on("click",function(a,b,c){
		if(!$(this).hasClass("nav-toggle")){
			var navItems = $(".selectMenuClass");
			if(navItems!=null&&navItems!=""&&navItems!=undefined){
				navItems.css({"cssText":"background-color:none"});
				navItems.removeClass("selectMenuClass");
			}
			if($(this).parents(".nav-item").length>1){
				$(this).addClass("selectMenuClass");
				$(this).css({"cssText":"background-color:#7f868e !important"});
			}else{
				$(".page-sidebar-menu").find(".arrow.open").each(function(){
					$(this).parent().parent().find(".sub-menu").css({"display":"none"});
					$(this).removeClass("open");
					$(this).parent().find(".selected").remove();
				});
			}
			var url = $(this).data("url");
			App.blockUI({"zIndex":1000});
			$(".nav-item").removeClass("active");
			$(".nav-item").removeClass("open");
			$(this).parents(".nav-item").addClass("active");
			$(this).parents(".nav-item").addClass("open");
			$(this).parent().addClass("active");
			$(this).parent().addClass("open");
//			$("#mainBodyId").load(url,"",function(response,status,xhr){
//				if(status!='success'&&status!='notmodified'){
//					$("#mainBodyId").html(response);
//				}
//				App.unblockUI();
//			});
		}
	});
}
