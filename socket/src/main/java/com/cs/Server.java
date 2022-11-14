package com.cs;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:chang shuai
 * date:2021/6/30
 * time:14:56
 */
public class Server implements Runnable{
    private ServerSocket server = null;
    private Socket socket = null;

    public Server(int port) {
        try {
            this.server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(getDate() + " 等待客户端连接");
            this.socket = server.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String result = format.format(date);
        return result;
    }
}
