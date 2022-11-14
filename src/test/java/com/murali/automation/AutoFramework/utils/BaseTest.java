package com.murali.automation.AutoFramework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeTest
	public void openBrowser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
