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

public class CustomizeReportLoginTest extends CustomizeReportBase {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
    }

    @Test
    public void validLoginTest() {
        extentTest = extentReports.createTest("Valid Login Test");
        driver.get("https://demoqa.com/login");

        // Locate and interact with elements
        WebElement usernameField = driver.findElement(By.id("userName"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        extentTest.info("Entering valid username and password");
        usernameField.sendKeys("tonyjaa");
        passwordField.sendKeys("Tonyjaa#1");
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        extentTest.info("Checking login success");
        WebElement profileElement = driver.findElement(By.xpath("//span[text()='Profile']"));
        Assert.assertTrue(profileElement.isDisplayed(), "Login failed!");

        extentTest.pass("Valid Login Test Passed");
    }

    @Test
    public void invalidLoginTest() {
        extentTest = extentReports.createTest("Invalid Login Test");
        driver.get("https://demoqa.com/login");

        // Locate and interact with elements
        WebElement usernameField = driver.findElement(By.id("userName"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        extentTest.info("Entering invalid username and password");
        usernameField.sendKeys("invalidUser");
        passwordField.sendKeys("invalidPassword");
        loginButton.click();

        extentTest.info("Checking login failure");
        WebElement errorMessage = driver.findElement(By.id("name"));
        Assert.assertEquals(errorMessage.getText(), "Invalid username or password!", "Error message mismatch");

        extentTest.pass("Invalid Login Test Passed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
