package com.murali.automation.AutoFramework.tests;

import java.io.IOException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.murali.automation.AutoFramework.pages.HomePage;
import com.murali.automation.AutoFramework.pages.SearchResultsPage;
import com.murali.automation.AutoFramework.pages.ShoppingCartPage;
import com.murali.automation.AutoFramework.utils.BaseTest;
import com.murali.automation.AutoFramework.utils.DataReader;
import com.murali.automation.AutoFramework.utils.ExcelUtility;

public class SmokeTests extends BaseTest {
	private static final Logger logger = LogManager.getLogger(SmokeTests.class);
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	ShoppingCartPage shoppingCartPage;
	private String testName;
	private int row;

	@BeforeClass
	public void setup() {
		logger.info("Entered Setup Method");
		homePage = new HomePage(getDriver());

	}

	@DataProvider(name = "items")
	public static Object[] items() throws Exception {
		Object[] item = null;
		System.out.println("*************" + DataReader.getCellData(0, 0));
		item[0] = DataReader.getCellData(0, 0);
		return item;
	}

	@DataProvider(name = "values")
	public Object[] SearchKeys() throws Exception {
	 	ExcelUtility.setExcelFile("C:\\Users\\navee\\Projects\\AutoFramework\\data\\TestData.xlsx","data");
	 	Object[] testObjArray = ExcelUtility
				.getTableArray("C:\\Users\\navee\\Projects\\AutoFramework\\data\\TestData.xlsx", "data", 1);
		System.out.println(" Data ------****************" +Arrays.deepToString(testObjArray));
		return (testObjArray);

	}

	@Test(dataProvider = "values")
	public void verifyGetData(String data, String value ) {
		System.out.println(" Data from Excel " + value);
	}

	@Test(dataProvider = "values")
	public void verifySuccessfulSearchOfItem(String searchKey) throws WebDriverException, IOException {
		logger.debug("Entered Test Method - verifySuccessfulSearchOfItem");
		// driver.findElement(By.xpath("//*[@id='search']/input")).clear();
		homePage.clearSearchText();
		// driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("iphone");
		homePage.enterSearchText(searchKey);
		// driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		searchResultsPage = homePage.clickOnSearchButton();
		System.out.println(searchResultsPage.getItemDescription());
		searchResultsPage.clickOnAddToCart();
		searchResultsPage.clickOnCart();
		shoppingCartPage = searchResultsPage.clickOnViewCart();
		System.out.println(shoppingCartPage.getItemDescription());
		softAssert.assertEquals(shoppingCartPage.getItemDescription(), searchKey);
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
