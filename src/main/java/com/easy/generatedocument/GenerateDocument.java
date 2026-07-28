package com.easy.generatedocument;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> characterFreq = new HashMap<>();
        for (Character character : characters.toCharArray()) {
            characterFreq.put(character, characterFreq.getOrDefault(character, 0) + 1);
        }
        for (Character character : document.toCharArray()) {
            if (!(characterFreq.containsKey(character)) || characterFreq.get(character) == 0) {
                return false;
            }
            characterFreq.put(character, characterFreq.get(character) - 1);
        }
        return true;
    }

    public boolean generateDocument2(String characters, String document) {
        Map<Character, Integer> characterFreq = new HashMap<>();
        Map<Character, Integer> documentFreq = new HashMap<>();

        for (Character character : characters.toCharArray()) {
            characterFreq.put(character, characterFreq.getOrDefault(character, 0) + 1);
        }
        for (Character character : document.toCharArray()) {
            documentFreq.put(character, documentFreq.getOrDefault(character, 0) + 1);
        }
        for (Map.Entry<Character, Integer> docEntry: documentFreq.entrySet()) {
            Character charFromDoc= docEntry.getKey();
            Integer docCharFrequency = docEntry.getValue();
            if (!characterFreq.containsKey(charFromDoc) || (!(characterFreq.get(charFromDoc) >= docCharFrequency)))
                return false;
        }
        return true;
    }
}
