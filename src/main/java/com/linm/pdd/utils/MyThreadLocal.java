package com.linm.pdd.utils;

import java.util.LinkedList;
import java.util.List;

public class MyThreadLocal {

    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args){
        System.out.println("before set:"+threadLocal.get());
        List student = new LinkedList();
        System.out.println(student);
        student.add("linm");
        student.add("lm");
        threadLocal.set(student);
        System.out.println(student);
        System.out.println("after set:"+threadLocal.get());
    }
}
