package com.easy.runlengthencoding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RunLengthEncodingTest {

    private RunLengthEncoding rle;

    @BeforeEach
    void setRle() {
        rle = new RunLengthEncoding();
    }

    @Test
    void checkRunLengthEncoder() {
        String expected= "9A4A2B4C2D";
        assertThat(rle.runLengthEncoder("AAAAAAAAAAAAABBCCCCDD")).isEqualTo(expected);
    }

    @Test
    void checkRunLengthEncoderWithOneCharacter() {
        String expected= "1A";
        assertThat(rle.runLengthEncoder("A")).isEqualTo(expected);
    }
}
