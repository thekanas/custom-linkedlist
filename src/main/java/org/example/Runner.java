package org.example;

import org.example.list.LList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
        l.add(15);
        l.add(13);
        l.add(14);

        LList<Integer> integerLList = new LList<>();
        integerLList.addAll(l);

        System.out.println(integerLList.get(0));
        System.out.println(integerLList.get(1));
        System.out.println(integerLList.get(2));

        integerLList.sort(Comparator.comparingInt(x -> x));

        System.out.println(integerLList.get(0));
        System.out.println(integerLList.get(1));
        System.out.println(integerLList.get(2));
    }
}
