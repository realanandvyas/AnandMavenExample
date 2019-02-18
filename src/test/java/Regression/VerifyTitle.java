package Regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class VerifyTitle {
	
	 // ----------------Global Variables----------
    // Declare a Webdriver variable
    public WebDriver driver;
    public ChromeOptions options;
    // Declare a test URL variable
    public String testURL = "https://ci.datakonnect.com/";
    public String username = "yl";
    public String password = "yl";

    // -----------------Test Setup---------------
    @BeforeClass
    public void setupTest() {
            // Create a new ChromeDriver
            options = new ChromeOptions();
            // options.addArguments("headless");
            options.addArguments("no-sandbox");
            // options.addArguments("disable-dev-shm-usage");
            driver = new ChromeDriver(options);
          //  driver.manage().window().fullscreen();
            driver.get(testURL);
            // driver.navigate().to(testURL);
            WebElement h1Element = driver.findElement(By.id("startIco"));
            h1Element.click();

            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

            driver.findElement(By.name("username")).sendKeys(username);
            driver.findElement(By.name("password")).sendKeys(password);

            WebElement h2Element = driver.findElement(By.id("login-button"));
            h2Element.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            System.out.println("Loggin testcase successfully passed");
    }

    @Test(priority = 0)
    public void CreateClientFromMenu() throws InterruptedException {
            System.out.println("START - CreateClientFromMenu");
            // driver.navigate().to(testURL);
            WebElement findcreateCandidateButton = driver
                            .findElement(By.xpath("//*[@id=\"dk-main-header-innerCt\"]/div/a[1]"));
            findcreateCandidateButton.click();

            WebElement findcreateCandidateMenuButton = driver.findElement(By.xpath(".//*[contains(text(),'Add Client')]"));
            findcreateCandidateMenuButton.click();

            driver.findElement(By.name("name")).sendKeys("Lloyd Harrington Australia TEST CI.datakonnect.com");
            driver.findElement(By.name("worksites")).sendKeys("Sydney");

            driver.findElement(By.name("create")).click();
            System.out.println("END - CreateClientFromMenu");
            Thread.sleep(4000);
    }
    
    @Test(priority = 1)
    public void CreateClientShortcutButton() throws InterruptedException {
    System.out.println("START - CreateClientShortcutButton");
    Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement findcreateCandidateButton = driver.findElement(By.xpath("//*[@id=\"dk-main-header-innerCt\"]/div/a[5]"));
	findcreateCandidateButton.click();
	
	driver.findElement(By.name("name")).sendKeys("Lloyd Harrington Australia");
	driver.findElement(By.name("worksites")).sendKeys("Sydney");
	
	driver.findElement(By.name("create")).click();
	System.out.println("END - CreateClientShortcutButton");
	Thread.sleep(4000);
    }
    
    
    @Test(priority =2 )
    public void CreateCandidateFromMenu() throws InterruptedException {
    System.out.println("START - CreateCandidateFromMenun");
    Thread.sleep(5000);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement findcreateCandidateButton = driver
			.findElement(By.xpath("//*[@id=\"dk-main-header-innerCt\"]/div/a[1]"));
	findcreateCandidateButton.click();

	WebElement findcreateCandidateMenuButton = driver
			.findElement(By.xpath(".//*[contains(text(),'Add Candidate')]/../div"));
	findcreateCandidateMenuButton.click();
	
	driver.findElement(By.name("person__first_name")).sendKeys("Anand");
	driver.findElement(By.name("person__last_name")).sendKeys("Vyas");


	driver.findElement(By.xpath(".//*[contains(text(),'Job Title:')]/following::input[1]")).sendKeys("SE");
	driver.findElement(By.name("create")).click();
	System.out.println("END - CreateCandidateFromMenun");

    }
    
    
    @Test(priority =3 )
    public void CreateCandidateShortcutButton() throws InterruptedException {
    	Thread.sleep(5000);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
    	
    	Faker faker = new Faker();
    	String clientName = faker.name().firstName();
    	String officeLocation = faker.name().lastName();
    	String updateClientName = faker.name().firstName();

		WebElement findcreateCandidateButton = driver
				.findElement(By.xpath("//*[@id=\"dk-main-header-innerCt\"]/div/a[5]"));
		findcreateCandidateButton.click();

		driver.findElement(By.name("name")).sendKeys(clientName);
		driver.findElement(By.name("worksites")).sendKeys(officeLocation);

		driver.findElement(By.name("create")).click();

//		// Validating client creation
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		WebElement msg = driver
//				.findElement(By.cssSelector(".x-header-text.x-window-header-text.x-window-header-text-default"));
//		String text = msg.getText();
//		System.out.println(text);
//		String expectedText = "ADD CLIENT";
//		AssertJUnit.assertEquals(text, expectedText);

		// Searching newly created client
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				".//*[@class='x-container dk-main-header-quick-search x-box-item x-container-default x-box-layout-ct']/div/div/table/tbody/tr/td/table/tbody/tr/td/input"))
				.sendKeys(clientName);

		driver.findElement(By.xpath(".//*[@class='x-boundlist-item'][1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[contains(text(),'Active')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[contains(text(),'Edit')]")).click();
		Thread.sleep(2000);
		System.out.println("START - UpdateClientName");
		Thread.sleep(5000);

		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys(updateClientName);
		driver.findElement(By.name("save")).click();
		Thread.sleep(3000);


    }
    

//    @Test(priority = 1)
//    public void CreateContactFromMenuTest() throws InterruptedException {
//            System.out.println("START - CreateContactFromMenuTest");
//            // driver.navigate().to(testURL);
//            WebElement findcreateCandidateButton = driver
//                            .findElement(By.xpath("//*[@id=\"dk-main-header-innerCt\"]/div/a[1]"));
//            findcreateCandidateButton.click();
//
//            WebElement findcreateCandidateMenuButton = driver.findElement(By.xpath(".//*[contains(text(),'Add Contact')]"));
//            findcreateCandidateMenuButton.click();
//
//            driver.findElement(By.name("person__first_name")).sendKeys("Anand");
//            driver.findElement(By.name("person__last_name")).sendKeys("Vyas");
//            driver.findElement(By.name("person__job_title__job_title")).sendKeys("Java Developer");
//
//            driver.findElement(By.xpath(".//*[contains(text(),'Client')]/../../table/tbody/tr/td[2]/div")).click();
//            Thread.sleep(2000);
////            driver.findElement(By.xpath("//*[contains(text(), 'Lloyd')]")).click();
////            Thread.sleep(2000);
//            driver.findElement(By.name("create")).click();
//            Thread.sleep(5000);
//            System.out.println("END - CreateContactFromMenuTest");
//    }

    // @Test(priority = 2)
    // public void CreateCandidateFromMenu() throws InterruptedException {
    //      System.out.println("START - CreateCandidateFromMenu");
    //      // driver.navigate().to(testURL);
    //      WebElement findcreateCandidateButton = driver.findElement(By.xpath("//*[@id=\"dk-main-header-innerCt\"]/div/a[1]"));
    //      findcreateCandidateButton.click();

    //      WebElement findcreateCandidateMenuButton = driver.findElement(By.xpath(".//*[contains(text(),'Add Candidate')]"));
    //      findcreateCandidateMenuButton.click();
    //      driver.findElement(By.name("person__first_name")).sendKeys("Anand");
    //      driver.findElement(By.name("person__last_name")).sendKeys("Vyas");


    //      driver.findElement(By.xpath(".//*[contains(text(),'Job Title:')]/following::input[1]")).sendKeys("Java Developer");
    //      driver.findElement(By.name("create")).click();
    //      System.out.println("Candidate created successfully");
    //      System.out.println("END - CreateCandidateFromMenu");
    //      Thread.sleep(2000);

    // }

    @AfterClass
    public void teardownTest() {
            // Close browser and end the session
            driver.quit();
    }
}