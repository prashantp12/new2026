import org.testng.annotations.Test;

public class FirstTestCases {

    @Test
    void setup(){
        System.out.println("Test setup");
    }

    @Test
    void login(){
        System.out.println("Login to application");
    }

    @Test
    void teadDown(){
        System.out.println("Test logout");
    }
}
