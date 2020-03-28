package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	//page locators:
	private By emailId = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("loginBtn");
	private By header = By.xpath("//i18n-string[@data-key='login.signupLink.text']");
	
	//Construtor
	public LoginPage(WebDriver driver) {
		super(driver);
	}


	//getters
	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	public String getLoginPageTitle() {
		return getPageTitle();
	}	
	
	public String getLoginPageHeader(){
		return getPageHeader(header);
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public HomePage doLogin(String username, String password){
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
		
		return getInstance(HomePage.class);
	}

	/**
	 * 
	 * @return
	 */
	public void doLogin(){
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getLoginButton().click();
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public void doLogin(String username){
		getEmailId().sendKeys(username);
		getPassword().sendKeys("");
		getLoginButton().click();
	}

}
