package com.sdugene.string.calculator;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    private StringCalculator() {
        throw new IllegalStateException("Utility class");
    }

    public static int add(String values) {
        if (values.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (String token : values.split("[^1234567890]+")) {
            total += parseInt(token);
        }
        return total;
    }
}
