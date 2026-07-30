package com.medium.balancedbrackets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedBracketsTest {

    BalancedBrackets bb;

    @BeforeEach
    void setBb() {
        bb = new BalancedBrackets();
    }

    @Test
    void testBalancedBrackets() {
        String input = "([])(){}(())()()";
        assertTrue(bb.balancedBrackets(input));
    }

    @Test
    void testBalancedBrackets2() {
        String input = "({(}))";
        assertFalse(bb.balancedBrackets(input));
    }

    @Test
    void testBalancedBrackets3() {
        String input = "([])(){}(())()()";
        assertTrue(bb.balancedBrackets(input));
    }

    @Test
    void testBalancedBrackets4() {
        String input = "()()[{()})]";
        assertFalse(bb.balancedBrackets(input));
    }

    @Test
    void testBalancedBrackets5() {
        String input = "]";
        assertFalse(bb.balancedBrackets(input));
    }
}
