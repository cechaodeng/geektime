package com.kent.fakebio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServerHandlerExecutePool   {

    private ExecutorService executor;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        executor = new ThreadPoolExecutor(
                (Runtime.getRuntime().availableProcessors()),//corepoolsize
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));


    }

    public void execute(Runnable task) {
        executor.execute(task);

    }

}
