package com.linm.pdd.utils;

import java.io.IOException;
import java.net.Socket;

public class SocketTest {

    public static void connect(String host,int port){
        try {
            Socket sock = new Socket(host, port);
            // 创建一个写线程
            new TelnetWriter(sock.getOutputStream()).start();
            // 创建一个读线程
            new TelnetReader(sock.getInputStream()).start();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String [] args) throws IOException {
        connect("111.231.95.107", 443);
        //即可在控制台输入命令，回车后会发送命令到远程主机，并在控制台打印响应数据
    }
}
