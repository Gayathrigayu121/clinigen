package com.clinigen.test;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ReadExcel extends Base {

/**
 * To verify Registration page of the Design Specification 
 * Collect the Registration page labels using the getText() method, and 
 * then use the for loop to collect data from the ExcelSheet 
 * compare and validate the both set of data
 * @throws Exception
 */
	@Test
	public static void getExcelData() throws Exception
	{
		String str1 = driver.findElement(By.cssSelector(".page-form > div:nth-of-type(1) .label-element")).getText();
		String str2 = driver.findElement(By.cssSelector(".page-form > div:nth-of-type(2) .label-element")).getText();
		String str3 = driver.findElement(By.cssSelector("div:nth-of-type(3) .label-element")).getText();
		System.out.println(str3);

		String s = String.join("," , str1, str2, str3);
		try
		{
			File src = new File("E:\\New folder\\Book.xlsx");
			FileInputStream loadfile = new FileInputStream(src);
			ReadExcel obj = new ReadExcel();

			XSSFWorkbook wb = new XSSFWorkbook(loadfile);

			XSSFSheet sh1 = wb.getSheet("Regtestdata");
			int rowCount = sh1.getLastRowNum();

			String[] arrOfStr = s.split(",");

			for (int i = 0; i <=rowCount; i++) {
				for (int j = 0; j < 1; j++) {
					String stringCellValue = sh1.getRow(i).getCell(j).getStringCellValue();
					for (String a : arrOfStr)
						if (stringCellValue.equalsIgnoreCase(a)) {
							System.out.println("label is same : " + stringCellValue + " = " + a);
						}
				}
			}
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());

		}
		driver.findElement(By.cssSelector("#btnprevious")).click();
	driver.findElement(By.cssSelector("button[class='button-primary'][test-id='test_mpdb_btn_confirm']")).click();
	}
}