package com.sdugene.anagram;


import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

    @Test
    public void emptyString() {
        Assert.assertFalse(Anagram.compare("", ""));
    }

    @Test
    public void singleLetter() {
        Assert.assertFalse(Anagram.compare("a", "a"));
        Assert.assertFalse(Anagram.compare("A", "A"));
        Assert.assertFalse(Anagram.compare("A", "a"));
    }

    @Test
    public void twoSameLetter() {
        Assert.assertTrue(Anagram.compare("AA", "AA"));
        Assert.assertTrue(Anagram.compare("aa", "aa"));
        Assert.assertTrue(Anagram.compare("Aa", "Aa"));
    }

    @Test
    public void twoDifferentLetter() {
        Assert.assertTrue(Anagram.compare("ab", "ba"));
        Assert.assertTrue(Anagram.compare("Ba", "Ab"));
        Assert.assertFalse(Anagram.compare("ba", "bc"));
    }

    @Test
    public void threeDifferentLetter() {
        Assert.assertTrue(Anagram.compare("abc", "bac"));
        Assert.assertTrue(Anagram.compare("Bac", "Acb"));
        Assert.assertFalse(Anagram.compare("bac", "bdc"));
    }

    @Test
    public void differentSizeString() {
        Assert.assertFalse(Anagram.compare("AB", "abc"));
    }

    @Test
    public void multipleSameLetter() {
        Assert.assertTrue(Anagram.compare("aaab", "abaa"));
        Assert.assertFalse(Anagram.compare("aabc", "abaa"));
        Assert.assertFalse(Anagram.compare("abc", "aabc"));
    }

    @Test
    public void realTestMarion() {
        Assert.assertTrue(Anagram.compare("Marion", "manoir"));
        Assert.assertTrue(Anagram.compare("Marion", "Minora"));
        Assert.assertTrue(Anagram.compare("Marion", "Romain"));
        Assert.assertTrue(Anagram.compare("Marion", "marino"));
        Assert.assertTrue(Anagram.compare("Marion", "Romina"));
        Assert.assertTrue(Anagram.compare("Marion", "romani"));
        Assert.assertTrue(Anagram.compare("Marion", "mirano"));
        Assert.assertTrue(Anagram.compare("Marion", "Mornai"));
        Assert.assertTrue(Anagram.compare("Marion", "Normai"));
        Assert.assertTrue(Anagram.compare("Normai", "Romina"));
        Assert.assertTrue(Anagram.compare("Romain", "Romina"));
    }
}
