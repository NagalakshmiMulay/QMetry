package com.qmetry.qaf.example.listeners;

import com.qmetry.qaf.automation.keys.ApplicationProperties;
import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriverCommandAdapter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DriverCommand;

public class WDListener extends QAFWebDriverCommandAdapter {

	public static void setup() {
		WebDriverManager driverManager = null;
		String driverName = ApplicationProperties.DRIVER_NAME.getStringVal("firefoxDriver").toLowerCase();
		if (driverName.contains("remote")) {
			return;
		} else if (driverName.contains("chrome")) {
			driverManager = WebDriverManager.chromedriver();
		} else if (driverName.contains("firefox")) {
			driverManager = WebDriverManager.firefoxdriver();
		} else if (driverName.contains("opera")) {
			driverManager = WebDriverManager.operadriver();
		} else if (driverName.contains("edge")) {
			driverManager = WebDriverManager.edgedriver();
		} else if (driverName.contains("ie")) {
			driverManager = WebDriverManager.iedriver();
		}
		if (driverManager != null) {
			driverManager.setup();
		}
	}

	@Override
	public void beforeInitialize(Capabilities desiredCapabilities) {
		setup();
	}

	@Override
	public void afterCommand(QAFExtendedWebDriver driver, CommandTracker commandTracker) {
		if (commandTracker.getCommand().equalsIgnoreCase(DriverCommand.GET)) {

			driver.manage().window().maximize();
		}
	}


}