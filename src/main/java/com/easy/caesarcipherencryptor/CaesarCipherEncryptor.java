package com.easy.caesarcipherencryptor;

public class CaesarCipherEncryptor {

    public String caesarCypherEncryptor(String str, int key) {
        // loop through chars
        // add the number to the char value
        // bound by 26
        char[] charArray = str.toCharArray();
        StringBuilder newStr = new StringBuilder();
        key = key % 26;
        for (int i = 0; i <charArray.length; i++) {
            int charNumber = charArray[i] + key;
            if (charNumber > 122) {
                char newChar = (char)((int)'a' + (charNumber % 123));
                newStr.append(newChar);
            } else {
                newStr.append((char)charNumber);
            }
        }

        return newStr.toString();
    }

    public String caesar(String string, int key) {
        StringBuilder encoded = new StringBuilder();

        for(Character c: string.toCharArray()) {
            int ascii = c + (key % 26);
            if (ascii > 'z')
                ascii -= 26;
            encoded.append((char) ascii);
        }
        return encoded.toString();
    }
}
