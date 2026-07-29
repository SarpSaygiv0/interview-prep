package com.medium.reversewordinstring;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordInString {


    public String reverseWordInString(String str) {
        StringBuilder result = new StringBuilder();
        List<String> list = new ArrayList<>();
        int startOfWord = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                list.add(str.substring(startOfWord, i));
                startOfWord = i;
            } else if (str.charAt(startOfWord) == ' ') {
                list.add(" ");
                startOfWord = i;
            }
        }
        list.add(str.substring(startOfWord));

        for (int i = list.size() - 1; i >= 0; i--) {
            result.append(list.get(i));
        }

        return result.toString();
    }
}
