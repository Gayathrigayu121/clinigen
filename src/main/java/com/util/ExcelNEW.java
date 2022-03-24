package com.util;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ExcelNEW {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://clin0021.review.cisiv.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.id("c_user_name")).clear();
		driver.findElement(By.id("c_user_name")).sendKeys("clin0021physician@mailinator.com");
		driver.findElement(By.cssSelector("#c_user_psw")).clear();
		driver.findElement(By.cssSelector("#c_user_psw")).sendKeys("Testing_123");
		driver.findElement(By.cssSelector("#trans_btnSubmit")).click();
		
		List<WebElement> findElements = driver.findElements(By.cssSelector(".VueTables__row "));
		List<String> text = new ArrayList<String>();
		int patientSize = findElements.size();
		
		for (int i = 0; i < patientSize; i++) {
			text.add(findElements.get(i).getText());
		}

		findElements.get(patientSize - 1).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.list-group>li:nth-of-type(4)>div.handle-pointer>div>span.actionTitle"))).click(); 
		
		
		
		List<WebElement> findElements2 = driver.findElements(By.id("pageWrapper"));
		for (WebElement brands:findElements2)
		{
			System.out.println("the Brand names are :"+brands.getText());
		}
		//System.out.println("sdfagfd"+text3);
	}}
/*		
		File src = new File("./Excel/Book.xlsx");
		FileInputStream loadFile = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(loadFile);
		XSSFSheet sh = wb.getSheet("DEMOGRAPHY");
		int lastRowNum = sh.getLastRowNum();
		short lastCellNum = sh.getRow(lastRowNum).getLastCellNum();
		String f= {"ds","sdz"};
		
		
		
		sh.getRow(1).getCell(2).getStringCellValue();
		Sting txt"wdasd";
		
		If(text.equals(loadFile));
		
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("dfs");
		
		for (int i = 7; i <= lastRowNum; i++)
		{
			String stringCellValue = sh.getRow(i).getCell(2).getStringCellValue();
			//System.out.println(stringCellValue);
			if(list.contains(stringCellValue))
			{
				
			sh.createRow(i).createCell(18).setCellValue(stringCellValue);
          }
		}
		
		
	
	}
	}*/
