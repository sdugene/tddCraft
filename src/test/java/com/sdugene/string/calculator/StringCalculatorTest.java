package com.sdugene.string.calculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void emptyString(){
        Assert.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void singleNumber(){
        Assert.assertEquals(1, StringCalculator.add("1"));
        Assert.assertEquals(5, StringCalculator.add("5"));
        Assert.assertEquals(50, StringCalculator.add("50"));
    }

    @Test
    public void multipleNumber(){
        Assert.assertEquals(7, StringCalculator.add("4,3"));
        Assert.assertEquals(9, StringCalculator.add("4,5"));
        Assert.assertEquals(76, StringCalculator.add("4,2,70"));
        Assert.assertEquals(76, StringCalculator.add("4,2,70.0"));
        Assert.assertEquals(76, StringCalculator.add("4,2,61a.0hfsjkhgsjdkhfshf4.5"));
    }
}
