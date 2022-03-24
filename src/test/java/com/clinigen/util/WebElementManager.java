package com.clinigen.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clinigen.test.ExcelColName;


public class WebElementManager {
	static ExcelColName obj = new ExcelColName("./Excel/Book.xlsx");
	public static int getRandomInteger(int maximum, int minimum) {
		return ((int) (Math.random() * (maximum - minimum))) + minimum;
	}
	

	public List<String> getElementByXpath(WebDriver driver,String search){
		
		List<WebElement> element = driver.findElements(By.xpath(search));
        List<String> stringList=new ArrayList<String>();
		for(WebElement copyElement:element) {
			stringList.add(copyElement.getText().trim());
			
		}
		return  stringList;
		
	}
	
	
	
public List<String> getElementByCss(WebDriver driver,String search){
		
		List<WebElement> element = driver.findElements(By.cssSelector(search));
        List<String> stringList=new ArrayList<String>();
		for(WebElement copyElement:element) {
			stringList.add(copyElement.getText().trim());
			
		}
		return  stringList;
		
	}
		
		public List<String> getElementBycss(WebDriver driver,String search){
			
			List<WebElement> element = driver.findElements(By.cssSelector(search));
	        List<String> stringList=new ArrayList<String>();
			for(WebElement copyElement:element) {
				stringList.add(copyElement.getText().trim());
			}
			return  stringList;
	}
	
		
		
		public List<String> clickRandomOption(WebDriver driver ,String xpathSearch,String clickableSearch,int maximum,int minimum) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(clickableSearch))).click();
		int randomIntValue=((int) (Math.random() * (maximum - minimum))) + minimum;
		List<WebElement> list2 = driver.findElements(By.xpath(xpathSearch));
		List<String> addL=new ArrayList<String>();
		for(WebElement copyElement:list2) {
			addL.add(copyElement.getText().trim());
		}
		 String text = list2.get(randomIntValue).getText();
		 
        list2.get(randomIntValue).click();
        return addL;
		}
	
		
		public List<String> clickRandomOptionjs(WebDriver driver ,String cssCaptureText,String clickableSearch,int maximum,int minimum) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(clickableSearch))).click();
			int randomIntValue=((int) (Math.random() * (maximum - minimum))) + minimum;
			List<WebElement> list2 = driver.findElements(By.cssSelector(cssCaptureText));
			List<String> addL=new ArrayList<String>();
			for(WebElement copyElement:list2) {
				addL.add(copyElement.getText().trim());
			}
			System.out.println(addL.size());
	        list2.get(randomIntValue).click();
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", list2.get(randomIntValue));
	        return addL;
			}
		
		
		
		
		
		
		
		
		
		
		
		
		public List<String> clickRandomOptionjswoClick(WebDriver driver ,String cssCaptureText,String clickableSearch) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(clickableSearch))).click();
			List<WebElement> list2 = driver.findElements(By.cssSelector(cssCaptureText));
			List<String> addL=new ArrayList<String>();
			for(WebElement copyElement:list2) {
				addL.add(copyElement.getText().trim());
			}
	        return addL;
			}
		
		
		
		
		public String clickRamdomOptionxpathText(WebDriver driver, String xpathSearch,int maximum,int minimum) {
			
		int randomIntValue=((int) (Math.random() * (maximum - minimum))) + minimum;
		List<WebElement> listofElements = driver.findElements(By.xpath(xpathSearch));
		listofElements.get(randomIntValue).click();
		String text = listofElements.get(randomIntValue).getText().trim();
		return text;
		}
		 
		public String clickRamdomOptioncssText(WebDriver driver, String cssSearch,int maximum,int minimum) {
			
			int randomIntValue=((int) (Math.random() * (maximum - minimum))) + minimum;
			List<WebElement> listofElements = driver.findElements(By.cssSelector(cssSearch));
			listofElements.get(randomIntValue).click();
			String text = listofElements.get(randomIntValue).getText().trim();
			return text;
			}
		
		
		
public String clickRamdomOptioncssTextnw(WebDriver driver, String clickCss,String cssSearch,int maximum,int minimum) {
			
			int randomIntValue=((int) (Math.random() * (maximum - minimum))) + minimum;
			driver.findElement(By.cssSelector(clickCss)).click();
			List<WebElement> listofElements = driver.findElements(By.cssSelector(cssSearch));
			listofElements.get(randomIntValue).click();
			String text = listofElements.get(randomIntValue).getText().trim();
			return text;
			}
		
			 
		
		public void waitWebDriver(WebDriver driver,String cssclickableSearch) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssclickableSearch))).click();
		
		}
		
		
		public  void dateOfBaseline(WebDriver driver,String cssclickableSearch,String cssHeader,String month,String year,String cssPreviousMonth,String dateXpath) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssclickableSearch))).click();
		
		String text2 = driver.findElement(By.cssSelector(cssHeader)).getText();
		String str = text2.substring(7);
		String month1 = str.split(" ")[0].trim();
		String year1 = str.split(" ")[1].trim();
		while (!(month1.equals(month) && year1.equals(year))) {
			WebElement element = driver.findElement(By.cssSelector(cssPreviousMonth));
			element.click();
			text2 = driver.findElement(By.cssSelector(cssHeader)).getText().trim();
			str = text2.substring(7);
			month1 = str.split(" ")[0].trim();
			year1 = str.split(" ")[1].trim();

		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXpath))).click();
			
		
		
		}
		
		
public  void dateOfBaselineafterMonth(WebDriver driver,String cssclickableSearch,String cssHeader,String month,String year,String cssNextsMonth,String dateXpath,String mouseHoverXpath) {
	WebElement ele1=	driver.findElement(By.xpath(mouseHoverXpath));
	Actions action = new Actions(driver);
	action.moveToElement(ele1).perform();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			WebElement ele =driver.findElement(By.cssSelector(cssclickableSearch));
			JavascriptExecutor js = (JavascriptExecutor)driver;
		        js.executeScript("arguments[0].click();", ele );
		
		String text2 = driver.findElement(By.cssSelector(cssHeader))
				.getText();
		String str = text2.substring(7);
		String month1 = str.split(" ")[0].trim();
		String year1 = str.split(" ")[1].trim();
		while (!(month1.equals(month) && year1.equals(year))) {
			
			WebElement element = driver.findElement(By.cssSelector(cssNextsMonth));
               JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("arguments[0].click();", element);
			element.click();
			text2 = driver.findElement(By.cssSelector(cssHeader)).getText().trim();
			str = text2.substring(7);
			month1 = str.split(" ")[0].trim();
			year1 = str.split(" ")[1].trim();

		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXpath))).click();
			
		
		
		}

public String captureQueryTextxpath(WebDriver driver,String hoverXpath,String queryTextCaptureCssSel
		,String SheetName,int rowNum,String getcolName,int getrowNumNext,
		String setcolName,String setvalue,int setrowNumNext,String anotherHoverXpathCapEnd) throws Exception {
	
WebElement hoverElement = driver.findElement(By.xpath(hoverXpath));
Actions action = new Actions(driver);
action.moveToElement(hoverElement).perform();
WebElement queryElement = driver.findElement(By.cssSelector(queryTextCaptureCssSel));
action.moveToElement(queryElement).perform();
String captureText = queryElement.getText().trim();
String xlText=obj.getCellData(SheetName, rowNum, getcolName, getrowNumNext);
String con=String.join(":", xlText,captureText);
obj.setCellData(SheetName, rowNum, setcolName, setvalue, setrowNumNext);
WebElement eles = driver.findElement(By.xpath(anotherHoverXpathCapEnd));
action.moveToElement(eles).perform();
return con;
}




public String captureQueryTextcss(WebDriver driver,String hoverCss,String queryTextCaptureCssSel
		,String SheetName,int rowNum,String getcolName,int getrowNumNext,
		String setcolName,String setvalue,int setrowNumNext,String anotherHoverXpathCapEnd) throws Exception {
	
WebElement hoverElement = driver.findElement(By.cssSelector(hoverCss));
Actions action = new Actions(driver);
action.moveToElement(hoverElement).perform();
WebElement queryElement = driver.findElement(By.cssSelector(queryTextCaptureCssSel));
action.moveToElement(queryElement).perform();
String captureText = queryElement.getText().trim();
String xlText=obj.getCellData(SheetName, rowNum, getcolName, getrowNumNext);
String con=String.join(":", xlText,captureText);
obj.setCellData(SheetName, rowNum, setcolName, setvalue, setrowNumNext);
WebElement eles = driver.findElement(By.xpath(anotherHoverXpathCapEnd));
action.moveToElement(eles).perform();
return con;
}


public String sendKeyInputcaptureQueryTextcss(WebDriver driver,String cssInputClick,String sendKeyInputWrong,String SendKeyCorrect,String hoverCss,String queryTextCaptureCssSel
		,String SheetName,int rowNum,String getcolName,int getrowNumNext,
		String setcolName,String setvalue,int setrowNumNext,String anotherClickCssEnd) throws Exception {
	
driver.findElement(By.cssSelector(cssInputClick)).sendKeys(Keys.chord(Keys.CONTROL, "a"),sendKeyInputWrong);
driver.findElement(By.cssSelector(anotherClickCssEnd)).click();
WebElement hoverElement = driver.findElement(By.cssSelector(hoverCss));
Actions action = new Actions(driver);
action.moveToElement(hoverElement).perform();
WebElement queryElement = driver.findElement(By.cssSelector(queryTextCaptureCssSel));
action.moveToElement(queryElement).perform();
String captureText = queryElement.getText().trim();
String xlText=obj.getCellData(SheetName, rowNum, getcolName, getrowNumNext);
String con=String.join(":", xlText,captureText);
obj.setCellData(SheetName, rowNum, setcolName, setvalue, setrowNumNext);
driver.findElement(By.cssSelector(cssInputClick)).sendKeys(Keys.chord(Keys.CONTROL, "a"),SendKeyCorrect);
driver.findElement(By.cssSelector(anotherClickCssEnd)).click();
return con;
}


public String LabQueryText(WebDriver driver,String captureHoverCss,String queryTextCaptureCss,String SheetName,int rowNum,String getcolName,int getrowNumNext,
		String setcolName,String setvalue,int setrowNumNext,String sendKeyInputCss,String CorrectValueInput,
		String endHoverCss) throws Exception {
WebElement ele1=driver.findElement(By.cssSelector(captureHoverCss));
Actions action = new Actions(driver);
action.moveToElement(ele1).perform();
WebElement queryElement = driver.findElement(By.cssSelector(queryTextCaptureCss));
action.moveToElement(queryElement).perform();
String captureText = queryElement.getText().trim();
String xlText=obj.getCellData(SheetName, rowNum, getcolName, getrowNumNext);
String con=String.join(":", xlText,captureText);
obj.setCellData(SheetName, rowNum, setcolName, setvalue, setrowNumNext);

driver.findElement(By.cssSelector(sendKeyInputCss)).sendKeys(Keys.chord(Keys.CONTROL, "a"),CorrectValueInput);

WebElement queryElement1 = driver.findElement(By.cssSelector(endHoverCss));
action.moveToElement(queryElement1).perform();
queryElement1.click();
return con;
}



}

