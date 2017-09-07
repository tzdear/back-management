<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'agg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="/liuliu/theme/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/liuliu/theme/script/main.css" rel="stylesheet">
    <script src="/liuliu/theme/assets/global/plugins/jquery.min.js"></script>
    <script src="/liuliu/theme/script/sockjs.min.js"></script>
    <script src="/liuliu/theme/script/stomp.js"></script>
    <script src="/liuliu/theme/script/app.js"></script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <button id ="sendws">alkjgl</button>
  </body>
  
  
  <script type="text/javascript">
  	function openWs(){
    websocket = new SockJS("http://localhost:80/liuliu" + "/webServer");
 
    var stompClient = Stomp.over(websocket);
    stompClient.connect({}, function(frame) {
        stompClient.subscribe('/topic/hello',  function(data) { //订阅消息
            console.log("收到topic消息："+data.body);//body中为具体消息内容
        });
        stompClient.subscribe('/user/' + 123 + '/message', function(message){
            console.log("收到session消息："+message.body);//body中为具体消息内容
        });
    });
 
    document.getElementById("sendws").onclick = function() {
        stompClient.send("/app/message", {}, JSON.stringify({
            name: "nane",
            msg: "发送的消息aaa"
        }));
    }
    
}
//关闭连接
function wsClose() {
    websocket.close();
}
  openWs();
  </script>
</html>
