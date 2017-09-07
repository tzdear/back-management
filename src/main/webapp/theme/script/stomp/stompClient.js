var StompClientJsFun = function(){
	
	var stompClient = null;
	
	function _connect() {
	    var socket = new SockJS('/liuliu/lyadmingsocket');
	    stompClient = Stomp.over(socket);
	    stompClient.connect({"accept-version":"1.0,1.1,2.0"}, function (frame) {
	        stompClient.subscribe('/topic/task', function (greeting) {
	            _showGreeting(JSON.parse(greeting.body));
	        });
	    });
	}
	
	function _disconnect() {
	    if (stompClient != null) {
	        stompClient.disconnect();
	    }
	    console.log("Disconnected");
	}
	
	function _sendName() {
	    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
	}
	
	function _showGreeting(message) {
	    $("#header_task_bar .badge-default").html(3);
	}
	
	return {
		connect : function(){
			_connect();
		}
	}
}();
jQuery(document).ready(function() {
	StompClientJsFun.connect();
})
