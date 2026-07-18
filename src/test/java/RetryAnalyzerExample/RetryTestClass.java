package RetryAnalyzerExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTestClass {

    @Test
    void test1() {
        System.out.println("test case passed");
    }

    @Test
    void test2() {
        System.out.println("test case failed");
        Assert.assertEquals('A','B');
    }
}
