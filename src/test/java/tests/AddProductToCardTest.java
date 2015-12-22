package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import core.Utils;

import pages.PDPpage;

import base.BasePDPClass;

public class AddProductToCardTest extends BasePDPClass {

	@Test
	/* (groups="smoke") */
	public void verifyProductInCard() throws InterruptedException {
		PDPpage pdppage = new PDPpage(driver);

		pdppage.selectColor();
		pdppage.selectSIZE();
		pdppage.selectQty();
		pdppage.clickAddToCardButton();

		Utils.waitForLoad(driver);

		System.out.println(pdppage.checkAddedQTY());

		Assert.assertEquals(pdppage.checkAddedQTY(), "1");
	}

	@Test
	/* (groups="smoke") */
	public void verifyISElemPres() throws InterruptedException {

		Utils.waitForLoad(driver);

		Assert.assertTrue(driver.findElement(
				By.xpath("//span[contains(., '1')]")).isDisplayed());

	}

	@Test
	/* (groups="smoke") */
	public void verifyShopCart() throws InterruptedException {
		PDPpage pdppage = new PDPpage(driver);

		pdppage.clickMiniCartButton();

		Utils.waitForLoad(driver);

		Assert.assertEquals(
				driver.findElement(
						By.xpath("//a[@href='https://qa-cluster.lb.marks.kyiv.epam.com/en/categories/womens/footwear/winter/product/alpine-vista-ii-jacket-37076.html#37076%5Bcolor%5D=BLACK%5Bsize%5D=S']"))
						.getText(), "ALPINE VISTA II JACKET");
	}

}
