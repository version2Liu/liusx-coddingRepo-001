package com.liusx.sword.june.day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: StartMen <br>
 * date: 2020/6/2 13:56 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class StartMen {
    public static void main(String[] args) {
        System.out.println("this is a  new start！");

        Map<String,String> consumers = new HashMap<String, String>(18);
        consumers.put("1","1");
        consumers.put("2","2");
        consumers.put("3","3");
        consumers.put("4","4");
        consumers.put("5","5");
        consumers.put("6","6");
        consumers.put("7","7");

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        System.out.println("-----------"+consumers.toString());
        consumers.keySet().removeAll(list);
        for (String str:consumers.values()) {
            System.out.println("-------"+str);
        }
        System.out.println(consumers.toString());


    }
}
