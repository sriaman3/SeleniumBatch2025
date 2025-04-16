package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By userName = By.id("input-email");
	
	private By pass = By.id("input-password");
	
	private By lgnBtn = By.xpath("//input[@value='Login']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public String getLoginPageUrl() {
		
		return driver.getCurrentUrl();
	}
	
	public void doLogin(String uN, String pwd) {
		
		driver.findElement(userName).sendKeys(uN);
		driver.findElement(pass).sendKeys(pwd);
		driver.findElement(lgnBtn).click();
	}
}
