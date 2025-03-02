package test.testex;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestGroup {

	WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    @BeforeClass(alwaysRun=true)
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
    }
	
    @Test(groups = {"sanity"})
    public void testLoginPageTitle() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertTrue(title.contains("DEMOQA"));
    }

    @Test(groups = {"sanity", "smoke"})
    public void testLoginFormPresence() {
        WebElement usernameField = driver.findElement(By.id("userName"));
        WebElement passwordField = driver.findElement(By.id("password"));
        Assert.assertTrue(usernameField.isDisplayed() && passwordField.isDisplayed(), "Login form is not present");
    }

    @Test(groups = {"smoke", "regression"})
    public void testValidLogin() {
        driver.findElement(By.id("userName")).sendKeys("testUser");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("login")).click();
        WebElement logoutButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Login failed.");
    }

    @Test(groups = {"regression"})
    public void testInvalidLogin() {
        driver.findElement(By.id("userName")).sendKeys("invalidUser");
        driver.findElement(By.id("password")).sendKeys("wrongPassword");
        driver.findElement(By.id("login")).click();
        WebElement errorMsg = driver.findElement(By.id("name"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed for invalid login.");
    }
  @AfterClass(alwaysRun=true)
  public void tearDown() {
      driver.quit();
  }

}
