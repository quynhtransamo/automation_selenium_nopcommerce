package commons;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}

	private By getByLocator(String locatorType) {
		By by = null;
		if(locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		}else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	} 
	
	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		if(locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
	}
	
	public void waitForElementVisible(WebDriver driver, String locatorType) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathExpression, String... dynamicValues) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(xpathExpression, dynamicValues))));
	}
	
	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String value) {
		getWebElement(driver, locatorType).clear();
	getWebElement(driver, locatorType).sendKeys(value);
	}

	public void selectItemDefaultDropdown(WebDriver driver, String locatorType, String itemText) {
		new Select(getWebElement(driver, locatorType)).selectByVisibleText(itemText);
	}

	public void checkToRadioOrCheckbox(WebDriver driver, String locatorType, String... dynamicValues) {
		if(!getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected()) {
			getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
		}
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}

	private long longTimeout = 30;
}