package com.katas.stringcalculator;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class StringCalculator {

    public String add(String input) {
        if (input.isEmpty()) return "0";

        String body = input;
        String customSep = null;
        if (input.startsWith("//")) {
            int newline = input.indexOf('\n');
            customSep = input.substring(2, newline);
            body = input.substring(newline + 1);
        }

        String regex = customSep == null ? "[,\n]" : Pattern.quote(customSep);
        String[] tokens = body.split(regex, -1);

        String error = validate(tokens, body, customSep);
        if (!error.isEmpty()) return error;

        return sum(tokens);
    }

    private String validate(String[] tokens, String body, String customSep) {
        int sepLen = customSep == null ? 1 : customSep.length();
        int pos = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].isEmpty()) {
                if (i == tokens.length - 1)
                    return "Number expected but EOF found.";
                String found = customSep != null ? customSep
                        : body.charAt(pos) == '\n' ? "\\n" : String.valueOf(body.charAt(pos));
                return "Number expected but '" + found + "' found at position " + pos + ".";
            } else {
                for (int j = 0; j < tokens[i].length(); j++) {
                    char c = tokens[i].charAt(j);
                    if (!Character.isDigit(c) && c != '.' && c != '-') {
                        String expected = customSep == null ? "," : customSep;
                        return "'" + expected + "' expected but '" + c
                                + "' found at position " + (pos + j) + ".";
                    }
                }
            }
            pos += tokens[i].length() + sepLen;
        }
        return "";
    }

    private String sum(String[] tokens) {
        BigDecimal total = BigDecimal.ZERO;
        for (String t : tokens)
            total = total.add(new BigDecimal(t));
        return total.stripTrailingZeros().toPlainString();
    }
}


