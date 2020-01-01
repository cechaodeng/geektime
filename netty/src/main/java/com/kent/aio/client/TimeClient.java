package com.kent.aio.client;

import com.kent.nio.TimeClientHandle;

import java.io.IOException;

public class TimeClient {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "TimeClient-001").start();

    }
}
