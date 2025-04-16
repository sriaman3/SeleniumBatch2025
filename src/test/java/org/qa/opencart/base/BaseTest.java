package org.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.qa.opencart.factory.DriverFactory;
import org.qa.opencart.listeners.AppListeners;
import org.qa.opencart.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	protected LoginPage lp;
	protected DriverFactory df;
	protected Properties prop;
	protected AppListeners applis;
	
	@BeforeTest
	public void setUp() {
		
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.init_driver(prop);
		
		lp = new LoginPage(driver);
		
		applis = new AppListeners();
		applis.setDriver(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}
}
