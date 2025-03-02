package test.testex;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginTests {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    @BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
    }

    @Test
    public void testValidLogin() {
        WebElement username = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        username.sendKeys("tonyjaa");
        password.sendKeys("Tonyjaa#1");
        loginButton.click();    
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testInvalidLogin() {
        WebElement username = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        username.sendKeys("invalidUsername");
        password.sendKeys("invalidPassword");
        loginButton.click();
     // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       System.out.println(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("name")))).getText());
     }

    @Test //(enabled = false)
    public void testEmptyFields() {
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
     // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}