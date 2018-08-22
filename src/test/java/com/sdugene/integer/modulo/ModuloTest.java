package com.sdugene.integer.modulo;

import org.junit.Assert;
import org.junit.Test;

public class ModuloTest {

    @Test
    public void moduloOne()
    {
        Assert.assertEquals(0, Modulo.modulo(0,1));
        Assert.assertEquals(0%1, Modulo.modulo(0,1));
        Assert.assertEquals(10%1, Modulo.modulo(10,1));
    }

    @Test
    public void moduloTwo()
    {
        Assert.assertEquals(0%2, Modulo.modulo(0,2));
        Assert.assertEquals(1%2, Modulo.modulo(1,2));
        Assert.assertEquals(2%2, Modulo.modulo(2,2));
        Assert.assertEquals(3%2, Modulo.modulo(3,2));
        Assert.assertEquals(4%2, Modulo.modulo(4,2));
    }

    @Test
    public void moduloThree()
    {
        Assert.assertEquals(0%3, Modulo.modulo(0,3));
        Assert.assertEquals(1%3, Modulo.modulo(1,3));
        Assert.assertEquals(2%3, Modulo.modulo(2,3));
        Assert.assertEquals(3%3, Modulo.modulo(3,3));
        Assert.assertEquals(4%3, Modulo.modulo(4,3));
    }
}
