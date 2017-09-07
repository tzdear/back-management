<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
  <head>
       <title>后台管理</title>
<!--         <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
       <meta content="width=device-width, initial-scale=1" name="viewport" />
       <meta content="#1 selling multi-purpose bootstrap admin theme sold in themeforest marketplace packed with angularjs, material design, rtl support with over thausands of templates and ui elements and plugins to power any type of web applications including saas and admin dashboards. Preview page of Theme #1 for basic datatable samples"
           name="description" />
       <meta content="" name="author" />
       <!-- BEGIN GLOBAL MANDATORY STYLES -->
       <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
       <link href="<%=basePath %>theme/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
       <link href="<%=basePath %>theme/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
       <link href="<%=basePath %>theme/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
       <link href="<%=basePath %>theme/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
       <!-- END GLOBAL MANDATORY STYLES -->
       <!-- BEGIN PAGE LEVEL PLUGINS -->
       <link href="<%=basePath %>theme/assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
       <link href="<%=basePath %>theme/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
       <link href="<%=basePath %>theme/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" />
       <link href="<%=basePath %>theme/assets/global/plugins/jquery-nestable/jquery.nestable.css" rel="stylesheet" type="text/css" />
       <!-- END PAGE LEVEL PLUGINS -->
       <!-- BEGIN THEME GLOBAL STYLES -->
       <link href="<%=basePath %>theme/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
       <link href="<%=basePath %>theme/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
       <!-- END THEME GLOBAL STYLES -->
       <!-- BEGIN THEME LAYOUT STYLES -->
       <link href="<%=basePath %>theme/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
       <link href="<%=basePath %>theme/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
       <link href="<%=basePath %>theme/assets/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css" />
       <!-- END THEME LAYOUT STYLES -->
       <link rel="shortcut icon" href="favicon.ico" /> 
   <style type="text/css">
       .page-header.navbar .menu-toggler.sidebar-toggler{
       	margin:30px 0 0
       }
       .selectMenuClass{
       	background-color:#7f868e !important
       }
       .page-container-bg-solid .page-bar .page-breadcrumb>li>i.fa-circle, .page-content-white .page-bar .page-breadcrumb>li>i.fa-circle{
       	top:0px;
       }
       .dd3-content{ 
       	height: 40px;
       	padding: 10px 15px 10px 50px;
   		font-size: 18px;
       }
       .dd3-handle{ 
       	width: 40px;
       }
       .dd-handle{ 
       	height: 40px;
       }
       .dd3-handle:before { 
       	top: 10px;
       	font-size: 30px;
       }
       .dd3-item > button {
	    margin-left: 40px;
	}
	.dd-item > button { 
		width: 30px;
  			height: 30px;
  			font-size: 20px;
	}
	.dd-list .dd-list {
	    padding-left: 40px;
	}
/* 	.dd-dragel{ */
/* 		z-index: 10051;  */
/* 	} */
  </style>
        
  </head>

  <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
        <div class="page-wrapper">
            <c:import url="${basePath }common/header.jsp"></c:import> 
            <div class="clearfix"> </div>
            <div class="page-container">
                <div class="page-sidebar-wrapper">
                    <div class="page-sidebar navbar-collapse collapse">
                        <c:import url="${basePath }common/menu.jsp"></c:import>
                    </div>
                </div>
                <div class="page-content-wrapper" >
                    <!-- BEGIN CONTENT BODY -->
                    <div class="page-content" id="mainBodyId">
                        <div class="page-bar">
                            <ul class="page-breadcrumb">
                                <li>
                                    <a href="${basePath }sys/main">首页</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                            </ul>
                        </div>
                        <div class="row">
                        	<div class="col-md-12">
						        <div class="portlet light portlet-fit portlet-datatable bordered">
						            <div class="portlet-title">
						                <div class="caption">
					<!-- 	                    <i class="icon-settings font-dark"></i> -->
						                    <span class="caption-subject font-dark sbold uppercase">权限管理</span>
						                </div>
						                <div class="actions">
						                    <div class="btn-group btn-group-devided" data-toggle="buttons">
						                        <label class="btn btn-transparent grey-salsa btn-outline btn-circle btn-sm" id="addtreeid">
					                            	添加权限
					                            </label>
						                    </div>
						                </div>
						            </div>
						            <div class="portlet-body">
						                <div class="dd" id="nestable_list_3">
							              <ol class="dd-list">
							                  <li class="dd-item dd3-item" data-id="13">
							                      <div class="dd-handle dd3-handle"></div>
							                      <div class="dd3-content"> Item 13 
							                      <a href="javascript:alert(0);" style="padding: 2px;margin-left:5px;margin-top:-3px;" class="btn default pull-right"><i class="bigger-120 icon-calendar"></i>修改</a>
							                   <a href="javascript:;" style="padding: 2px;margin-left:5px;margin-top:-3px;" class="btn default pull-right"><i class="fa fa-bank"></i> 删除</a>
							                      </div>
							                  </li>
							                  <li class="dd-item dd3-item" data-id="14">
							                      <div class="dd-handle dd3-handle"> </div>
							                      <div class="dd3-content"> Item 14 </div>
							                  </li>
							                  <li class="dd-item dd3-item" data-id="15">
							                      <div class="dd-handle dd3-handle"> </div>
							                      <div class="dd3-content"> Item 15 </div>
							                      <ol class="dd-list">
							                          <li class="dd-item dd3-item" data-id="16">
							                              <div class="dd-handle dd3-handle"> </div>
							                              <div class="dd3-content"> Item 16 </div>
							                          </li>
							                          <li class="dd-item dd3-item" data-id="17">
							                              <div class="dd-handle dd3-handle"> </div>
							                              <div class="dd3-content"> Item 17 </div>
							                          </li>
							                          <li class="dd-item dd3-item" data-id="18">
							                              <div class="dd-handle dd3-handle"> </div>
							                              <div class="dd3-content"> Item 18 </div>
							                          </li>
							                      </ol>
							                  </li>
							              </ol>
							            </div>
						            </div>
						        </div>
						    </div>
                        </div>
                    </div>
                </div>
            </div>
            <c:import url="${basePath }common/bottom.jsp"></c:import>
        </div>
        <div class="quick-nav-overlay"></div>
        
         <div class="modal fade" id="fenpeiquanxian" tabindex="-1" role="dialog" style="top:0px; ">
		  <div class="modal-dialog" style="width: 80%;" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">添加/修改权限</h4>
		      </div>
		      <div class="modal-body">
		      <div class="row">
		      	<div class="col-md-1"></div>
		      	<div class="col-md-10">
		      		<form id="addOrEditTreeFormId" class="form-horizontal">
		      			<div class="form-body">
		      			<input type="hidden" name="id" id = "editsystreeid"/>
		      			<input type="hidden" name="prsystreeid" id = "editprsystreeid"/>
		      			<div class="form-body" id="formbodyid">
                            <div class="form-group">
                                <label class="control-label col-md-3" >中文名称</label>
                                <div class="col-md-6">
                                   <input class="form-control form-control-inline" name="chName" type="text" value="" placeholder="请输入权限中文名称" >
                                </div>
                            </div>
                        </div>
                        <div class="form-body" id="formbodyid">
                            <div class="form-group">
                                <label class="control-label col-md-3" >英文名称</label>
                                <div class="col-md-6">
                                   <input class="form-control form-control-inline" name="enName" type="text" value="" placeholder="请输入权限英文名称" >
                                </div>
                            </div>
                        </div>
                        <div class="form-body" id="formbodyid">
                            <div class="form-group">
                                <label class="control-label col-md-3" >地址</label>
                                <div class="col-md-6">
                                   <input class="form-control form-control-inline" name="treeUrl" type="text" value="" placeholder="请输入权限地址" >
                                </div>
                            </div>
                        </div>
                        <div class="form-body" id="formbodyid">
                            <div class="form-group">
                                <label class="control-label col-md-3" >菜单等级</label>
                                <div class="col-md-6">
<!--                                    <input class="form-control form-control-inline" name="treeType" type="text" value="" placeholder="请输入权限类型" > -->
									<select name="treeNo" class="form-control" id="treeNoSelectId">
										<option value="0" selected="selected">1</option>
										<option value="1">2</option>
										<option value="2">3</option>
										<option value="3">4</option>
										<option value="4">5</option>
									</select>
                                </div>
                            </div>
                        </div>
                        <div class="form-body" id="treeFDivid" style="display: none;">
                            <div class="form-group">
                                <label class="control-label col-md-3" >上级菜单</label>
                                <div class="col-md-6">
<!--                                    <input class="form-control form-control-inline" name="treeType" type="text" value="" placeholder="请输入权限类型" > -->
									<select name="parentId" class="form-control" id="treeFSelectId">
										<option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>
                                </div>
                            </div>
                        </div>
                        <div class="form-body" id="formbodyid">
                            <div class="form-group">
                                <label class="control-label col-md-3" >类型</label>
                                <div class="col-md-6">
<!--                                    <input class="form-control form-control-inline" name="treeType" type="text" value="" placeholder="请输入权限类型" > -->
									<select name="treeType" class="form-control" id="treeTypeSelectId">
										<option value="1" selected="selected">菜单</option>
										<option value="2">按钮</option>
									</select>
                                </div>
                            </div>
                        </div>
                        <div class="form-body" id="formbodyid">
                            <div class="form-group">
                                <label class="control-label col-md-3" >图标</label>
                                <div class="col-md-6">
                                   <input class="form-control form-control-inline" name="treeIcon" type="text" value="" placeholder="请输入权限图标" >
                                </div>
                            </div>
                        </div>
                        </div>
                        <div class="form-actions center" style="text-align: center;">
                            <button type="button" class="btn btn-default default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn green save-tree-class addTreeButtonClass">提交</button>
                        </div>
		      		</form>
		      	</div>
		      	<div class="col-md-1"></div>
		      </div>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
        
        
     <!--[if lt IE 9]>
<script src="<%=basePath %>theme/assets/global/plugins/respond.min.js"></script>
<script src="<%=basePath %>theme/assets/global/plugins/excanvas.min.js"></script> 
<script src="<%=basePath %>theme/assets/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
     <!-- BEGIN CORE PLUGINS -->
	<script src="<%=basePath %>theme/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script src="<%=basePath %>theme/assets/global/scripts/datatable.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/jquery-nestable/jquery.nestable.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="<%=basePath %>theme/assets/global/scripts/app.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="<%=basePath %>theme/assets/layouts/layout/scripts/layout.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/layout/scripts/menu.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/layout/scripts/demo.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/global/scripts/quick-nav.min.js" type="text/javascript"></script>
     <!-- END THEME LAYOUT SCRIPTS -->
     <script>
		jQuery(document).ready(function() {
			var shu = function(listObj){
				var html = '<ol class="dd-list">';
				
				for(var i in listObj){
					html +='<li class="dd-item dd3-item" data-id="'+listObj[i].id+'">'+
			                '<div class="dd-handle dd3-handle"> </div>'+
			                '<div class="dd3-content"><i class="'+listObj[i].icon+'"></i>'+listObj[i].title+
			                '<a href="javascript:;" style="padding: 2px;margin-left:5px;margin-top:-3px;" class="btn default pull-right editTreeClass"><i class="icon-calendar"></i>修改</a>'+
						    '<a href="javascript:;" style="padding: 2px;margin-left:5px;margin-top:-3px;" class="btn default pull-right deleteTreeClass"><i class="fa fa-bank"></i> 删除</a>'+
			                '</div>';
			    	if(listObj[i].children!=null&&listObj[i].children!=""&&listObj[i].children!=undefined&&listObj[i].children.length>0){
			    		html += shu(listObj[i].children);
			    	}
				    html += '</li>';
				}
				html += '</ol>';
				return html;
			}
			$.ajax({
				url:App.domain()+"/selectAllTree",
				success: function(da){
					if(da.code==0){
						var dat = da.data;
						var html = shu(dat);
						$("#nestable_list_3").html(html);
						$('#nestable_list_3').nestable().on('change', updateOutput);
					}else{
						bootbox.alert(da.mes);
					}
					App.unblockUI();
				},
				error: function(a,b,c){
					var status = a.status;
					if(b=='timeout'){
						bootbox.alert("不好意思  超时了 ");
					}else{
						App.errorAlertStatus(status);
					}
					App.unblockUI();
				}
			});
			var updateOutput = function(e){
				var list = e.length ? e : $(e.target);
				var ag = list.nestable('serialize');
				var treeIdOrder = JSON.stringify(ag);
				$.ajax({
					url:App.domain()+"/updateTree",
					data:{treeIdOrder:treeIdOrder},
					success: function(da){
						if(da.code==0){
						}else{
						}
						App.unblockUI();
					},
					error: function(a,b,c){
						var status = a.status;
						if(b=='timeout'){
							bootbox.alert("不好意思  超时了 ");
						}else{
							App.errorAlertStatus(status);
						}
						App.unblockUI();
					}
				});
			}
			$("#addtreeid").on("click",function(){
				$("#fenpeiquanxian").modal("show");
				$("#editsystreeid").val("");
				$("#treeFDivid").hide();
				$("#addOrEditTreeFormId")[0].reset();
				$("#treeFSelectId").val("");
			});
			$("#nestable_list_3").on("click",".editTreeClass",function(){
				var treeId = $(this).parent().parent().data("id");
				$.ajax({
					url:App.domain()+"/selectOneById",
					data:{id:treeId},
					success: function(da){
						$("#fenpeiquanxian").modal("show");
						$("#editsystreeid").val(treeId);
						$("input[name='chName']").val(da.chName);
						$("input[name='enName']").val(da.enName);
						$("input[name='treeIcon']").val(da.treeIcon);
						$("input[name='treeUrl']").val(da.treeUrl);
						$("#treeNoSelectId").val(da.treeNo-1);
						$("#treeTypeSelectId").val(da.treeType);
						var parentId = da.parentId;
						if(parentId!=0){
							$.ajax({
								url:App.domain()+"/selectTreeNo",
								data:{treeNo:(new Number(da.treeNo)-1)},
								success: function(da){
									if(da.code==0){
										var dat = da.data;
										var html = "";
										for(var i in dat){
											var map = dat[i];
											var mid = map.id;
											var mtext = map.text;
											if(mid==parentId){
												html += "<option value='"+mid+"' selected='selected' >"+mtext+"</option>";
											}else{
												html += "<option value='"+mid+"'>"+mtext+"</option>";
											}
										}
										$("#treeFSelectId").html(html);
										$("#treeFDivid").show();
									}else{
										bootbox.alert(da.mes);
									}
									App.unblockUI();
								},
								error: function(a,b,c){
									var status = a.status;
									if(b=='timeout'){
										bootbox.alert("不好意思  超时了 ");
									}else{
										App.errorAlertStatus(status);
									}
									App.unblockUI();
								}
							});
						}
						App.unblockUI();
					},
					error: function(a,b,c){
						var status = a.status;
						if(b=='timeout'){
							bootbox.alert("不好意思  超时了 ");
						}else{
							App.errorAlertStatus(status);
						}
						App.unblockUI();
					}
				});
			});
			$("#nestable_list_3").on("click",".deleteTreeClass",function(){
				var treeId = $(this).parent().parent().data("id");
				var thisLi = $(this).parent().parent();
		    	var isOverLenth = thisLi.parent().children().length;
		    	if (confirm("确定要删除数据吗？")) { 
		    		$.ajax({
						url:App.domain()+"/deleteTree",
						data:{id:(new Number(treeId))},
						success: function(da){
							if(da.code==0){
								if (isOverLenth==1) {
					    			var zhedieDiv = thisLi.parent().parent();
					    			if (zhedieDiv.children().length>1) { 
					    				zhedieDiv.children()[1].remove();
					    			};
					    			zhedieDiv.children()[0].remove();
					    			thisLi.parent().remove();
					    		}else{ 
					    			thisLi.remove();
					    		}
							}else{
								bootbox.alert(da.mes);
							}
							App.unblockUI();
						},
						error: function(a,b,c){
							var status = a.status;
							if(b=='timeout'){
								bootbox.alert("不好意思  超时了 ");
							}else{
								App.errorAlertStatus(status);
							}
							App.unblockUI();
						}
					});
		    	}
			});
			$("#treeNoSelectId").on("change",function(){
				var treeNoVal = $(this).val();
				if(treeNoVal==0){
					$("#treeFDivid").hide();
					$("#treeFSelectId").val("");
				}else{
					$("#treeFDivid").show();
					$.ajax({
						url:App.domain()+"/selectTreeNo",
						data:{treeNo:(new Number(treeNoVal))},
						success: function(da){
							if(da.code==0){
								var dat = da.data;
								var html = "";
								for(var i in dat){
									var map = dat[i];
									var mid = map.id;
									var mtext = map.text;
									html += "<option value='"+mid+"'>"+mtext+"</option>";
								}
								$("#treeFSelectId").html(html);
							}else{
								bootbox.alert(da.mes);
							}
							App.unblockUI();
						},
						error: function(a,b,c){
							var status = a.status;
							if(b=='timeout'){
								bootbox.alert("不好意思  超时了 ");
							}else{
								App.errorAlertStatus(status);
							}
							App.unblockUI();
						}
					});
				}
			});
			$(".addTreeButtonClass").on("click",function(){
				var treeCnName = $("input[name='chName']").val();
				var treeEnName = $("input[name='enName']").val();
				var treeUrl = $("input[name='treeUrl']").val();
				if(treeCnName==null||treeCnName==""||treeCnName==undefined){
					bootbox.alert("请填写权限中文名称");
					return false;
				}
				if(treeEnName==null||treeEnName==""||treeEnName==undefined){
					bootbox.alert("请填写权限英文名称");
					return false;
				}
// 				if(treeUrl==null||treeUrl==""||treeUrl==undefined){
// 					bootbox.alert("请填写权限地址");
// 					return false;
// 				}
				var data= $("#addOrEditTreeFormId").serializeArray();
				$.ajax({
					url:App.domain()+"/addTree",
					data:data,
					success: function(da){
						if(da.code==0){
							location.href = location.href;
						}else{
							bootbox.alert(da.mes);
						}
						App.unblockUI();
					},
					error: function(a,b,c){
						var status = a.status;
						if(b=='timeout'){
							bootbox.alert("不好意思  超时了 ");
						}else{
							App.errorAlertStatus(status);
						}
						App.unblockUI();
					}
				});
			});
		});
	</script>
 </body>
</html>
