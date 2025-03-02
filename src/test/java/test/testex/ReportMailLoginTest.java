package test.testex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class ReportMailLoginTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
    }

    @Test
    public void loginTest() throws IOException {
        WebElement username = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        username.sendKeys("tonyjaa");
        password.sendKeys("Tonyjaa#1");
        loginButton.click();    
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Verify successful login
        WebElement logoutButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Login Failed");

        // Write result to customized report
        writeReport("Test Case: Login Test - Passed");
    }

    public void writeReport(String data) throws IOException {
        FileWriter writer = new FileWriter("C:\\projectScreenshots\\TestReport.txt", true);
        writer.write(data + "\n");
        writer.close();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
