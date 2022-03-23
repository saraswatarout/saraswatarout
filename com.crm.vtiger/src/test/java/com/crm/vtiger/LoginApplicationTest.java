package com.crm.vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginApplicationTest {
	@Test
	public void loginpage() {
		String browser=(System.getProperty("browser"));
		String url=(System.getProperty("url"));
		String username=(System.getProperty("username"));
		String password=(System.getProperty("password"));
		
		WebDriver driver = null;
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();	
			driver =new ChromeDriver();
			
		}else if (browser.equals("firefox")) {
       WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
	
		}else {

			System.out.println("specific browser lunched");
		}
     driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			WebElement logout= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 Actions act=new Actions(driver);
			 act.moveToElement(logout).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			 driver.close();
		
		
		
		
	}

}
