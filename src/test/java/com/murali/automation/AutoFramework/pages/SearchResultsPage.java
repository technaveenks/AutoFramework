package com.murali.automation.AutoFramework.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends BasePage{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='content']/div[3]/div/div/div[2]/div[1]/p[1]")
	private WebElement _itemDescription;
	
	@FindBy(xpath="//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[1]")
	private WebElement _addToCartButton;
	
	@FindBy(xpath="//*[@id='cart']/button")
	private WebElement _cartButton;
	
	@FindBy(xpath = "//*[@id='cart']/ul/li[2]/div/p/a[1]")
	private WebElement _linkViewCart;
	
	public String getItemDescription() {
		return _itemDescription.getText();
	}
	
	public void clickOnAddToCart() {
		_addToCartButton.click();
	}
	public void clickOnCart() {
		WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(_cartButton));
		element.click();
	}
	public ShoppingCartPage clickOnViewCart() {
		WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(_linkViewCart));
		element.click();
		return new ShoppingCartPage(getDriver());
	}

}
