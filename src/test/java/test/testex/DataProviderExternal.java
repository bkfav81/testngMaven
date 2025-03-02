package test.testex;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderExternal {
	
	@DataProvider(name = "loginData")
    public  Object[][] provideData() {
        return new Object[][]{
            {"user1", "password1"},
            {"user2", "password2"},
            {"user3", "password3"}
        };
	}
}
