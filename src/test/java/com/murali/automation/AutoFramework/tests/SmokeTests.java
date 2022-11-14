package com.murali.automation.AutoFramework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.murali.automation.AutoFramework.pages.HomePage;
import com.murali.automation.AutoFramework.pages.SearchResultsPage;
import com.murali.automation.AutoFramework.pages.ShoppingCartPage;
import com.murali.automation.AutoFramework.utils.BaseTest;

public class SmokeTests extends BaseTest{
	 SoftAssert softAssert = new SoftAssert();
	WebDriver driver;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	ShoppingCartPage shoppingCartPage;

	@BeforeClass
	public void setup() {
		homePage = new HomePage(getDriver());
		
	}

	@Test
	public void verifySuccessfulSearchOfItem() {
		//driver.findElement(By.xpath("//*[@id='search']/input")).clear();
		homePage.clearSearchText();
		//driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("iphone");
		homePage.enterSearchText("iPhone");
		//driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		searchResultsPage = homePage.clickOnSearchButton();
		System.out.println(searchResultsPage.getItemDescription());
		searchResultsPage.clickOnAddToCart();
		searchResultsPage.clickOnCart();
		shoppingCartPage = searchResultsPage.clickOnViewCart();
		System.out.println(shoppingCartPage.getItemDescription());
		softAssert.assertEquals(shoppingCartPage.getItemDescription(), "iPhones");
		System.out.println(" it proceeds");
		softAssert.assertAll();
		
		/*
		 * String dressName = driver.findElement(By.xpath(
		 * "//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/p[1]")) .getText();
		 * System.out.println(dressName);
		 */
	}

	@Test
	public void verifySuccessfulSearchOfMacBook() {
		//driver.findElement(By.xpath("//*[@id='search']/input")).clear();
		homePage.clearSearchText();
		//driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("MacBook");
		homePage.enterSearchText("MacBook");
		//driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		homePage.clickOnSearchButton();
		/*
		 * String dressName = driver.findElement(By.xpath(
		 * "//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")) .getText();
		 * System.out.println(dressName);
		 */
	}

	

}
