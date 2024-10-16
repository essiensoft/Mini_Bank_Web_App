package com.inetBankingV1.testCases;

import com.inetBankingV1.utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	public String baseUrl = readConfig.getApplicationURL();
	public String username = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static WebDriver driver;

	// Use Log4j 2.x Logger
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		// Initialize Log4j 2.x logger
		logger = LogManager.getLogger("ebanking");

		// Log setup information
		logger.info("Driver initialized and e-banking test setup started.");
		logger.info("Navigating to: " + baseUrl);

		// Navigate to the base URL
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() {
		// Log tear down information
		logger.info("Test execution completed. Closing the browser.");
		// Quit the driver
		driver.quit();
	}
}
