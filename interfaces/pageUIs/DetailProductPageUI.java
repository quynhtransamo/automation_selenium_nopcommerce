package pageUIs;

public class DetailProductPageUI {
	public static final String RAM_DROPDOWN = "xpath=//select[@id='product_attribute_2']";
	public static final String HDD_RADIOBUTTON= "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String QUANTITY_TEXTBOX = "xpath=//input[starts-with(@class,'qty-input')]";
	public static final String ADDTOCARD_BUTTON = "xpath=//button[text()='%s']";
	public static final String SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']/p";
	public static final String SHOPPING_CART_BUTTON = "xpath=//div[@class='bar-notification success']//a";
	
}
