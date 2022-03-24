package com.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class log {
	ChromeDriver driver;
	FirefoxDriver driver1;
	@Parameters({"emailId","passWord","browser"})
	@Test
	public void login(String emailId,String passWord,String browser) {
		switch(browser) {
		case  "chrome":
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		break;
		case  "firefox":
			WebDriverManager.firefoxdriver().setup();
			 driver1=new FirefoxDriver();
		break;
		default:
			break;
		}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	driver.get("https://clin0021.review.cisiv.com");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	driver.findElement(By.id("c_user_name")).clear();
	driver.findElement(By.id("c_user_name")).sendKeys(emailId);
	driver.findElement(By.cssSelector("#c_user_psw")).clear();
	driver.findElement(By.cssSelector("#c_user_psw")).sendKeys(passWord);
	driver.findElement(By.cssSelector("#trans_btnSubmit")).click();
	}
}
