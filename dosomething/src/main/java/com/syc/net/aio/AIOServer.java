package com.syc.net.aio;

public class AIOServer {

    public static void main(String[] args) {
        System.out.println("server start...");
        new Thread(new AsyncTimeServerHandler(8080), "AIO-AsyncTimeServerHandler-001").start();
    }
}
