package com.util;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ha {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		  WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(500));
		  driver.get("https://www.speedtest.net/");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Change Server')])[2]"))).click();
		  
		  
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".result-item.result-item-share")));
		  WebElement element = driver.findElement(By.xpath("//div[@class='input-button']/input"));
		  element.click();
		  List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='server-hosts-list']/ul/li"));
		
		  int size=findElements.size();
		 System.out.println(size);
		  for(int i=0;i<size;i++) {
			  
			  String text = findElements.get(i).getText();
			 
			  System.out.println(text);
		  
			  if(text.equals("Chennai Tata Play Fiber")) {
				 findElements.get(i).click();
				 
			  }	  
		  }
		  
		 driver.findElement(By.className("start-ring")).click();
		  
		  }
		  
		  
		  // element.sendKeys("Chennai");
		  
//		  Actions action = new Actions(driver);
//		  action.moveToElement(ele).perform();
		 /* TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			try {
			File des=new File("./ScreenShotsPassCase/ggh.png");
				FileUtils.copyFile(src,des);
			} catch (IOException e) {
				e.getMessage();
			}*/
		  

}