package com.linm.pdd.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TelnetReader extends Thread {

    private InputStreamReader in;

    public TelnetReader(InputStream in) {
        this.in = new InputStreamReader(in);
    }
    public void run() {
        try {
            // 反复将Telnet服务程序的反馈信息显示在控制台屏幕上
            while (true) {
                // 从Telnet服务程序读取数据
                int b = in.read();
                if (b == -1)
                    System.exit(0);
                // 将数据显示在控制台屏幕上
                System.out.print((char) b);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
