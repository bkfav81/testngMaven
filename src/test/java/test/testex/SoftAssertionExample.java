package test.testex;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertionExample {
	
	WebDriver driver;
	
  @Test
  public void f() {
	  SoftAssert softAssert = new SoftAssert();

      // Check if the page title is as expected
      String expectedTitle = "DEMOQA";
      String actualTitle = driver.getTitle();
      softAssert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

      // Verify if the login button is displayed
      WebElement loginButton = driver.findElement(By.id("login"));
      softAssert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed!");

      // Assert if username field is enabled
      WebElement usernameField = driver.findElement(By.id("userName"));
      softAssert.assertTrue(usernameField.isEnabled(), "Username field is not enabled!");

      // Collect all assertion results
      softAssert.assertAll();
      System.out.println("Soft assertion completed.");
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
