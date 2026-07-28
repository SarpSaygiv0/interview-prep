package com.easy.generatedocument;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateDocumentTest {

    GenerateDocument gd;

    @BeforeEach
    void setGd() {
        gd = new GenerateDocument();
    }

    @Test
    public void generateDocumentTruthfully() {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        boolean actual = gd.generateDocument(characters, document);
        assertEquals(expected, actual);
    }

    @Test
    public void generateDocumentFalsely() {
        String characters = "abcabc";
        String document = "aabbccc";
        boolean expected = false;
        boolean actual = gd.generateDocument(characters, document);
        assertEquals(expected, actual);
    }

    @Test
    public void generateDocumentEmptyCharacters() {
        String characters = "";
        String document = "asd";
        boolean expected = false;
        boolean actual = gd.generateDocument2(characters, document);
        assertEquals(expected, actual);
    }

    @Test
    public void generateDocumentEmptyDocument() {
        String characters = "asd";
        String document = "";
        boolean expected = true;
        boolean actual = gd.generateDocument(characters, document);
        assertEquals(expected, actual);
    }


}
