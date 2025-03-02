package test.testex;

import org.testng.annotations.Test;

public class ListenerExampleTest {

    @Test
    public void testLoginSuccess() {
        System.out.println("Login Test Passed");
        // Add logic for successful login
    }

    @Test
    public void testLoginFailure() {
        System.out.println("Login Test Failed");
        throw new AssertionError("Intentional Failure");
    }
}
