package com.sdugene.render_tree;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class renderTest {

    @Test
    public void instantiateTest()
    {
        try {
            Constructor<Render> c = Render.class.getDeclaredConstructor();
            c.setAccessible(true);
            c.newInstance();
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    public void simpleWord() {

        String[] list = {"test"};
        Assert.assertEquals("test", Render.render(list));
    }

    @Test
    public void twoWords() {
        String[] list = {"test/word"};
        Assert.assertEquals("test\n\tword", Render.render(list));
    }

    @Test
    public void threeWords() {
        String[] list = {"test/word/toto"};
        Assert.assertEquals("test\n\tword\n\t\ttoto", Render.render(list));
    }

    @Test
    public void fourWords() {
        String[] list = {"test/word/toto/plus"};
        Assert.assertEquals("test\n\tword\n\t\ttoto\n\t\t\tplus", Render.render(list));
    }

    @Test
    public void tenWords() {
        String[] list = {"test/word/toto/plus/word/toto/plus/word/toto/plus"};
        Assert.assertEquals("test\n\tword\n\t\ttoto\n\t\t\tplus\n\t\t\t\tword\n\t\t\t\t\ttoto\n\t\t\t\t\t\tplus\n\t\t\t\t\t\t\tword\n\t\t\t\t\t\t\t\ttoto\n\t\t\t\t\t\t\t\t\tplus", Render.render(list));
    }

    @Test
    public void twoLine() {
        String[] list = {"test", "toto"};
        Assert.assertEquals("test\ntoto", Render.render(list));
    }

    @Test
    public void twoComplexLine() {
        String[] list = {"test/plus", "toto/word"};
        Assert.assertEquals("test\n\tplus\ntoto\n\tword", Render.render(list));
    }

    @Test
    public void twoComplexMultiLine() {
        String[] list = {"test/plus", "test/toto/word"};
        Assert.assertEquals("test\n\tplus\n\ttoto\n\t\tword", Render.render(list));

        String[] list2 = {"plus/toto", "test/toto", "test/plus/word"};
        Assert.assertEquals("plus\n\ttoto\ntest\n\tplus\n\t\tword\n\ttoto", Render.render(list2));

        String[] list3 = {"test/plus", "test/toto/word", "plus/toto", "test/word"};
        Assert.assertEquals("plus\n\ttoto\ntest\n\tplus\n\ttoto\n\t\tword\n\tword", Render.render(list3));
    }

    @Test
    public void realTest() {
        String[] list1 = {"/home/michel/photos/wallpaper.png", "/home/michel/photos/profile.jpg"};
        Assert.assertEquals("home\n\tmichel\n\t\tphotos\n\t\t\tprofile.jpg\n\t\t\twallpaper.png", Render.render(list1));

        String[] list2 = {"/home/michel/photos/wallpaper.png", "/home/michel/photos/profile.jpg", "/etc/passwd"};
        Assert.assertEquals("etc\n\tpasswd\nhome\n\tmichel\n\t\tphotos\n\t\t\tprofile.jpg\n\t\t\twallpaper.png", Render.render(list2));

        String[] list9 = {"/home/michel/photos/wallpaper.png",
                "/etc/passwd",
                "/etc/nginx/conf.d/website.conf",
                "/home/michel/cv.pdf",
                "/etc/hosts",
                "/home/michel/photos/profile.jpg",
                "/home/michel"
        };
        Assert.assertEquals("etc\n" +
                "\thosts\n" +
                "\tnginx\n" +
                "\t\tconf.d\n" +
                "\t\t\twebsite.conf\n" +
                "\tpasswd\n" +
                "home\n" +
                "\tmichel\n" +
                "\t\tcv.pdf\n" +
                "\t\tphotos\n" +
                "\t\t\tprofile.jpg\n" +
                "\t\t\twallpaper.png", Render.render(list9));
    }
}
