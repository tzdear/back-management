<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TestFile.jsp' starting page</title>
    
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
        <link href="<%=basePath %>theme/assets/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	/*a  upload */
	.a-upload {
	    padding: 4px 10px;
	    height: 20px;
	    line-height: 20px;
	    position: relative;
	    cursor: pointer;
	    color: #888;
	    background: #fafafa;
	    border: 1px solid #ddd;
	    border-radius: 4px;
	    overflow: hidden;
	    display: inline-block;
	    *display: inline;
	    *zoom: 1
	}
	
	.a-upload  input {
	    position: absolute;
	    font-size: 100px;
	    right: 0;
	    top: 0;
	    opacity: 0;
	    filter: alpha(opacity=0);
	    cursor: pointer
	}
	
	.a-upload:hover {
	    color: #444;
	    background: #eee;
	    border-color: #ccc;
	    text-decoration: none
	}
	.file {
	    position: relative;
	    display: inline-block;
	    background: #D0EEFF;
	    border: 1px solid #99D3F5;
	    border-radius: 4px;
	    padding: 4px 12px;
	    overflow: hidden;
	    color: #1E88C7;
	    text-decoration: none;
	    text-indent: 0;
	    line-height: 20px;
	}
	.file input {
	    position: absolute;
	    font-size: 100px;
	    right: 0;
	    top: 0;
	    opacity: 0;
	}
	.file:hover {
	    background: #AADFFD;
	    border-color: #78C3F3;
	    color: #004974;
	    text-decoration: none;
	}
	</style>
  </head>
  
  <body>
    <div id="son" style="width:95%">
    	<span class="irs js-irs-0" style="height: 40px;position: relative;display: block;-webkit-touch-callout: none;-webkit-user-select: none;-khtml-user-select: none;-moz-user-select: none;-ms-user-select: none;user-select: none;">
   			<span class="irs">
   				<span class="irs-line" style="height: 12px; position: relative;display: block;overflow: hidden;outline: none !important; top: 25px;" tabindex="-1">
   					<span class="irs-line-mid" style="width:100%; margin-left: 1%; height: 12px; background-position: 0 0px; position: absolute; display: block; top: 0;  background: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQQAAAC0BAMAAACAm0/4AAAAG1BMVEUAAADh5Onlt8Dh5OntVWXh5OntVWWkNUDaRFOm5Bg2AAAABXRSTlMA8SatrXO/UNAAAAC/SURBVHja7dYhDgIxEIbRZgWgIXgweARXWE9IPQrNETg6GQ9JV81k894JPtFO/tbTSZAgQYKEqgkAAIyYrj3V4dTOPdm+3XqyRzv2ZPcKI76nkxAqPMcCn7LAaSpwoAEAGPFKJ0GCBAkSqiYAADBimtNX1CV/yM35CQXmrAQJhRIKfMoCp6nAgQYAYNDm2bLtPm0hCUFCkBAkBAlBQpAQ1phQYLIAwD/bd1tIQpAQJAQJQUKQECQECWGNCQDwyxeVdc3fxNBs+QAAAABJRU5ErkJggg==') repeat-x;"></span>
   				</span>
   				<span class="irs-single" id="irs-single" style="left: 0.5%;color: #fff;font-size: 10px; line-height: 1.333; text-shadow: none;padding: 1px 5px;background: #ed5565;-moz-border-radius: 4px; border-radius: 4px;    position: absolute; display: block;top: 0;cursor: default; white-space: nowrap;">0</span>
   			</span><span class="irs-grid" style="position: absolute; display: none;bottom: 0;left: 0; width: 100%; height: 20px;"></span>
   			<span class="irs-bar" id="irs-bar" style=" width: 0%;   margin-left: 1%; height: 12px;  top: 25px;     background: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQQAAAC0BAMAAACAm0/4AAAAG1BMVEUAAADh5Onlt8Dh5OntVWXh5OntVWWkNUDaRFOm5Bg2AAAABXRSTlMA8SatrXO/UNAAAAC/SURBVHja7dYhDgIxEIbRZgWgIXgweARXWE9IPQrNETg6GQ9JV81k894JPtFO/tbTSZAgQYKEqgkAAIyYrj3V4dTOPdm+3XqyRzv2ZPcKI76nkxAqPMcCn7LAaSpwoAEAGPFKJ0GCBAkSqiYAADBimtNX1CV/yM35CQXmrAQJhRIKfMoCp6nAgQYAYNDm2bLtPm0hCUFCkBAkBAlBQpAQ1phQYLIAwD/bd1tIQpAQJAQJQUKQECQECWGNCQDwyxeVdc3fxNBs+QAAAABJRU5ErkJggg==') repeat-x;  background-position: 0 -60px;  position: absolute;display: block;left:0;"></span>
   		</span>
    </div>
    <div class="row" style="height: 90px;">
    	<div class="col-md-2"></div>
    	<div class="col-md-2"></div>
    	<div class="col-md-2"></div>
    	<div class="col-md-2"></div>
    	<div class="col-md-2"></div>
    </div>
    	<input id="uploasd" multiple="multiple" name="file" type="file"/>
    <div class="row">
    	<div class="col-md-2"></div>
    	<div class="col-md-2">
	    	
	    </div>
    	<div class="col-md-2"></div>
    	<div class="col-md-2"></div>
    	<div class="col-md-2"></div>
    </div>
    <div class="modal fade" id="modalidag">
    	<div class="row" style="height: 90px;">
	    	<div class="col-md-2"></div>
	    	<div class="col-md-2"></div>
	    	<div class="col-md-2"></div>
	    	<div class="col-md-2"></div>
	    	<div class="col-md-2"></div>
	    </div>
    	<div class="row">
    		<div class="col-md-2"></div>
    		<div class="col-md-2">
    			<form action="">
			    	<input id="upload" multiple="multiple" name="file" type="file"/>
			    </form>
    		</div>
    		<div class="col-md-2"></div>
    	</div>
    </div>
    
    
    
    <button id="gjgj">哦离开过</button>
    
   
    
    <script src="<%=basePath %>theme/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
  	<script src="<%=basePath %>theme/script/test/testFile.js" type="text/javascript"></script>
  	<script src="<%=basePath %>theme/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  </body>
  <script type="text/javascript">
	$("#modalidag").modal("show");
  </script>
</html>
