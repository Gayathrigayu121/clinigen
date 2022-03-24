package com.clinigen.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


/**
 * To take the screenshot of the Failure Case in all the methods
 */

public class CaptureShotf {
public static void Snapshot(WebDriver driver ,String screenshotName) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
		File des=new File("./ScreenShotsFailCase/"+screenshotName+".png");
			FileUtils.copyFile(src,des);
		} catch (IOException e) {
			e.getMessage();
		}
		
		
}
}
