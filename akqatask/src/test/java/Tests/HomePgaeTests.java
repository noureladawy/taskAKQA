package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;

public class HomePgaeTests {
	WebDriver driver;

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.jagermeister.com/en-GB/home");

	}

	@Parameters({ "validbirthday", "validbirthmonth", "validbirthyear" })
	@Test(priority = 1)

	public void verifyValidBirthdateData(String birthday, String birthmonth, String birthyear)
			throws InterruptedException {

		// Creating object of Home page
		HomePage BirthdatePage = new HomePage(driver);

		BirthdatePage.enterBirthdata(birthday, birthmonth, birthyear);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleIs("Be The Meister | Jägermeister"));
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Be The Meister | Jägermeister";
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Parameters({ "validbirthday", "validbirthmonth", "LessThanEighteenbirthyear" })
	@Test(priority = 2)

	public void verifyLessThanEighteenBirthdateData(String birthday, String birthmonth,
			String birthyear) throws InterruptedException {

		// Creating object of Home page
		HomePage BirthdatePage = new HomePage(driver);

		BirthdatePage.enterBirthdata(birthday, birthmonth, birthyear);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Jägermeister";
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}
	
	@Parameters({ "invalidbirthday", "invalidbirthmonth", "invalidbirthyear" })
	@Test(priority = 3)

	public void verifyinvalidBirthdateDay(String birthday, String birthmonth,
			String birthyear) throws InterruptedException {

		// Creating object of Home page
		HomePage BirthdatePage = new HomePage(driver);

		BirthdatePage.enterBirthdata(birthday, birthmonth, birthyear);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Jägermeister";
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}
	
	
	

	@AfterMethod
	public void terminateBrowser() {
		driver.close();
	}


}
