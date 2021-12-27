package com.qmetry.qaf.example.comp;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class LoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @FindBy(locator = "login.comp.password")
    private QAFWebElement password;

    @FindBy(locator = "login.comp.email")
    private QAFWebElement email;

    @FindBy(locator = "login.comp.submit")
    private QAFWebElement submit;

    @FindBy(locator = "login.comp.error")
    private QAFWebElement error;

    public void login(String email, String password) {
        driver.manage().window().maximize();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.submit.click();
    }

    public QAFWebElement getError(){
        return error;
    }

    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {
        driver.get("/");
    }
}
