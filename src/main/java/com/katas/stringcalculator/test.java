package com.katas.stringcalculator;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        String word = "1;2;3";

        String[] wtf = word.split("\\;");

        Arrays.stream(wtf).forEach(string -> System.out.println(string));
    }
}
