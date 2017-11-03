package testNGPkg;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//@Listeners(testNGPkg.ListenerClass.class)
public class TestNGClass {
	
	/*
	 *  It gives the ability to produce HTML Reports of execution
		Annotations made testers life easy
		Test cases can be Grouped & Prioritized more easily
		Parallel testing is possible
		Generates Logs
		Data Parameterization is possible
	 */
	
	@BeforeSuite(alwaysRun=true)
	public void beforesuite() {
		System.out.println("This is before Suite");
	}
	
	@BeforeTest(alwaysRun=true)
	public void beforetest() {
		System.out.println("This is before Test");
	}
	
	@BeforeGroups(groups= {"sanity"})
	public void beforeGroups() {
		System.out.println("This is before Groups");
	}
	
	@BeforeClass(alwaysRun=true)
	public void beforeclass() {
		System.out.println("This is before Class");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void beforemethod() {
		System.out.println("This is before Method");
	}
	
	@Test (priority=1)	
	public void test1() {
		System.out.println("This is the real test functionality1");
		//Assert.assertEquals(false, true);
	}
	
/*	@Test (priority=2) // retryAnalyzer=testNGPkg.RetryClass.class)
	public void test2() {
		System.out.println("This is the real test functionality2");
		//Assert.assertEquals(false, true);
	}*/
	
	
	@Test(priority=3, enabled=true,groups= {"sanity"})
	public void test3() {
		System.out.println("This is the real test functionality3");
	}
	
	@Test (priority=4,dependsOnMethods= {"test3"},groups= {"Regression"})
	public void test4() {
		System.out.println("This is the real test functionality4");
	}
	
/*	@Test (priority=3,alwaysRun=true,groups= {"sanity","Regression"})
	@Parameters({"applicationTest1","applicationTest2","applicationsuite"})
	public void test5(String sapplicationTest1, String sapplicationTest2,String sapplicationsuite) {
		System.out.println("This is the real test functionality5");
		Reporter.log("Test5 Executed Successfully");
		System.out.println(sapplicationTest1+"  ----Parameters----"+sapplicationTest2);
		System.out.println("-Suite Parameter----"+sapplicationsuite);

	}*/
	
	@AfterMethod(alwaysRun=true)
	public void aftermethod() {
		System.out.println("This is after Method");
	}

/*	@Test (priority=6,groups= {"sanity"},dataProvider="dp3",dataProviderClass=NewTest.class)
	public void test6(String str1,String str2) {
		System.out.println(str1+"---DataProvider in other class---"+str2);
	}*/
	
	@AfterClass(alwaysRun=true)
	public void afterclass() {
		System.out.println("This is after Class");
	}
	
	@AfterGroups(groups= {"sanity"})
	public void afterGroups() {
		System.out.println("This is after Groups");
	}
	
	
	@AfterTest(alwaysRun=true)
	public void aftertest() {
		System.out.println("This is after Test");
	}

	@AfterSuite(alwaysRun=true)
	public void aftersuite() {
		System.out.println("This is after Suite");
	}
	
}
