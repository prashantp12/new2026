import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @DataProvider(name = "DataProvider1")
    public Object[][] getData() {
        Object[][] dp = {{"aa@test.com", "pass1"}, {"bb@test.com", "pass2"}};
        return dp;
    }


}
