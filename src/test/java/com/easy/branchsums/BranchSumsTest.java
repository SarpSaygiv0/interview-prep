package com.easy.branchsums;

import com.util.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BranchSumsTest {

    @Nested
    class TestBinaryTree extends BinaryTree {
        TestBinaryTree(int value) {
            super(value);
        }

        TestBinaryTree insert(List<Integer> values) {
            return insert(values, 0);
        }

        TestBinaryTree insert(List<Integer> values, int i) {
            if (i >= values.size()) return null;

            List<TestBinaryTree> queue = new ArrayList<TestBinaryTree>();
            queue.add(this);
            while (!queue.isEmpty()) {
                TestBinaryTree current = queue.getFirst();
                queue.removeFirst();
                if (current.left == null) {
                    current.left = new TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((TestBinaryTree) current.left);
                if (current.right == null) {
                    current.right = new TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((TestBinaryTree) current.right);
            }
            insert(values, i + 1);
            return this;
        }
    }
        private BranchSum bs;

        @BeforeEach
        void setBs() {
            bs = new BranchSum();
        }

        @Test
        public void TestCase1() {
            TestBinaryTree tree =
                    new TestBinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
            List<Integer> expected =
                    new ArrayList<Integer>(Arrays.asList(15, 16, 18, 10, 11));
            assertThat(bs.branchSums(tree)).isEqualTo(expected);
        }
}

