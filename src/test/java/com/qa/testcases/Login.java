package com.qa.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.testbase.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Login extends Testbase{
ExtentReports ex;
ExtentTest test;
public  Login() throws Throwable
{
super();
}
@BeforeMethod
@Parameters("browser")
public void browser(String browser)
{
ex=new ExtentReports("./report/login.html",true);
test = ex.startTest("Login Testcase");
openBrowser(browser);
URL(config.getProperty("URL"));
}
@Test
public void LogInTestcase() throws Exception
{
sendkeys(Driver,org.getProperty("username"),config.getProperty("USERNAME"));
Reporter.log("Enter username",true);
test.log(LogStatus.INFO, "Enter username");
sendkeys(Driver,org.getProperty("password"),config.getProperty("PASSWORD"));
Reporter.log("Enter password",true);
test.log(LogStatus.INFO, "Enter password");
Thread.sleep(3000);
click(Driver,org.getProperty("login"));
test.log(LogStatus.INFO, "click on login");
Thread.sleep(3000);
ex.endTest(test);
ex.flush();
screenshot("Login Screenshot");
Driver.quit();
}
}
