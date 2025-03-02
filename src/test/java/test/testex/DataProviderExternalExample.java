package test.testex;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExternalExample {
	WebDriver driver;
  	
    @Test(dataProvider = "loginData", dataProviderClass = DataProviderExternal.class)
    public void testLogin(String uname, String pwd) {
        System.out.println("Testing login with Username: " + uname + ", Password: " + pwd);
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
	  driver.get("https://demoqa.com/login");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
