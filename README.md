# Hello World Server
This repository contains a simple HTTP server implemented using different languages and frameworks.

The implemented HTTP-server is listening on the port number `9090` and replies with HTTP response status code `200` and a response body `Hello, World!`.

After server is started you can use `cURL` to send any HTTP request:

```bash
curl -vvv http://localhost:9090
```

HTTP response should look like this:

```
HTTP/1.1 200 OK
Server: akka-http/2.3.12
Date: Wed, 08 Feb 2017 18:32:30 GMT
Content-Type: text/plain; charset=UTF-8
Content-Length: 13

Hello, World!
```
