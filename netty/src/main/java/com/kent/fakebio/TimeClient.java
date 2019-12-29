package com.kent.fakebio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        Socket socket = new Socket("127.0.0.1", port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("QUERY TIME ORDER");
        System.out.println("Send order 2 server succeed.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String resp = in.readLine();
        System.out.println("Now is : " + resp);

    }
}
