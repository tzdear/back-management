<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="page-header navbar navbar-fixed-top">
<input type="hidden" value="${basePath }" id="doMainURL"/>
     <!-- BEGIN HEADER INNER -->
     <div class="page-header-inner ">
         <!-- BEGIN LOGO -->
         <div class="page-logo">
             <a href="index.html">
                 <img src="<%=basePath %>theme/assets/layouts/layout/img/logo.png" alt="logo" class="logo-default" /> </a>
             <div class="menu-toggler sidebar-toggler">
                 <span></span>
             </div>
         </div>
         <!-- END LOGO -->
         <!-- BEGIN RESPONSIVE MENU TOGGLER -->
         <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
             <span></span>
         </a>
         <!-- END RESPONSIVE MENU TOGGLER -->
         <!-- BEGIN TOP NAVIGATION MENU -->
         <div class="top-menu">
             <ul class="nav navbar-nav pull-right">
                 <!-- BEGIN NOTIFICATION DROPDOWN -->
                 <!-- DOC: Apply "dropdown-dark" class after "dropdown-extended" to change the dropdown styte -->
                 <!-- DOC: Apply "dropdown-hoverable" class after below "dropdown" and remove data-toggle="dropdown" data-hover="dropdown" data-close-others="true" attributes to enable hover dropdown mode -->
                 <!-- DOC: Remove "dropdown-hoverable" and add data-toggle="dropdown" data-hover="dropdown" data-close-others="true" attributes to the below A element with dropdown-toggle class -->
                 <!-- END NOTIFICATION DROPDOWN -->
                 <!-- BEGIN INBOX DROPDOWN -->
                 <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                 <!-- END INBOX DROPDOWN -->
                 <!-- BEGIN TODO DROPDOWN -->
                 <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                 <li class="dropdown dropdown-extended dropdown-tasks" id="header_task_bar">
                     <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                         <i class="icon-calendar"></i>
                         <span class="badge badge-default"> 2 </span>
                     </a>
                     <ul class="dropdown-menu extended tasks">
                         <li class="external">
                             <h3>您有
                                 <span class="bold">12 个待定</span> 任务</h3>
                             <a href="app_todo.html">查看所有</a>
                         </li>
                         <li>
                             <ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
                                 <li>
                                     <a href="javascript:;">
                                         <span class="task">
                                             <span class="desc">项目开发</span>
                                             <span class="percent">65%</span>
                                         </span>
                                         <span class="progress">
                                             <span style="width: 65%;" class="progress-bar progress-bar-danger" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100">
                                                 <span class="sr-only">65% Complete</span>
                                             </span>
                                         </span>
                                     </a>
                                 </li>
                                 <li>
                                     <a href="javascript:;">
                                         <span class="task">
                                             <span class="desc">数据迁移</span>
                                             <span class="percent">10%</span>
                                         </span>
                                         <span class="progress">
                                             <span style="width: 10%;" class="progress-bar progress-bar-warning" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100">
                                                 <span class="sr-only">10% Complete</span>
                                             </span>
                                         </span>
                                     </a>
                                 </li>
                             </ul>
                         </li>
                     </ul>
                 </li>
                 <!-- END TODO DROPDOWN -->
                 <!-- BEGIN USER LOGIN DROPDOWN -->
                 <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                 <li class="dropdown dropdown-user">
                     <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                         <img alt="" class="img-circle" src="<%=basePath %>theme/assets/layouts/layout/img/avatar3_small.jpg" />
                         <span class="username username-hide-on-mobile"> linyan </span>
                         <i class="fa fa-angle-down"></i>
                     </a>
                     <ul class="dropdown-menu dropdown-menu-default">
                         <li>
                             <a href="page_user_profile_1.html">
                                 <i class="icon-user"></i> 个人资料 </a>
                         </li>
                         <li>
                             <a href="app_calendar.html">
                                 <i class="icon-calendar"></i> 记事本 </a>
                         </li>
                         <li>
                             <a href="app_inbox.html">
                                 <i class="icon-envelope-open"></i> 收件箱
                                 <span class="badge badge-danger"> 3 </span>
                             </a>
                         </li>
                         <li>
                             <a href="app_todo.html">
                                 <i class="icon-rocket"></i> 任务
                                 <span class="badge badge-success"> 2 </span>
                             </a>
                         </li>
                         <li class="divider"> </li>
                         <li>
                             <a href="page_user_lock_1.html">
                                 <i class="icon-lock"></i> 锁屏 </a>
                         </li>
                         <li>
                             <a href="page_user_login_1.html">
                                 <i class="icon-key"></i> 退出 </a>
                         </li>
                     </ul>
                 </li>
                 <!-- END USER LOGIN DROPDOWN -->
                 <!-- BEGIN QUICK SIDEBAR TOGGLER -->
                 <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                 <li class="dropdown dropdown-quick-sidebar-toggler hide">
                     <a href="javascript:;" class="dropdown-toggle">
                         <i class="icon-logout"></i>
                     </a>
                 </li>
                 <!-- END QUICK SIDEBAR TOGGLER -->
             </ul>
         </div>
         <!-- END TOP NAVIGATION MENU -->
     </div>
     <!-- END HEADER INNER -->
 </div>