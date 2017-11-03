package testNGPkg;

import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;


public class NewTest {
  @Test
  public void f() throws IOException {
	//  System.out.println(user+"----data is----"+pswd);
	  File fDir = new File("drivers");
	  System.out.println(fDir.getAbsolutePath());
	  System.setProperty("webdriver.chrome.driver", fDir.getAbsolutePath()+"\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("http://www.google.com");
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  
	  File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(f, new File(fDir.getAbsolutePath()+"\\test.jpg"));

  }

  @DataProvider
  public Object[][] dp() {
	   
    return new Object[][] {
      new Object[] { "test1", "pswd1" },
      new Object[] { "test2", "pswd2" },
      new Object[] { "test3", "pswd3" },
    };
  }
  
  @DataProvider
  public Object[][] dp1() {	   
    Object[][] obj = { { "test11", "pswd11" },{ "test21", "pswd21" },{ "test31", "pswd31" }};
    return obj;
  }
  @DataProvider
  public static Object[][] dp2() {	   
    Object[][] obj =  new Object[2][2];
    obj[0][0]="test12";
    obj[0][1]="pswd12";
    obj[1][0]="test22";
    obj[1][1]="pswd22";
    return obj;
  }
  @DataProvider
  public Object[][] dp3() throws IOException{
	  
	  BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\siva\\Desktop\\TestData.xlsx"));
	  XSSFWorkbook wb = new XSSFWorkbook(bis);   //HSSFWorkbook
	  
	  XSSFSheet ws = wb.getSheet("Sheet1");
	  int RowCount = ws.getLastRowNum();
	  int ColCount = ws.getRow(0).getPhysicalNumberOfCells();
	  
	  System.out.println("Row Count is: "+RowCount);
	  System.out.println("Col Count is: "+ColCount);
	  
	  String[][] s = new String[RowCount+1][ColCount];
	  
	  for(int i=0;i<=RowCount;i++) {
		  for(int j=0;j<ColCount;j++) {
			  s[i][j]=ws.getRow(i).getCell(j).getStringCellValue();
			  System.out.println("s["+i+"]["+j+"] : "+ws.getRow(i).getCell(j).getStringCellValue());
		  }
	  }
	  
	return s;
	  
  }
  
  //ISuiteListener - onStart(), onFinish()
  //ITestListener - onStart(), onFinish(), onTestFailure(ITestResult result), onTestSuccess(ITestResult result),onTestSkipped(ITestResult result),onTestStart(ITestResult result),onTestFailedButWithinSuccessPercentage(ITestResult result)
  //IInvokedMethodListener - afterInvocattion(), beforeInvocation()
  
  
  
}
