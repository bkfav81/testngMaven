package test.testex;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FactoryExample {

    private String username;
    private String password;
    WebDriver driver;

    // Constructor to initialize data
    public FactoryExample(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Test
    public void testLogin() {
        System.out.println("Logging in with Username: " + username + " and Password: " + password);
        // Add Selenium code for login using https://demoqa.com/login
        
        WebElement uname = driver.findElement(By.id("userName"));
        WebElement pwd = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        uname.sendKeys(username);
        pwd.sendKeys(password);
        loginButton.click();    
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Factory method to provide test instances
    public static class TestFactory {
        @Factory
        public Object[] factoryMethod() {
            return new Object[]{
                    new FactoryExample("user1", "password1"),
                    new FactoryExample("user2", "password2")
            };
        }
    }
}
