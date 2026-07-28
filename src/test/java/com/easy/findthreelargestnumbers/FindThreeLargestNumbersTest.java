package com.easy.findthreelargestnumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindThreeLargestNumbersTest {

    FindThreeLargestNumbers ftln;

    @BeforeEach
    void setFtln(){
        ftln = new FindThreeLargestNumbers();
    }

    @Test
    void findThreeLargestNumbers() {
        int[] expected = {18, 141, 541};
        assertTrue(compare(
        ftln.findThreeLargestNumbers(new int[] {
                141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7}),
                expected
        ));
    }

    public boolean compare(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
