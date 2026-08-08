package Listners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(Listners.ListenersSample.class)
public class TestCase1 {

    @Test
    public void testcase1() {
        System.out.println("Test case passed");
        Assert.assertEquals("A","A");
    }

    @Test
    public void testcase2() {
        System.out.println("Failed test case");
        Assert.assertEquals("A","A");
    }

    @Test
    public void testcase3() {
        System.out.println("Test case skipped");
        throw new SkipException("Added skip exception");
    }

    @Test
    public void testcase4() {
        System.out.println("New test cased added to check Jenkins syncing");
    }

    @Test
    public void testcase5() {
        System.out.println("New test cased added to check git hub");
    }
}
