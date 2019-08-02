var net = require('net'),
    sockets = [];

var server = net.createServer(function (client) {
    client.setEncoding('utf8');
    client.setTimeout(500);
    client.on('data', function (data) {
        var jsonData = JSON.parse(data);
        console.log(data);
        console.log(jsonData);
        var msg = JSON.stringify(msg);
        for (var i = 0; i < sockets.length; i++) {
            sockets[i].write(jsonData.msg);
            console.log(jsonData.msg);
        }
    });
    client.on('end', function () {
        console.log(' end.');
    });
    client.on('error', function () {
        //console.log(`error`);
    });
    client.on('close', function () {
        sockets.pop();
        console.log(' close');
    });
    client.on('timeout', function () {});
   // client.write('hihi');
    sockets.push(client);
});

server.on('error', function (error) {

});
server.listen(2222, function () {

    var serverInfo = server.address();
    var serverInfoJson = JSON.stringify(serverInfo);
    console.log('listen server : ' + serverInfoJson);
    server.on('close', function () {
        console.log('server closed.');
    });
    server.on('connection', function () {
        console.log(`들어옴`);
    });
});
