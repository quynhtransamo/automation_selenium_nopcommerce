package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePO extends BasePage {
	WebDriver driver;

	public HomePO(WebDriver driver) {
		this.driver = driver;
	}

	public void openCategoryMenu(WebDriver driver, String menuName, String submenuName) {
		waitForElementClickable(driver, HomePageUI.MENU , menuName);
		clickToElement(driver, HomePageUI.MENU, menuName);
		waitForElementClickable(driver, HomePageUI.SUB_MENU , submenuName);
		clickToElement(driver, HomePageUI.SUB_MENU, submenuName);
		
		
	}


	
}
