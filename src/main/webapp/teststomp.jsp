<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
<title>Hello WebSocket</title>
<script src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.min.js"></script>
<script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">  
        $(document).ready(function(){  
            connect();  
            //checkoutUserlist();  
        });  
  
  
  $(function () {  
       var wsUrl = "ws://"+window.location.host+"/liuliu/hello"  
       var sock = new WebSocket(wsUrl);  
  
  
//       var SockJSUrl = "http://"+window.location.host+"/japi-rest/marco"  
//       var sock = new SockJS(SockJSUrl);  
  
       sock.onopen = function() {  
           console.log('Opening');  
           sayMarco();  
       }  
  
       sock.onmessage = function(e) {  
           console.log('Received message: ', e.data);  
//            $('#output').append('Received "' + e.data + '"<br/>');  
           setTimeout(function(){sayMarco()}, 2000);  
       }  
  
       sock.onclose = function() {  
           console.log('Closing');  
       }  
  
       function sayMarco() {  
           console.log('Sending Marco!');  
//            $('#output').append('Sending "Marco!"<br/>');  
           sock.send("Marco!");  
       }  
  
//        $('#stop').click(function() {sock.close()});  
   })  
  
        var stompClient = null;  
  
        function setConnected(connected) {  
            document.getElementById('connect').disabled = connected;  
            document.getElementById('disconnect').disabled = !connected;  
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';  
            document.getElementById('response').innerHTML = '';  
        }  
  
        //this line.  
        function connect() {  
            var userid = document.getElementById('name').value;  
            var socket = new SockJS("http://127.0.0.1:80/liuliu/hello");  
            stompClient = Stomp.over(socket);  
            stompClient.connect({}, function(frame) {  
                setConnected(true);  
                console.log('Connected: ' + frame);  
                stompClient.subscribe('/topic/greetings', function(greeting){  
                    showGreeting(JSON.parse(greeting.body).content);  
                });  
  
                stompClient.subscribe('/user/' + userid + '/message',function(greeting){  
                    alert(JSON.parse(greeting.body).content);  
                    showGreeting(JSON.parse(greeting.body).content);  
                });  
            });  
        }  
  
        function sendName() {  
            var name = document.getElementById('name').value;  
            stompClient.send("/app/hello", {atytopic:"greetings"}, JSON.stringify({ 'name': name }));  
        }  
  
        function connectAny() {  
            var socket = new SockJS("http://127.0.0.1:80/liuliu/hello");  
            stompClient = Stomp.over(socket);  
            stompClient.connect({}, function(frame) {  
                setConnected(true);  
                console.log('Connected: ' + frame);  
                stompClient.subscribe('/topic/feed', function(greeting){  
                    alert(JSON.parse(greeting.body).content);  
                    showGreeting(JSON.parse(greeting.body).content);  
                });  
            });  
        }  
  
        function disconnect() {  
            if (stompClient != null) {  
                stompClient.disconnect();  
            }  
            setConnected(false);  
            console.log("Disconnected");  
        }  
  
  
        function showGreeting(message) {  
            var response = document.getElementById('response');  
            var p = document.createElement('p');  
            p.style.wordWrap = 'break-word';  
            p.innerHTML = message;  
            response.appendChild(p);  
        }  
    </script>
</head>
<body>
	<div>
		<div>
			<button id="connect" onclick="connect();">Connect</button>
			<button id="connectAny" onclick="connectAny();">ConnectAny</button>
			<button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
		</div>
		<div id="conversationDiv">
			<label>What is your name?</label><input type="text" id="name" />
			<button id="sendName" onclick="sendName();">Send</button>
			<p id="response"></p>
		</div>
	</div>
</body>
</html>
