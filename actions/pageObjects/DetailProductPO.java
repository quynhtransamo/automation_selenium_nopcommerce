package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.DetailProductPageUI;

public class DetailProductPO extends BasePage {
	WebDriver driver;
	
	public DetailProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectRamDropdownlist(WebDriver driver, String ramItem) {
		waitForElementClickable(driver, DetailProductPageUI.RAM_DROPDOWN);
		selectItemDefaultDropdown(driver, DetailProductPageUI.RAM_DROPDOWN, ramItem);
		sleepInSecond(2);
	}

	public void clickHddRadiobutton(WebDriver driver, String hddItem) {
		waitForElementClickable(driver, DetailProductPageUI.HDD_RADIOBUTTON, hddItem );
		checkToRadioOrCheckbox(driver, DetailProductPageUI.HDD_RADIOBUTTON, hddItem);
		
	}
	
	public void inputQuantityTextbox(WebDriver driver, String quantity) {
		waitForElementVisible (driver, DetailProductPageUI.QUANTITY_TEXTBOX);
		sendkeyToElement(driver, DetailProductPageUI.QUANTITY_TEXTBOX, quantity);
		
	}

	public void clickAddtocardButton(WebDriver driver, String buttonName) {
		waitForElementClickable(driver, DetailProductPageUI.ADDTOCARD_BUTTON, buttonName);
		clickToElement(driver, DetailProductPageUI.ADDTOCARD_BUTTON, buttonName);
		
	}
	public String getSuccessMessage(WebDriver driver) {
		waitForElementVisible(driver, DetailProductPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, DetailProductPageUI.SUCCESS_MESSAGE);
	}

	public void clickShoppingCartLink(WebDriver driver) {
		waitForElementClickable(driver, DetailProductPageUI.SHOPPING_CART_BUTTON);
		clickToElement(driver, DetailProductPageUI.SHOPPING_CART_BUTTON);
	}

	
	
}
