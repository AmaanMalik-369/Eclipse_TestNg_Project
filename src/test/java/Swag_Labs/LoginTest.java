package Swag_Labs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import swagLab_pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test(priority = 0)
	public void LoginSuccessTest() {

		LoginPage lp = new LoginPage();
		lp.LoginFunction("standard_user", "secret_sauce");

		WebElement ProductTitle = driver.findElement(By.className("title"));
		Assert.assertEquals(ProductTitle.getText(), "Products");

	}

	@Test (priority = 1)
	public void LoginFailureTest() {
		
		LoginPage lp = new LoginPage();
		lp.LoginFunction("standard_user", "secret_test");
		
		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(ErrorMsg.getText(), "Epic sadface: Username and password do not match any user in this service");
	}
	
	@Test(priority = 2)
	public void LoginLogoutUser() {

		LoginPage lp = new LoginPage();
		lp.LoginFunction("locked_out_user", "secret_sauce");

		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(ErrorMsg.getText(), "Epic sadface: Sorry, this user has been locked out.");

	}
}
