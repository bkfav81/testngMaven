package test.testex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {

	WebDriver driver;
	  @Test
	  public void f() {	
		  String baseUrl = "https://www.google.com/";
	      String expectedTitle = "Google";
	      String actualTitle = "";
	      driver.get(baseUrl);
	      actualTitle = driver.getTitle();      
	      if (actualTitle.contentEquals(expectedTitle)){
	          System.out.println("Test Passed!");
	      } else {
	          System.out.println("Test Failed");
	      }     
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  System.out.println("Starting Test On Chrome Browser");
	  }

	  @AfterMethod
	  public void afterMethod() {
		driver.close();
		System.out.println("Finished Test On Chrome Browser");
	  }
}
