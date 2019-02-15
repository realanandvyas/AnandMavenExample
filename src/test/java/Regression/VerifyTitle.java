package Regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class VerifyTitle {
	
	@Test
	public void ClickEditTab(){
		WebDriver driver = new ChromeDriver();
		driver.get("https://ci.datakonnect.com/");
		Assert.assertTrue(driver.getTitle().contains("Anand"));
		driver.quit();
}}
