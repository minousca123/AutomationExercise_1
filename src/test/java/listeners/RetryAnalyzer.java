package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	   int count = 0;

	    public boolean retry(ITestResult result) {
	        if (count < 0) {
	            count++;
	            return true;
	        }
	        return false;
	    }
}
