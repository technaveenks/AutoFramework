package com.murali.automation.AutoFramework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeTests {
	WebDriver driver;

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

	@Test
	public void verifySuccessfulSearchOfItem() {
		driver.findElement(By.xpath("//*[@id='search']/input")).clear();
		driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("iphone");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();

		String dressName = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/p[1]"))
				.getText();
		System.out.println(dressName);
	}

	@Test
	public void verifySuccessfulSearchOfMacBook() {
		driver.findElement(By.xpath("//*[@id='search']/input")).clear();
		driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("MacBook");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();

		String dressName = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a"))
				.getText();
		System.out.println(dressName);
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
