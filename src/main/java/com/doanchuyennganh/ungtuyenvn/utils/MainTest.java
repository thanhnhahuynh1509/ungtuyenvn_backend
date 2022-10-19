package com.doanchuyennganh.ungtuyenvn.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        List<Integer> tmp = new ArrayList<>(list1);
        System.out.println(list1);
        System.out.println(list2);

//        System.out.println("After retain");
//        list1.retainAll(list2);
//        System.out.println(list1);
//        System.out.println(list2);

        System.out.println("After remove");
        tmp.removeAll(list2);
        System.out.println(tmp);
        System.out.println(list1);
        System.out.println(list2);
    }
}
