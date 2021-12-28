package com.qmetry.qaf.example.test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.example.steps.ui.AmazonPageSteps.*;

public class SampleTest extends WebDriverTestCase {

	@Test(dataProvider = "data")
	public void testLogin(String userName,String password,String text) {
		get("/");
		userLogin(userName,password);
		//assertLoginFailed(text);
		assertLogin(text);
	}

	@DataProvider
	public Object[][] data(){
		return new Object[][]{
				{"admin123","123abc123","Invalid password"},
				{"admin@gmail.com","123abc123","Invalid password"},
		};
	}
}
