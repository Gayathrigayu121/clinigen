package com.clinigen.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


/**
 * To take screenshot of the Pass Case in all the methods
 */
public class CaptureShotp {

public static void Snapshot(WebDriver driver ,String screenshotName) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
		File des=new File("./ScreenShotsPassCase/"+screenshotName+".png");
			FileUtils.copyFile(src,des);
		} catch (IOException e) {
			e.getMessage();
		}
		
		
}

}
