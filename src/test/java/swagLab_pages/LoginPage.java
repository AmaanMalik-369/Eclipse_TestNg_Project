package swagLab_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Swag_Labs.BaseClass;

public class LoginPage {
	
	WebDriver driver = BaseClass.driver;
	
	public void LoginFunction(String UserNameVal, String PasswordVal) {
		
		WebElement UserName = driver.findElement(By.xpath("//input[@id='user-name']"));
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement LoginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
		
		UserName.sendKeys(UserNameVal);
		Password.sendKeys(PasswordVal);
		LoginBtn.click();
		
	}
}
