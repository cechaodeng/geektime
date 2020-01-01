package com.kent.nio;

import java.io.IOException;

public class TimeClient {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();

    }
}
