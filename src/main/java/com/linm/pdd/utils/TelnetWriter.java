package com.linm.pdd.utils;

import java.io.*;

public class TelnetWriter extends Thread {

    private PrintStream out;

    public TelnetWriter(OutputStream out) {
        this.out = new PrintStream(out);
    }
    public void run() {
        try {
            // 包装控制台输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            // 反复将控制台输入写到Telnet服务程序
            while (true)
                out.println(in.readLine());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
