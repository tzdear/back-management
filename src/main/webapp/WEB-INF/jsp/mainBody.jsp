<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mainBody.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<!-- BEGIN CONTENT BODY -->
    <div class="page-bar">
        <ul class="page-breadcrumb">
            <li>
                <a href="index.html">首页</a>
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
  </body>
</html>
