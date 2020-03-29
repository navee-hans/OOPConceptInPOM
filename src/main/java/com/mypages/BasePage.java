package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try{
				waitForElementPresent(locator);
				element = driver.findElement(locator);
				return element;
		}catch(Exception e)
		{
			System.out.println("Element not found error on DOM " + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e)
		{
			System.out.println("Som exception occurred while waiting for the element " + locator.toString());
			System.out.println("Som exception occurred while waiting for the element resolve conflicts " + locator.toString());
		}
		
	}

	@Override
	public void waitForPageTitle(String title) {
		try{
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e)
		{
			System.out.println("Som exception occurred while waiting for page title " + title);
		}
		
	}

}
