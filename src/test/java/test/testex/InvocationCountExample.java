package test.testex;

import org.testng.annotations.Test;

public class InvocationCountExample {
	@Test(invocationCount = 3)
    public void testMultipleLogins() {
        System.out.println("Performing login...");
        // Add Selenium logic for logging in to site
    }
}
