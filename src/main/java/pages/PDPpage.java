package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;

public class PDPpage {

	WebDriver driver;

	public PDPpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@title='BLACK']")
	private WebElement color;

	@FindBy(xpath = "//select[@class='sku-control-list__select']")
	private WebElement size;

	@FindBy(id = "product-detail-form__title")
	private WebElement qty;

	@FindBy(xpath = "//button[@class='add-to-cart__btn btn btn_icon']")
	private WebElement addToCardButton;

	@FindBy(xpath = "//a[@href='/en/shopping-cart.html']")
	private WebElement miniCartButton;

	@FindBy(xpath = "//span[@class='header-cart__quantity']")
	private WebElement miniCartQTY;

	@FindBy(xpath = "//span[contains(., '1')]")
	private WebElement miniCartQTY1;

	@FindBy(xpath = "//body")
	private WebElement allPage;

	public void selectColor() {
		color.click();
	}

	public void selectSIZE() {
		Select select = new Select((WebElement) size);
		select.selectByVisibleText("Small");
	}

	public void selectQty() {
		Select select = new Select((WebElement) qty);
		select.selectByVisibleText("1");

	}

	public void clickAddToCardButton() {
		addToCardButton.click();
	}

	public String checkAddedQTY() {

		while (miniCartQTY1.getSize() == null)
			allPage.sendKeys(Keys.F5);
		// element appear after text READY is presented

		return (miniCartQTY.getText());
	}

	public void clickMiniCartButton() {
		miniCartButton.click();
	}

}
