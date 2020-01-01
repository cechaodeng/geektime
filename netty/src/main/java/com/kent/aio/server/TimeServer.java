package com.kent.aio.server;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;

        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();

    }
}
