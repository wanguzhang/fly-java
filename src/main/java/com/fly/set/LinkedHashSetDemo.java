package com.fly.set;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.HashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        int i =2;
        if(i>1){
            System.out.println("i>1");
        }else  if(i>-1){
            System.out.println("i>-1");
        }else {
            System.out.println("else");
        }
    }
}
