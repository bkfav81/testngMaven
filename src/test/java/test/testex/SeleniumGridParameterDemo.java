package test.testex;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGridParameterDemo {
  @Test
  @Parameters({"browsername"})
  public void SeleniumGridParameter(String browsername) throws MalformedURLException {
	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	  desiredCapabilities.setBrowserName(browsername);
	  desiredCapabilities.setPlatform(Platform.WIN10);
	  
	  RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.29.90:4444"),desiredCapabilities);
	  
	  driver.get("https://demoqa.com/login");

      // Locate and interact with elements
      WebElement usernameField = driver.findElement(By.id("userName"));
      WebElement passwordField = driver.findElement(By.id("password"));
      WebElement loginButton = driver.findElement(By.id("login"));      
      usernameField.sendKeys("tonyjaa");
      passwordField.sendKeys("Tonyjaa#1");
      loginButton.click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));      
      WebElement profileElement = driver.findElement(By.xpath("//span[text()='Profile']"));
      Assert.assertTrue(profileElement.isDisplayed(), "Login failed!");
	  
  }
}
