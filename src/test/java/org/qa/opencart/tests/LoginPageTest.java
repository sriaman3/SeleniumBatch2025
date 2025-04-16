package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.constants.FrameworkConstant;
import org.qa.opencart.listeners.AppListeners;
import org.qa.opencart.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AppListeners.class)
public class LoginPageTest extends BaseTest{
	
	
	@Test(priority=1)
	public void verifyLoginTitle() {
		String title = lp.getLoginPageTitle();
		
		Assert.assertEquals(title, FrameworkConstant.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyLoginUrl() {
		String url = lp.getLoginPageUrl();
		
		Assert.assertEquals(url, FrameworkConstant.LOGIN_PAGE_URL);
	}
	
	@Test(priority=3, enabled=false)
	public void verifyLoginFunctionalityWithPropertiesFile() {
		
		lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertEquals(title, "Account Login");
	}
	
	@Test(priority=3, dataProvider = "getLoginTestExcelData")
	public void verifyLoginFunctionalityWithExcel(String uN, String pwd) {
		
		lp.doLogin(uN, pwd);
		//Assert.assertEquals(title, "Account Login");
	}
	
	/**
	 * With Excel Data sheet
	 * @return 
	 * @return
	 */
	@DataProvider
	public Object[][] getLoginTestExcelData() {
		return ExcelUtil.getExcelData(FrameworkConstant.LOGIN_DATA_SHEET_NAME);
		
	}
	

}
