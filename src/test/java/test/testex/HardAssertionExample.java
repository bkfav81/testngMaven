package test.testex;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertionExample {
	WebDriver driver;
	
  @Test
  public void f() {
	// Check if the page title is as expected
      String expectedTitle = "DEMOQA";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

      // Verify if the login button is displayed
      WebElement loginButton = driver.findElement(By.id("login"));
      Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed!");

      // If the above assertions fail, the next steps won't execute
      System.out.println("Hard assertion passed, proceeding with further steps...");
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/login");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
