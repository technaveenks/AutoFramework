package com.murali.automation.AutoFramework.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.murali.automation.AutoFramework.pages.HomePage;
import com.murali.automation.AutoFramework.pages.SearchResultsPage;
import com.murali.automation.AutoFramework.pages.ShoppingCartPage;
import com.murali.automation.AutoFramework.utils.BaseTest;

public class SmokeTests extends BaseTest {
	private static final Logger logger = LogManager.getLogger(SmokeTests.class);
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	ShoppingCartPage shoppingCartPage;

	@BeforeClass
	public void setup() {
		logger.info("Entered Setup Method");
		homePage = new HomePage(getDriver());

	}

	@Test
	public void verifySuccessfulSearchOfItem() throws WebDriverException, IOException {
		logger.debug("Entered Test Method - verifySuccessfulSearchOfItem");
		// driver.findElement(By.xpath("//*[@id='search']/input")).clear();
		homePage.clearSearchText();
		// driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("iphone");
		homePage.enterSearchText("iPhone");
		// driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		searchResultsPage = homePage.clickOnSearchButton();
		System.out.println(searchResultsPage.getItemDescription());
		searchResultsPage.clickOnAddToCart();
		searchResultsPage.clickOnCart();
		shoppingCartPage = searchResultsPage.clickOnViewCart();
		System.out.println(shoppingCartPage.getItemDescription());
		softAssert.assertEquals(shoppingCartPage.getItemDescription(), "iPhone");
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
		// driver.findElement(By.xpath("//*[@id='search']/input")).clear();
		homePage.clearSearchText();
		// driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("MacBook");
		homePage.enterSearchText("MacBook");
		// driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		homePage.clickOnSearchButton();
		/*
		 * String dressName = driver.findElement(By.xpath(
		 * "//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")) .getText();
		 * System.out.println(dressName);
		 */
	}

}
