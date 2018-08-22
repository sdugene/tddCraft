package com.sdugene.integer.modulo;

public class Modulo {

    private Modulo() {
        throw new IllegalStateException("Utility class");
    }

    public static int modulo(int integer, int modulo)
    {
        int result = integer / modulo;
        return integer - modulo*result;
    }
}
