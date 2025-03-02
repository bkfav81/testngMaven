package test.testex;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGridDataProviderExternalChild {
	
  	
    @Test(dataProvider = "loginData", dataProviderClass = SeleniumGridDataProviderExternalParent.class)
    public void testLogin(String uname, String pwd) throws MalformedURLException {
      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
  	  desiredCapabilities.setBrowserName("firefox");
  	  desiredCapabilities.setPlatform(Platform.WIN10);
  	  
  	  RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.29.90:4444"),desiredCapabilities);
  	  
  	  driver.get("https://demoqa.com/login");
    	
  	  JavascriptExecutor js = (JavascriptExecutor)driver; // Scroll operation using Js Executor
      js.executeScript("window.scrollBy(0,400)");
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
    	System.out.println("Testing login with Username: " + uname + ", Password: " + pwd);
        WebElement username = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginButton.click();    
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.quit();
    }	  
}
