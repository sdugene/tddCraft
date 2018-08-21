package com.sdugene.anagram;

import java.util.Arrays;

public class Anagram {

    private Anagram() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean compare(String string1, String string2) {
        boolean result = true;
        if (string1.length() != string2.length() || string1.length() < 2) {
            return false;
        }

        String[] stringList1 = string1.toLowerCase().split("");
        String[] stringList2 = string2.toLowerCase().split("");
        Arrays.sort(stringList1);
        Arrays.sort(stringList2);

        for (int curs = 0 ; curs < stringList1.length ; curs++) {
            if (!stringList1[curs].equals(stringList2[curs])) {
                result = false;
            }
        }
        return result;
    }
}
