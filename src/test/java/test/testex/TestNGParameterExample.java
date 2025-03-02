package test.testex;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;

public class TestNGParameterExample {
	WebDriver driver;
	
  @Test
  @Parameters({"baseURL", "username", "password"})
  public void testLogin(String baseURL, String uname, String pwd) {
      System.out.println("Base URL: " + baseURL);
      driver.get(baseURL);
      System.out.println("Username: " + uname);
      System.out.println("Password: " + pwd);
      
      WebElement username = driver.findElement(By.id("userName"));
      WebElement password = driver.findElement(By.id("password"));
      WebElement loginButton = driver.findElement(By.id("login"));

      username.sendKeys(uname);
      password.sendKeys(pwd);
      loginButton.click();    
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
