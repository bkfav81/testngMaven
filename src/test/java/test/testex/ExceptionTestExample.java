package test.testex;

import org.testng.annotations.Test;

public class ExceptionTestExample {
	@Test(expectedExceptions = ArithmeticException.class)
    public void testException() {
        System.out.println("Testing ArithmeticException");
        int result = 1 / 0; // This will throw ArithmeticException
    }
}
