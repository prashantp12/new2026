package RetryAnalyzerExample;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int retry = 0;
    int maxRetry = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retry < maxRetry) {
            retry++;
            return true;
        }
        return false;
    }
}
