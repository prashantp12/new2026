import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "DataProvider1",dataProviderClass = DataProviderExample.class)
    void test1(String userName, String password) {
        System.out.println("User name: " + userName + ", Password: " + password);
    }
}
