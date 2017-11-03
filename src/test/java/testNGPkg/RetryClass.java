package testNGPkg;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer {
	
	private int counter = 0;
    private	int retryLimit = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		
		return false;
		
	}

}
