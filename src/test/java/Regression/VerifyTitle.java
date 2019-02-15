package Regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyTitle {
	
	@Test
	public void ClickEditTab() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://ci.datakonnect.com/");
		
		WebElement h1Element = driver.findElement(By.id("startIco"));
		h1Element.click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		
		
		driver.findElement(By.name("username")).sendKeys("yl");
		driver.findElement(By.name("password")).sendKeys("yl");
		
		WebElement h2Element = driver.findElement(By.id("login-button"));
		h2Element.click();
		
		System.out.println("Loggin testcase successfully passed");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement findcreateCandidateButton = driver.findElement(By.xpath("//*[@id=\"dk-main-header-innerCt\"]/div/a[2]"));
		findcreateCandidateButton.click();
		
		driver.findElement(By.name("person__first_name")).sendKeys("Anand");
		driver.findElement(By.name("person__last_name")).sendKeys("Vyas");
		
		
		driver.findElement(By.xpath(".//*[contains(text(),'Job Title:')]/following::input[1]")).sendKeys("Java Developer");
		driver.findElement(By.name("create")).click();
		System.out.println("Candidate created successfully");
		Thread.sleep(2000);
		driver.quit();
		}

		
}
