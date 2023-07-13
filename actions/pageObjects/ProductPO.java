package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.ProductPageUI;

public class ProductPO extends BasePage {
	WebDriver driver;
	
	public ProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickProductName(WebDriver driver, String productName) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_TITLE, productName);
		clickToElement(driver, ProductPageUI.PRODUCT_TITLE, productName);
	}

}
