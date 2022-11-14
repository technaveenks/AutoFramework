package com.murali.automation.AutoFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	// driver
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	//element identification
	@FindBy(xpath="//*[@id='search']/input")
	private WebElement _searchTextBox;
	
	
	@FindBy(xpath="//*[@id='search']/span/button")
	private WebElement _searchButton;
	
	//action
	public void clearSearchText() {
		_searchTextBox.clear();
	}
	
	public void enterSearchText(String searchText) {
		_searchTextBox.sendKeys(searchText);
	}
	
	public SearchResultsPage clickOnSearchButton() {
		_searchButton.click();
		return new SearchResultsPage(getDriver());
	}
}
