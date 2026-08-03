package com.medium.youngestcommonancestor;

import com.util.AncestralTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class YoungestCommonAncestorTest {

    YoungestCommonAncestor yca;

    @BeforeEach
    void setYca() {
        yca = new YoungestCommonAncestor();
    }

    @Test
    void youngestCommonAncestorTest() {
        Map<Character, AncestralTree> trees = getTrees();
        trees.get('A').addAsAncestor(new AncestralTree[]{
                trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new AncestralTree[]{
                trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new AncestralTree[]{
                trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new AncestralTree[]{
                trees.get('F'), trees.get('G')});

        AncestralTree expected = yca.getYoungestCommonAncestor(
                trees.get('A'), trees.get('E'), trees.get('I')
        );
        assertThat(expected).isEqualTo(trees.get('B'));
    }

    @Test
    void youngestCommonAncestorUsingDepthTest() {
        Map<Character, AncestralTree> trees = getTrees();
        trees.get('A').addAsAncestor(new AncestralTree[]{
                trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new AncestralTree[]{
                trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new AncestralTree[]{
                trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new AncestralTree[]{
                trees.get('F'), trees.get('G')});

        AncestralTree expected = yca.getYoungestCommonAncestorUsingDepth(
                trees.get('A'), trees.get('E'), trees.get('I')
        );
        assertThat(expected).isEqualTo(trees.get('B'));
    }

    private Map<Character, AncestralTree> getTrees() {
        var trees = new HashMap<Character, AncestralTree>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            trees.put(a, new AncestralTree(a));
        }

        trees.get('A').addAsAncestor(new AncestralTree[]{
                trees.get('B'),
                trees.get('C'),
                trees.get('D'),
                trees.get('E'),
                trees.get('F')});
        return trees;
    }
}
