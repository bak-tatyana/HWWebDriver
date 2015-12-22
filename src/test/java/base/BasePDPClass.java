package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BasePDPClass {

	protected WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String url = "https://qa-cluster.lb.marks.kyiv.epam.com/en/categories/womens/footwear/winter/product/alpine-vista-ii-jacket-37076.html#37076[color]=BLACK";
		driver.get(url);
		driver.manage().deleteCookieNamed("PHPSESSID");
		driver.get(url);
	}

	// @AfterClass
	// public void tearDown() throws IOException {
	// driver.quit();
	// }

}
