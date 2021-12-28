package com.qmetry.qaf.example.steps.ui;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.example.comp.AmazonLogin;
import com.qmetry.qaf.example.comp.LoginPage;

public class AmazonPageSteps {
    static AmazonLogin loginPage = new AmazonLogin();

    @QAFTestStep(description = "I login user with {0} and {1}")
    public static void userLogin(String userName, String password) {
        loginPage.login(userName, password);
       // com.qmetry.qaf.automation.step.
    }


    //@QAFTestStep(description = "assert login failed {0}")
    @QAFTestStep(description="assert login {0}")
    public static void assertLogin(String text) {
    // public static void assertLoginFailed(String text) {
   //     loginPage.getError().assertText(text);
    }

}
