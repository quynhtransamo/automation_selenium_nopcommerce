package com.nop;

import org.testng.annotations.Test;
import pageObjects.ProductPO;
import pageObjects.DetailProductPO;
import pageObjects.HomePO;
import pageObjects.ShoppingCartPO;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Nop_Desktop {
	WebDriver driver;
	private HomePO homePage;
	private ProductPO categoryPage;
	private DetailProductPO detailProductPage;
	private ShoppingCartPO cartPage;
	private String menuName, categoryName, productName, ramItem, hddItem, quantity, buttonName, messageText;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty ("webdriver.chrome.driver", projectPath + "/BrowserDrivers/chromedriver");
		driver = new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePO(driver);
		
		menuName = "Computers";
		categoryName = "Desktops";
		productName = "Build your own computer";
		ramItem = "2 GB";
		hddItem = "320 GB";
		quantity = "4";
		buttonName = "Add to cart";
		messageText = "The product has been added to your shopping cart";
	}

	@Test
	public void TC_01_CreateProduct() {
		homePage.openCategoryMenu(driver, menuName, categoryName);
		categoryPage = new ProductPO(driver);
		
		categoryPage.clickProductName(driver, productName);
		detailProductPage = new DetailProductPO(driver);
		
		detailProductPage.selectRamDropdownlist(driver, ramItem);
		detailProductPage.clickHddRadiobutton(driver, hddItem);
		detailProductPage.inputQuantityTextbox(driver, quantity);
		detailProductPage.clickAddtocardButton(driver, buttonName);
		Assert.assertEquals(detailProductPage.getSuccessMessage(driver), messageText);
		detailProductPage.clickShoppingCartLink(driver);
		cartPage = new ShoppingCartPO(driver);
		Assert.assertEquals(cartPage.getProductName(driver), productName);
		Assert.assertTrue(cartPage.getRamHddValue(driver).contains(ramItem));
		Assert.assertTrue(cartPage.getRamHddValue(driver).contains(hddItem));
		Assert.assertEquals(cartPage.getQuantityValue(driver), quantity);
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
