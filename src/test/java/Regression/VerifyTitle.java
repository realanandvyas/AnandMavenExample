package Regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyTitle {
	
	@Test
	public void ClickEditTab(){
		WebDriver driver = new ChromeDriver();
		driver.get("https://ci.datakonnect.com/");
		driver.quit();
}}
