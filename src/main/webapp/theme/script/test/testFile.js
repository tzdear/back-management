var FileUploadLy = function(){
	function fileSize(num){
		var siz = parseFloat(num);
		var sizG = siz/1024/1024/1024;
		if(sizG>1){
			return sizG.toFixed(2)+"G";
		}
		var sizM = siz/1024/1024;
		if(sizM>1){
			return sizM.toFixed(2)+"M";
		}
		var sizK = siz/1024;
		if(sizK>1){
			return sizK.toFixed(2)+"K";
		}
		return num+"B"
	};
	var defult = {
		id:"",				//input 组件id
		width: "40px",			//上传按钮的宽
		height:"20px",			//上传按钮的高
		padding:"4px 10px",		//上传按钮中的dom的距离边框的距离
		color:"#1E88C7",		//上传按钮中的dom的文字颜色
		background:"#D0EEFF",	//上传按钮的背景色
		border_radius:"4px !important",	//上传按钮的边框圆弧度
		border:"1px solid #99D3F5",	//上传按钮的边框样式
		btnText:"浏览",		//上传按钮的 文字
		btnClass:"",		//上传按钮的 样式
		btnHoverClass:"",	//鼠标移动到上传按钮时的 样式
		btnBackIcon:"",		//上传的背景图
		aout:true,			//是否自动上传
		showSize:false,		//是否显示文件大小
		showName:true,		//是否显示文件名称
		showType:false,		//是否显示文件类型
		multiple:false,		//多选
		selectType:"*",		//设置 可以选择的文件类型
		url:"",				//自动上传时 需要提交到服务器的URL
		progressDivId:"",	//显示进度条 的 div id 
		showInfoDivId:"",	//显示 文件大小  文件名称 文件类型的  div  id   默认  显示在 此 input file  的下方  div 形式
		changeFn:null,		//当选择框发生改变时  的 回调函数
		completeFn:null		//当 自动上传时  完成时的回调函数    无论成功与否  
	}
		
	function upLoade(id){
		var name = $("#"+id).attr("name");
		var multiple = $("#"+id).attr("multiple");  //  多文件上传
		var accept = $("#"+id).attr("accept");		//  上传文件类型
		var top = $("#"+id).offset().top;
		var left = $("#"+id).offset().left;
		var da = new Date().getTime();
		$("#"+id).hide();
		var divId = id+"_"+da;
		var spanStyle = {
			"top":top,
			"left":left,
			"text-align": "center",
			"margin":"5px",
			"height":defult.height,
			"width":defult.width,
			"background-image":defult.btnBackIcon,
			"display":"inline-block",
		    "background":defult.background,
		    "border": defult.border,
		    "border-radius": defult.border_radius,
		    "padding": defult.padding,
		    "overflow": "hidden",
		    "color": defult.color,
		    "text-decoration": "none",
		    "text-indent": "0",
		    "line-height": defult.height,
		    "box-sizing": "content-box"
		};
		var spanHoverStyle= {
			"background": "#AADFFD",
		    "border-color": "#78C3F3",
		    "color": "#004974",
		    "text-decoration": "none"
		};
		var sg ;
		if(defult.btnClass!=null&&defult.btnClass!=""&&defult.btnClass!=undefined){
			sg = $("<span id='"+divId+"' class='"+defult.btnClass+"'></span>").html(defult.btnText);
		}else{
			sg = $("<span id='"+divId+"' class='"+defult.btnClass+"'></span>").html(defult.btnText).css(spanStyle);
		}
		$("#"+id).after(sg);
		//移入
		$("#"+divId).on("mouseenter",function(){
			if(defult.btnHoverClass!=null&&defult.btnHoverClass!=""&&defult.btnHoverClass!=undefined){
				if(defult.btnClass!=null&&defult.btnClass!=""&&defult.btnClass!=undefined){
					$(this).removeClass(defult.btnClass);
				}
				$(this).addClass(defult.btnHoverClass);
			}else{
				$(this).css(spanHoverStyle);
			}
		})
		//移出
		$("#"+divId).on("mouseleave",function(){
			if(defult.btnClass!=null&&defult.btnClass!=""&&defult.btnClass!=undefined){
				if(defult.btnHoverClass!=null&&defult.btnHoverClass!=""&&defult.btnHoverClass!=undefined){
					$(this).removeClass(defult.btnHoverClass);
				}
				$(this).addClass(defult.btnClass);
			}else{
				$(this).css(spanStyle);
			}
		})
		if(defult.multiple){
			$("#"+id).attr("multiple","multiple");
		}
		if(defult.selectType!="*"&&defult.selectType!=""&&defult.selectType!=null&&defult.selectType!=undefined){
			$("#"+id).attr("accept",defult.selectType);
		}
		$("#"+divId).on("click",function(){
			$("#"+id).click();
		});
		$("#"+id).on("change",function(){
			var per = new FormData();
			var files = $(this)[0].files;
			for(var i = 0;i < files.length;i++){
				var file = files[i];
				per.append("file["+i+"]",files[i]);
				var siz = file.size;
				var sizStr = fileSize(siz);
				var fileName = file.name;
				var fileType = file.type;
				var infoHtml = "";
				if(defult.showName){
					infoHtml += "文件名称："+fileName+"   ";
				}
				if(defult.showType){
					infoHtml += "文件类型："+fileType+"   ";
				}
				if(defult.showSize){
					infoHtml += "文件大小："+sizStr+"   ";
				}
				infoHtml +="<br>";
				if(defult.showInfoDivId!=null&&defult.showInfoDivId!=""&&defult.showInfoDivId!=undefined){
					$("#"+defult.showInfoDivId).append(infoHtml);
				}else{
					$("#"+divId).after(infoHtml);
				}
			}
			if(defult.changeFn!=null){
				defult.changeFn();
			}
			if(defult.aout){
				$.ajax({
					url : defult.url, 
					type : 'POST', 
					data : per, 
					// 告诉jQuery不要去处理发送的数据
					processData : false, 
					// 告诉jQuery不要去设置Content-Type请求头
					contentType : false,
					beforeSend:function(){
						console.log("正在进行，请稍候");
					},
					success : function(responseStr) {
//						if(responseStr.status===0){
//							console.log("成功"+responseStr);
//						}else{
//							console.log("失败");
//						}
//						$("#son").html("成功公里了");
					}, 
					error : function(responseStr) { 
						console.log("error");
					},
					complete:function(xhr, ts){
						if(ts=='success'){
							$("#irs-single").css({
								"left":"99%"
							});
						}else{
							$("#irs-single").css({
								"left":"100%"
							});
						}
						$("#irs-single").html(ts);
					},
					xhr: function(){
				　　　　　　var xhr = $.ajaxSettings.xhr();
				　　　　　　if(onprogress && xhr.upload) {
				　　　　　　　　xhr.upload.addEventListener("progress" , onprogress, false);
				　　　　　　　　return xhr;
				　　　　　　}
				　　　　} 
				});
			}
		});
		var onprogress =function(a,b,c){
			var loaded = a.loaded;     //已经上传大小情况 
			var tot = a.total;      //附件总大小 
			var per = Math.floor(100*loaded/tot);  //已经上传的百分比 
			$("#irs-single").html(per +"%");
			var siPer = 0;
			if(per<10){
				siPer = per+0.5;
			}else{
				siPer = per;
			}
			$("#irs-single").css({
				"left":siPer +"%"
			});
			$("#irs-bar").css("width" , per +"%");
		}
		var typecss = '.irs-single:after{position: absolute; display: block; content: ""; bottom: -6px; left: 50%;  width: 0;height: 0; margin-left: -3px;overflow: hidden;border: 3px solid transparent; border-top-color: #ed5565;}';
		
		var stl = $("<style></style>").attr("type","text/css").append(typecss);
		$("head").append(stl);
		
	}
	return {
		upLoade :function(options){
			defult = $.extend(defult, options);
			upLoade(defult.id);
		}
	}
}();

	
	 
jQuery(document).ready(function() {
	FileUploadLy.upLoade({"id":"upload"});
	FileUploadLy.upLoade({"id":"uploasd"});
//	$("#gjgj").on("click",function(){
//		var ctx = "<%=basePath %>";
//		
//		var files = $("#upload")[0].files;
//		for(var i = 0;i < files.length;i++){
//			var formData = new FormData();
//			formData.append("file["+i+"]",files[i]);
//			formData.append("iop","ggg");
//			$.ajax({ 
//			url : ctx+"fileupdate", 
//			type : 'POST', 
//			data : formData, 
//			// 告诉jQuery不要去处理发送的数据
//			processData : false, 
//			// 告诉jQuery不要去设置Content-Type请求头
//			contentType : false,
//			beforeSend:function(){
//				console.log("正在进行，请稍候");
//			},
//			success : function(responseStr) {
//				if(responseStr.status===0){
//					console.log("成功"+responseStr);
//				}else{
//					console.log("失败");
//				}
//				$("#son").html("成功公里了");
//			}, 
//			error : function(responseStr) { 
//				console.log("error");
//			},
//			xhr: function(){
//		　　　　　　var xhr = $.ajaxSettings.xhr();
//		　　　　　　if(onprogress && xhr.upload) {
//		　　　　　　　　xhr.upload.addEventListener("progress" , onprogress, false);
//		　　　　　　　　return xhr;
//		　　　　　　}
//		　　　　} 
//		});
//		}
//		
//		
//	});
//	var onprogress =function(a,b,c){
//		var loaded = a.loaded;     //已经上传大小情况 
//		 var tot = a.total;      //附件总大小 
//		 var per = Math.floor(100*loaded/tot);  //已经上传的百分比 
//		 $("#irs-single").html(per +"%");
//		 var siPer = 0;
//		 if(per<10){
//		 	siPer = per+0.5;
//		 }else{
//		 	siPer = per;
//		 }
//		 console.info(siPer);
//		 $("#irs-single").css({
//		 	"left":siPer +"%"
//		 });
//		 $("#irs-bar").css("width" , per +"%");
//	}
});