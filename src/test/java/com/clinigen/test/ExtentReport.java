package com.clinigen.test;
/*
 * package com.test.utils;
 * 
 * import org.testng.Assert; import org.testng.ITestResult; import
 * org.testng.annotations.AfterMethod; import org.testng.annotations.AfterTest;
 * import org.testng.annotations.BeforeTest; import org.testng.annotations.Test;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.Status; import
 * com.aventstack.extentreports.markuputils.ExtentColor; import
 * com.aventstack.extentreports.markuputils.MarkupHelper; import
 * com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 * 
 * 
 * 
 * public class ExtentReport { ExtentHtmlReporter reporter; ExtentReports
 * extent; ExtentTest createTest;
 * 
 * @BeforeTest
 * 
 * public void setup() {
 * 
 * reporter = new
 * ExtentHtmlReporter("C:\\Users\\admin\\eclipse-workspace\\Clinigen\\Execution Reports\\exte.html"
 * ); extent = new ExtentReports(); extent.attachReporter(reporter);}
 * 
 * @Test public void base() { createTest =
 * extent.createTest("saasdf","Login Test");
 * 
 * Assert.assertTrue(true);
 * 
 * }
 * 
 * @AfterMethod public void tearDown(ITestResult result) throws Exception {
 * 
 * if (ITestResult.FAILURE == result.getStatus()) {
 * createTest.log(Status.FAIL,MarkupHelper.createLabel(result.getName()
 * +" FAILED ", ExtentColor.RED)); } else if(ITestResult.SUCCESS ==
 * result.getStatus()) { createTest.log(Status.PASS,
 * MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN)); }
 * else { createTest.log(Status.SKIP,
 * MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
 * createTest.skip(result.getThrowable()); } }
 * 
 * @AfterTest public void tearDown() { //to write or update test information to
 * reporter extent.flush(); }}
 */