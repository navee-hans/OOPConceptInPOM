package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//Construtor of Abstract class 
	public Page(WebDriver driver)
	{
		this.driver = driver;
		
		//Explicit wait
		this.wait = new WebDriverWait(driver, 20);
	}
	
	//abstract should have below methods
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By Locator);
	
	public abstract WebElement getElement(By Locator);
	
	public abstract void waitForElementPresent(By Locator);
	
	public abstract void waitForPageTitle(String title);
	
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass){
		
		try{
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

}
