package com.syc.net.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable {

    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;


    public AsyncTimeServerHandler(int port) {
        try {
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open()
                    .bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        CountDownLatch latch = new CountDownLatch(1);
        // do somethings ,but will not quit
        doAccept();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAccept() {

        asynchronousServerSocketChannel.accept(this, new CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler>() {
            @Override
            public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
                attachment.asynchronousServerSocketChannel.accept(attachment, this);
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                result.read(byteBuffer, byteBuffer, new ReadCompletionHandler(result));
            }

            @Override
            public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
                System.out.println("请求失败");
                exc.printStackTrace();
                System.out.println(attachment);
            }
        });
    }
}
