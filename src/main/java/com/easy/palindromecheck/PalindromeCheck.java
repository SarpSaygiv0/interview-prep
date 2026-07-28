package com.easy.palindromecheck;

public class PalindromeCheck {

    public boolean isPalindrome(String word) {
        // loop through from beginning and end
        char[] charArray = word.toCharArray();

        for (int i = 0, j = charArray.length-1; i+1 <= j; i++, j--) {
            if (charArray[i] != charArray[j])
                return false;
        }
        return true;
    }
}
