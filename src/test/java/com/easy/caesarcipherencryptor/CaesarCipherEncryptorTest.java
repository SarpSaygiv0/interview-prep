package com.easy.caesarcipherencryptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class CaesarCipherEncryptorTest {

    private CaesarCipherEncryptor cCe;

    @BeforeEach
    void setcCe() {
        cCe = new CaesarCipherEncryptor();
    }

    @Test
    void checkEncryptor() {
        // returns "zab"
        assertThat(cCe.caesarCypherEncryptor("xyz", 2)).isEqualTo("zab");
    }

    @Test
    void checkEncryptorEmpty() {
        // return empty
        assertThat(cCe.caesarCypherEncryptor("", 2)).isEqualTo("");
    }
    @Test
    void checkEncryptorKBig() {
        // returns "cdefgh"
        assertThat(cCe.caesarCypherEncryptor("abcdef", 54)).isEqualTo("cdefgh");
    }

}
