package com.easy.branchsums;

import com.util.TestBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BranchSumsTest {

    private BranchSum bs;

    @BeforeEach
    void setBs() {
        bs = new BranchSum();
    }

    @Test
    public void branchSumsTest() {
        TestBinaryTree tree =
                new TestBinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expected =
                new ArrayList<>(Arrays.asList(15, 16, 18, 10, 11));
        assertThat(bs.branchSums(tree)).isEqualTo(expected);
    }
}

