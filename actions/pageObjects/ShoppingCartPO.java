package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPO extends BasePage {
	WebDriver driver;
	
	public ShoppingCartPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProductName(WebDriver driver) {
		waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_NAME);
		return getElementText(driver, ShoppingCartPageUI.PRODUCT_NAME);
	}

	public String getRamHddValue(WebDriver driver) {
		waitForElementVisible(driver, ShoppingCartPageUI.RAM_HDD);
		return getElementText(driver,ShoppingCartPageUI.RAM_HDD);
	}
	

	public String getQuantityValue(WebDriver driver) {
		waitForElementVisible(driver, ShoppingCartPageUI.QUANTITY);
		return getElementAttribute(driver, ShoppingCartPageUI.QUANTITY, "value");
	}	

}
