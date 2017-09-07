<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理</title>
    
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="#1 selling multi-purpose bootstrap admin theme sold in themeforest marketplace packed with angularjs, material design, rtl support with over thausands of templates and ui elements and plugins to power any type of web applications including saas and admin dashboards. Preview page of Theme #5 for "
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
    <link href="<%=basePath %>theme/assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath %>theme/assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="<%=basePath %>theme/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
    <link href="<%=basePath %>theme/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME GLOBAL STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link href="<%=basePath %>theme/assets/pages/css/login-2.min.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL STYLES -->
    <!-- BEGIN THEME LAYOUT STYLES -->
    <!-- END THEME LAYOUT STYLES -->
    <link rel="shortcut icon" href="favicon.ico" />

  </head>

  <body class=" login">
     <!-- BEGIN LOGO -->
     <div class="logo">
         <a href="index.html">
             <img src="<%=basePath %>theme/assets/pages/img/logo-big-white.png" style="height: 17px;" alt="" /> </a>
     </div>
     <!-- END LOGO -->
     <!-- BEGIN LOGIN -->
     <div class="content">
         <!-- BEGIN LOGIN FORM -->
         <form class="login-form" action="index.html" method="post">
             <div class="form-title">
                 <span class="form-title">欢迎观临.</span>
                 <span class="form-subtitle">请登录.</span>
             </div>
             <div class="alert alert-danger display-hide">
                 <button class="close" data-close="alert"></button>
                 <span> 请输入您的用户名和密码. </span>
             </div>
             <div class="form-group">
                 <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                 <label class="control-label visible-ie8 visible-ie9">用户名</label>
                 <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="请输入您的用户名" name="userName" /> </div>
             <div class="form-group">
                 <label class="control-label visible-ie8 visible-ie9">密码</label>
                 <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="请输入您的密码" name="userPass" /> </div>
             <div class="form-actions">
                 <button type="submit" class="btn red btn-block uppercase">登录</button>
             </div>
             <div class="form-actions">
                 <div class="pull-left">
                     <label class="rememberme mt-checkbox mt-checkbox-outline">
                         <input type="checkbox" name="remenber" value="1" /> 记住用户名密码
                         <span></span>
                     </label>
                 </div>
                 <div class="pull-right forget-password-block">
                     <a href="javascript:;" id="forget-password" class="forget-password">忘记密码?</a>
                 </div>
             </div>
         </form>
         <!-- END LOGIN FORM -->
         <!-- BEGIN FORGOT PASSWORD FORM -->
         <form class="forget-form" action="index.html" method="post">
             <div class="form-title">
                 <span class="form-title">找回密码 ?</span>
                 <span class="form-subtitle">请输入您的手机号</span>
             </div>
             <div class="form-group">
                 <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="请输入您的手机号" name="telPhone" /> </div>
             <div class="form-actions">
                 <button type="button" id="back-btn" class="btn btn-default">返回</button>
                 <button type="submit" class="btn btn-primary uppercase pull-right">确定</button>
             </div>
         </form>
         <!-- END FORGOT PASSWORD FORM -->
     </div>
     <div class="copyright hide">  </div>
     <!-- END LOGIN -->
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
     <script src="<%=basePath %>theme/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
     <script src="<%=basePath %>theme/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
     <!-- END PAGE LEVEL PLUGINS -->
     <!-- BEGIN THEME GLOBAL SCRIPTS -->
     <script src="<%=basePath %>theme/assets/global/scripts/app.js" type="text/javascript"></script>
     <!-- END THEME GLOBAL SCRIPTS -->
     <!-- BEGIN PAGE LEVEL SCRIPTS -->
     <script src="<%=basePath %>theme/assets/pages/scripts/login.js" type="text/javascript"></script>
     <!-- END PAGE LEVEL SCRIPTS -->
     <!-- BEGIN THEME LAYOUT SCRIPTS -->
     <!-- END THEME LAYOUT SCRIPTS -->
 </body>
</html>
