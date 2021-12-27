package com.qmetry.qaf.example.comp;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AmazonLogin extends WebDriverBaseTestPage<WebDriverTestPage> {

    @FindBy(locator = "Amazonlogin.comp.signinlink")
    private QAFWebElement signinlink;

@FindBy(locator = "Amazonlogin.comp.password")
private QAFWebElement ap_password;

@FindBy(locator = "Amazonlogin.comp.email")
private QAFWebElement ap_email;

@FindBy(locator = "Amazonlogin.comp.continue")
private QAFWebElement continuebutton;

@FindBy(locator = "Amazonlogin.comp.signin")
private QAFWebElement signInSubmit;

public void login(String email,String password){
        driver.manage().window().maximize();
        this.signinlink.click();
        this.ap_email.sendKeys(email);
        this.continuebutton.click();
        this.ap_password.sendKeys(password);
        this.signInSubmit.click();
        if (password.contains("sports143"))
        waitForTextPresent("Swathi");
        }

//public QAFWebElement getError(){
 //       return error;
  //      }

@Override
protected void openPage(PageLocator pageLocator,Object...objects){
        driver.get("/");
        }
}


