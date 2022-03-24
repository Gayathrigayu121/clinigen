package com.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDataProvider {

	@Test(dataProvider = "getData", dataProviderClass = LearnDataProad.class)
	public void logs(String data[]) {
		//System.out.println(data[0]);
		//System.out.println(data[1]);
		
		  WebDriverManager.chromedriver().setup(); ChromeDriver driver=new
		  ChromeDriver(); driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		  driver.get("https://clin0021.review.cisiv.com");
		 
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		  driver.findElement(By.id("c_user_name")).clear();
		  driver.findElement(By.id("c_user_name")).sendKeys(data[0]);
		  driver.findElement(By.cssSelector("#c_user_psw")).clear();
		  driver.findElement(By.cssSelector("#c_user_psw")).sendKeys(data[1]); 
		  driver.findElement(By.cssSelector("#trans_btnSubmit")).click();
		 
	}
}