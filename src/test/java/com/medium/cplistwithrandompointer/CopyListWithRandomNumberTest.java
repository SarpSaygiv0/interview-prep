package com.medium.cplistwithrandompointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CopyListWithRandomNumberTest {

    CopyListWithRandomNumber cpListWrn;

    @BeforeEach
    void setCpListWrn() {
        cpListWrn = new CopyListWithRandomNumber();
    }

    @Test
    void theCopyIsIndependentOfTheOriginal() {
        Node original = new Node(7);
        original.next = new Node(13);
        original.random = original.next;

        Node copy = cpListWrn.copyRandomList(original);
        original.next.val = 999;

        assertThat(copy.random.val).isEqualTo(13);
    }

    @Test
    void aNullRandomStaysNull() {
        Node original = new Node(7);
        assertThat(cpListWrn.copyRandomList(original).random).isNull();
    }
}
