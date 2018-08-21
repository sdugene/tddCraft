package com.sdugene.stringCalculator;

import static java.lang.Integer.parseInt;

public class StringCalculator {
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
