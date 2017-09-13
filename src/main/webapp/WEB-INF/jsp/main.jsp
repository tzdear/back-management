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
        <link rel="icon" type="image/png" href="<%=basePath %>theme/assets/global/img/favicon32-32.ico" sizes="32x32" />
		<link rel="icon" type="image/png" href="<%=basePath %>theme/assets/global/img/favicon16-16.ico" sizes="16x16" />
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
        </style>
        
  </head>

  <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
        <div class="page-wrapper">
            <c:import url="header.jsp"></c:import> 
            <div class="clearfix"> </div>
            <div class="page-container">
                <div class="page-sidebar-wrapper">
                    <div class="page-sidebar navbar-collapse collapse">
                        <c:import url="menu.jsp"></c:import>
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
                        	<div class="col-md-2"></div>
                            <div class="col-md-8">
                            	<div class="row">
                            		<div class="col-md-2"></div>
                            		<div class="col-md-8">
                            			
                            			<img alt="" style="width: 100%;" src="<%=basePath%>theme/img/timg.gif">
                            		</div>
                            		<div class="col-md-2"></div>
                            	</div>
                            </div>
                            <div class="col-md-2"></div>
                        </div>
                    </div>
                </div>
            </div>
            <c:import url="bottom.jsp"></c:import>
        </div>
        <div class="quick-nav-overlay"></div>
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
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="<%=basePath %>theme/assets/global/scripts/app.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="<%=basePath %>theme/assets/layouts/layout/scripts/layout.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/layout/scripts/menu.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/layout/scripts/demo.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
        <script src="<%=basePath %>theme/assets/layouts/global/scripts/quick-nav.min.js" type="text/javascript"></script>
     	<script src="<%=basePath %>theme/script/stomp/sockjs.min.js" type="text/javascript"></script>
     	<script src="<%=basePath %>theme/script/stomp/stomp.js?v=4" type="text/javascript"></script>
     	<script src="<%=basePath %>theme/script/stomp/stompClient.js" type="text/javascript"></script>
     <!-- END THEME LAYOUT SCRIPTS -->
     <script>

	</script>
 </body>
</html>
