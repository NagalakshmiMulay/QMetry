package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.example.comp.LoginPage;

public class StepsLibrary {
	/**
	 * @param searchTerm
	 *            : search term to be searched
	 */
	@QAFTestStep(description = "search for {0}")
	public static void searchFor(String searchTerm) {
		sendKeys(searchTerm, "input.search");
		click("button.search");
	}
	static LoginPage loginPage = new LoginPage();

	@QAFTestStep(description = "I login user with {0} and {1}")
	public static void userLogin(String userName, String password) {
		loginPage.login(userName, password);
	}

	@QAFTestStep(description = "assert login failed {0}")
	public static void assertLoginFailed(String text) {
		loginPage.getError().assertText(text);
	}
}
