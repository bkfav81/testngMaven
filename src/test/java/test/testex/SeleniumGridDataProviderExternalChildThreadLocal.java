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

public class SeleniumGridDataProviderExternalChildThreadLocal {
protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
public WebDriver getDriver()
{
	return driver.get();
}
  	
    @Test(dataProvider = "loginData", dataProviderClass = SeleniumGridDataProviderExternalParent.class)
    public void testLogin(String uname, String pwd) throws MalformedURLException {
      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
  	  desiredCapabilities.setBrowserName("firefox");
  	  desiredCapabilities.setPlatform(Platform.WIN10);
  	  
  	  driver.set(new RemoteWebDriver(new URL("http://192.168.29.90:4444"),desiredCapabilities));
  	  
  	  WebDriver webdriver = getDriver();
  	  webdriver.get("https://demoqa.com/login");
    	
  	  JavascriptExecutor js = (JavascriptExecutor)webdriver; // Scroll operation using Js Executor
      js.executeScript("window.scrollBy(0,400)");
      webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
    	System.out.println("Testing login with Username: " + uname + ", Password: " + pwd);
        WebElement username = webdriver.findElement(By.id("userName"));
        WebElement password = webdriver.findElement(By.id("password"));
        WebElement loginButton = webdriver.findElement(By.id("login"));

        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginButton.click();    
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        webdriver.quit();
    }	  
}
