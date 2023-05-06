package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage {
  
	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created	
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
	}
	
	// Locator for birthDay field
		By birthDay = By.id("DD");
	// Locator for birthMonth field
		By birthMonth = By.id("MM");
	// Locator for birthYear field
		By birthYear = By.id("YYYY");
		
		

		public void enterBirthdata(String birthday, String birthmonth,String birthyear) {

			driver.findElement(birthDay).sendKeys(birthday);
			driver.findElement(birthMonth).sendKeys(birthmonth);
			driver.findElement(birthYear).sendKeys(birthyear);
			
		}

}
