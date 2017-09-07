<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Hello WebSocket</title>
    <link href="/liuliu/theme/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/liuliu/theme/script/main.css" rel="stylesheet">
    <script src="/liuliu/theme/assets/global/plugins/jquery.min.js"></script>
    <script src="/liuliu/theme/script/sockjs.min.js"></script>
    <script src="/liuliu/theme/script/stomp.js"></script>
    <script src="/liuliu/theme/script/app.js"></script>
</head>
<body>
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">WebSocket connection:</label>
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">What is your name?</label>
                    <input type="text" id="name" class="form-control" placeholder="Your name here...">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Greetings</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
        </div>
    </div>
    </div>
</body>
</html>