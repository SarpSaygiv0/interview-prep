package com.easy.runlengthencoding;

import java.util.HashMap;

public class RunLengthEncoding {

    public String runLengthEncoder(String str) {
        StringBuilder encodedString = new StringBuilder();
        int currentRunLength = 1;

        for (int i=1; i<str.length(); i++) {
            char currentCharacter = str.charAt(i);
            char prevCharacter = str.charAt(i - 1);

            if (currentCharacter != prevCharacter || currentRunLength == 9) {
                String currentRun = String.valueOf(currentRunLength);
                String currentChar = String.valueOf(prevCharacter);
                encodedString.append(currentRun).append(currentChar);
                currentRunLength = 0;
            }
            currentRunLength += 1;
        }
        encodedString.append(currentRunLength).append(str.charAt(str.length()-1));

        return encodedString.toString();
    }







}
