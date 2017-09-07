<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>404</title>
    
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
    <div class="row">
    	<div class="col-md-2"></div>
    	<div class="col-md-8">
    		<div class="row"></div>
    		<div class="row">
    			<div class="col-md-8">
    				<div class="row" style="color:#5487bdad">
    					<div class="col-md-3">
    						<h1>4</h1>
    					</div>
    					<div class="col-md-3">
    						<h1>0</h1>
    					</div>
    					<div class="col-md-3">
    						<h1>4</h1>
    					</div>
    				</div>
    			</div>
    			<div class="col-md-4">
    				<div class="row"></div>
    				<div class="row"></div>
    				<div class="row">
    					<a href="javascript:window.history.go(-1);" >返回上一页</a>
    				</div>
    			</div>
    		</div>
    	</div>
    	<div class="col-md-2"></div>
    </div>
  </body>
</html>
