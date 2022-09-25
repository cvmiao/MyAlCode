package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2021/6/17 7:03
 * @Created by zdl
 */
public class Main {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("str1");
        list.add(1, "Str2");
        System.out.println(list.get(1));


    }

}
