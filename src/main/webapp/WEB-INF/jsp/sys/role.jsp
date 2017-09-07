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
        <link href="<%=basePath %>theme/assets/global/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=basePath %>theme/assets/global/plugins/jquery-multi-select/css/multi-select.css" rel="stylesheet" type="text/css" />
        <link href="<%=basePath %>theme/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
        <link href="<%=basePath %>theme/assets/global/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" type="text/css" />
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
        .ms-container{
        	width:100%;
        }
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
					                <a href="index.html">系统管理</a>
					                <i class="fa fa-circle"></i>
					            </li>
					            <li>
					                <a href="index.html">角色管理</a>
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
						                    <span class="caption-subject font-dark sbold uppercase">角色管理</span>
						                </div>
						                <div class="actions">
						                    <div class="btn-group btn-group-devided" data-toggle="buttons">
						                        <label class="btn btn-transparent grey-salsa btn-outline btn-circle btn-sm" id="addroleid">
					                            	添加角色
					                            </label>
						                    </div>
						                </div>
						            </div>
						            <div class="portlet-body">
						                <div class="table-container">
						                    <table class="table table-striped table-bordered table-hover table-checkable" id="datatable_ajax_role">
						                        <thead>
						                            <tr role="row" class="heading">
					<!-- 	                                <th width="2%"> -->
					<!-- 	                                    <label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"> -->
					<!-- 	                                        <input type="checkbox" class="group-checkable" data-set="#sample_2 .checkboxes" /> -->
					<!-- 	                                        <span></span> -->
					<!-- 	                                    </label> -->
					<!-- 	                                </th> -->
						                                <th style="width: 10%;"> 主键 </th>
						                                <th style="width: 60%;"> 角色名称 </th>
						                                <th style="width: 30%;"> 操作 </th>
						                            </tr>
						                            <tr role="row" class="filter">
					<!-- 	                                <td> </td> -->
						                                <td>
						                                    <input type="text" class="form-control form-filter input-sm" name="roleId"> </td>
						                                <td>
						                                    <input type="text" class="form-control form-filter input-sm" name="roleName"> </td>
						                                <td>
						                                    <div class="margin-bottom-5">
						                                        <button class="btn btn-sm green btn-outline filter-submit margin-bottom">
						                                            <i class="fa fa-search"></i> 搜索</button>
						                                            <button class="btn btn-sm red btn-outline filter-cancel">
						                                        <i class="fa fa-times"></i> 重置</button>
						                                    </div>
						                                </td>
						                            </tr>
						                        </thead>
						                        <tbody> </tbody>
						                    </table>
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
        
        <div class="modal fade" id="fenpeiquanxian" tabindex="-1" role="dialog" style="top:0px;">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">分配权限</h4>
		      </div>
		      <div class="modal-body">
		      <div class="row">
		      	<div class="col-md-12">
		      		<input type="hidden" name="editRoleType" id="editRoleType"/>
		      		<form action="" id="role-form-id">
		      			<input type="hidden" name="sysroleid" id = "editsysroleid"/>
		      			<div class="form-body" id="formbodyid">
                            
                        </div>
                        <div class="form-actions center">
                            <button type="button" class="btn btn-default default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn green save-role-class">提交</button>
<!--                             <button type="submit" class="btn green">提交</button> -->
                        </div>
		      		</form>
                </div>
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
        <script src="<%=basePath %>theme/assets/global/plugins/jstree/dist/jstree.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="<%=basePath %>theme/assets/global/scripts/app.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/global/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
         <script src="<%=basePath %>theme/script/sys/table-datatables-ajax-role.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="<%=basePath %>theme/assets/layouts/layout/scripts/layout.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/layout/scripts/menu.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/layout/scripts/demo.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/global/scripts/quick-nav.min.js" type="text/javascript"></script>
        <script type="text/javascript">
        	jQuery(document).ready(function() {
        		$("#datatable_ajax_role").on("click",".editroleclass",function(){
        			var roleid = $(this).data("id");
        			var roleName = $(this).data("name");
        			$("#editsysroleid").val(roleid);
        			$("#editRoleType").val(2);
        			$("#formbodyid").html('<div class="form-group">'+
                               ' <label class="control-label col-md-2" >角色名称</label>'+
                               ' <div class="col-md-6">'+
                                '    <input class="form-control form-control-inline" name="roleName" type="text" value="'+roleName+'" placeholder="请输入角色名称" >'+
                                '</div>'+
                           ' </div>');
                    $("#fenpeiquanxian").modal("show");
//         			alert(roleid);
        		});
        		$("#datatable_ajax_role").on("click",".deleteroleclass",function(){
        			var roleid = $(this).data("id");
        			alert(roleid);
        		});
        		$("#datatable_ajax_role").on("click",".giveperclass",function(){
        			var roleid = $(this).data("id");
        			$("#editsysroleid").val(roleid);
        			$("#editRoleType").val(1);
        			$("#formbodyid").html("<div class='form-group' id='preTreeid'></div>");
        			$('#preTreeid').jstree({
			            'plugins': ["wholerow", "checkbox", "types"],
			            'core': {
			                "themes" : {
			                    "responsive": false
			                },    
			                'data': {
							        "url" : App.domain()+"/giveRoleTree",
							        "dataType" : "json" ,
							        "data":function(){
							        	return {id:roleid};
							        }
							      }
			            },
			            "checkbox":{
			            	"cascade":"up",
			            	"three_state":false
			            },
			            "types" : {
			                "default" : {
			                    "icon" : "fa fa-folder icon-state-warning icon-lg"
			                },
			                "file" : {
// 			                    "icon" : "fa fa-file icon-state-warning icon-lg"
			                }
			            }
			        });
        			$("#fenpeiquanxian").modal("show");
//         			alert(roleid);
        		});
        		
        		$("#addroleid").on("click",function(){
        			$("#editsysroleid").val("");
        			$("#editRoleType").val(3);
        			$("#formbodyid").html('<div class="form-group">'+
                               ' <label class="control-label col-md-2">角色名称</label>'+
                               ' <div class="col-md-6">'+
                                '    <input class="form-control form-control-inline" name="roleName" type="text" value="" placeholder="请输入角色名称" >'+
                                '</div>'+
                           ' </div>');
                    $("#fenpeiquanxian").modal("show");
        		});
        	
        		$(".save-role-class").on("click",function(){
        			var roleid = $("#editsysroleid").val();
        			var editRoleType = $("#editRoleType").val();
        			if(editRoleType == 1){
        				var nodes=$("#preTreeid").jstree().get_checked();
//         				alert("分配权限"+nodes);
        				App.blockUI({zIndex:11111});
						$.ajax({
							url:App.domain()+"/editRoleTree",
							data:{roleid:roleid,treeids:nodes},
							success: function(da){
								if(da.code!=0){
									bootbox.alert(da.mes);
								}else{
									$("#fenpeiquanxian").modal("hide");
								}
								App.unblockUI();
							},
							error: function(a,b,c){
								var status = a.status;
								if(b=='timeout'){
									bootbox.alert("不好意思  超时了 ");
								}else{
									switch(status)
									{
									case 401:
									  bootbox.alert("不好意思 访问被拒绝401 ");
									  break;
									case 403:
									  bootbox.alert("不好意思 禁止访问403");
									  break;
									case 404:
									  bootbox.alert("不好意思 未找到404");
									  break;
									case 405:
									  bootbox.alert("不好意思 用来访问本页面的HTTP谓词不被允许（方法不被允许）405");
									  break;
									case 406:
									  bootbox.alert("不好意思 客户端浏览器不接受所请求页面的MIME类型 406");
									  break;
									case 407:
									  bootbox.alert("不好意思 要求进行代理身份验证 407");
									  break;
									case 412:
									  bootbox.alert("不好意思 前提条件失败 412");
									  break;
									case 413:
									  bootbox.alert("不好意思 请求实体太大 413");
									  break;
									case 414:
									  bootbox.alert("不好意思 请求URI太长 414");
									  break;
									case 415:
									  bootbox.alert("不好意思 不支持的媒体类型 415");
									  break;
									case 416:
									  bootbox.alert("不好意思 所请求的范围无法满足 416");
									  break;
									case 423:
									  bootbox.alert("不好意思 锁定的错误 423");
									  break;
									case 500:
									  bootbox.alert("不好意思 内部服务器错误 500");
									  break;
									case 501:
									  bootbox.alert("不好意思 页眉值指定了未实现的配置 501");
									  break;
									case 502:
									  bootbox.alert("不好意思 Web服务器用作网关或代理服务器时收到了无效响应 502");
									  break;
									case 504:
									  bootbox.alert("不好意思 网关超时 504");
									  break;
									case 505:
									  bootbox.alert("不好意思 HTTP版本不受支持 504");
									  break;
									default:
									  bootbox.alert("不好意思 出现了 错误 ");
									}
								}
								App.unblockUI();
							}
						});
        			}else if(editRoleType == 2){
        				var data = $("#role-form-id").serializeArray();
//         				alert("修改角色"+data);
        				App.blockUI({zIndex:11111});
						$.ajax({
							url:App.domain()+"/addOrEditRole",
							data:data,
							success: function(da){
								if(da.code==0){
									$("#fenpeiquanxian").modal("hide");
									$('#datatable_ajax_role').DataTable().ajax.reload(); 
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
									switch(status)
									{
									case 401:
									  bootbox.alert("不好意思 访问被拒绝401 ");
									  break;
									case 403:
									  bootbox.alert("不好意思 禁止访问403");
									  break;
									case 404:
									  bootbox.alert("不好意思 未找到404");
									  break;
									case 405:
									  bootbox.alert("不好意思 用来访问本页面的HTTP谓词不被允许（方法不被允许）405");
									  break;
									case 406:
									  bootbox.alert("不好意思 客户端浏览器不接受所请求页面的MIME类型 406");
									  break;
									case 407:
									  bootbox.alert("不好意思 要求进行代理身份验证 407");
									  break;
									case 412:
									  bootbox.alert("不好意思 前提条件失败 412");
									  break;
									case 413:
									  bootbox.alert("不好意思 请求实体太大 413");
									  break;
									case 414:
									  bootbox.alert("不好意思 请求URI太长 414");
									  break;
									case 415:
									  bootbox.alert("不好意思 不支持的媒体类型 415");
									  break;
									case 416:
									  bootbox.alert("不好意思 所请求的范围无法满足 416");
									  break;
									case 423:
									  bootbox.alert("不好意思 锁定的错误 423");
									  break;
									case 500:
									  bootbox.alert("不好意思 内部服务器错误 500");
									  break;
									case 501:
									  bootbox.alert("不好意思 页眉值指定了未实现的配置 501");
									  break;
									case 502:
									  bootbox.alert("不好意思 Web服务器用作网关或代理服务器时收到了无效响应 502");
									  break;
									case 504:
									  bootbox.alert("不好意思 网关超时 504");
									  break;
									case 505:
									  bootbox.alert("不好意思 HTTP版本不受支持 504");
									  break;
									default:
									  bootbox.alert("不好意思 出现了 错误 ");
									}
								}
								App.unblockUI();
							}
						});
        			}else if(editRoleType == 3){
        				var data = $("#role-form-id").serializeArray();
        				alert("添加角色"+data);
        				App.blockUI({zIndex:11111});
						$.ajax({
							url:App.domain()+"/addOrEditRole",
							data:data,
							success: function(da){
								if(da.code==0){
									$("#fenpeiquanxian").modal("hide");
									$('#datatable_ajax_role').DataTable().ajax.reload(); 
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
									switch(status)
									{
									case 401:
									  bootbox.alert("不好意思 访问被拒绝401 ");
									  break;
									case 403:
									  bootbox.alert("不好意思 禁止访问403");
									  break;
									case 404:
									  bootbox.alert("不好意思 未找到404");
									  break;
									case 405:
									  bootbox.alert("不好意思 用来访问本页面的HTTP谓词不被允许（方法不被允许）405");
									  break;
									case 406:
									  bootbox.alert("不好意思 客户端浏览器不接受所请求页面的MIME类型 406");
									  break;
									case 407:
									  bootbox.alert("不好意思 要求进行代理身份验证 407");
									  break;
									case 412:
									  bootbox.alert("不好意思 前提条件失败 412");
									  break;
									case 413:
									  bootbox.alert("不好意思 请求实体太大 413");
									  break;
									case 414:
									  bootbox.alert("不好意思 请求URI太长 414");
									  break;
									case 415:
									  bootbox.alert("不好意思 不支持的媒体类型 415");
									  break;
									case 416:
									  bootbox.alert("不好意思 所请求的范围无法满足 416");
									  break;
									case 423:
									  bootbox.alert("不好意思 锁定的错误 423");
									  break;
									case 500:
									  bootbox.alert("不好意思 内部服务器错误 500");
									  break;
									case 501:
									  bootbox.alert("不好意思 页眉值指定了未实现的配置 501");
									  break;
									case 502:
									  bootbox.alert("不好意思 Web服务器用作网关或代理服务器时收到了无效响应 502");
									  break;
									case 504:
									  bootbox.alert("不好意思 网关超时 504");
									  break;
									case 505:
									  bootbox.alert("不好意思 HTTP版本不受支持 504");
									  break;
									default:
									  bootbox.alert("不好意思 出现了 错误 ");
									}
								}
								App.unblockUI();
							}
						});
        			}else{
        				alert("其他");
        			}
        		});
        	
        	});
        </script>
   </body>
</html>
