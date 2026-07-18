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
    }

    @Test
    void teadDown(){
        System.out.println("Test logout");
    }
}
