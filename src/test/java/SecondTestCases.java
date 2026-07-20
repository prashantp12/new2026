import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestCases {

    @Test
    void setup(){
        System.out.println("Test setup");
    }

    @Test
    void createCustomer(){
        System.out.println("New customer created");
    }

    @Test
    void searchCustomer(){
        System.out.println("New customer search");
        //Assert.fail();
    }

    @Test
    void tearDown(){
        System.out.println("Test logout");
    }

    @Test
    void newTest11(){
        System.out.println("New test to check Jenkins");
    }
}
