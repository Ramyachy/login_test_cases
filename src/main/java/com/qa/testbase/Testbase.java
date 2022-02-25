package com.qa.testbase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Testbase {
public static WebDriver Driver;
public static Properties config = new Properties();
public static Properties org=new Properties();
public static FileInputStream fis_config,fis_org;
public Testbase() throws Throwable{
try {
fis_config = new FileInputStream ("./resource/config.properties");
config.load(fis_config);
fis_org = new FileInputStream("./resource/org.properties");
org.load(fis_org);
}catch(IOException e) {
e.printStackTrace();
}
}
public void openBrowser(String browser)
{
if(browser.equals("chrome")) {
//System.setProperty("webdriver.chrome.driver","C:\\Users\\bharat\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
WebDriverManager.chromedriver().setup();
Driver = new ChromeDriver();
}
else if(browser.equals("firefox")) {
//System.setProperty("webdriver.chrome.driver","C:\\Users\\bharat\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
WebDriverManager.firefoxdriver().setup();
Driver = new FirefoxDriver();
}
Driver.manage().window().maximize();
Driver.manage().deleteAllCookies();
Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
public void URL(String url)
{
try {
Driver.get(url);
}catch(Exception e) {
e.printStackTrace();
}
}
public void sendkeys(WebDriver Driver,String xpath,String testdata)
{
try {
Driver.findElement(By.xpath(xpath)).sendKeys(testdata);
}catch(Exception e) {
e.printStackTrace();
}
}
public void click(WebDriver Driver,String xpath)
{
try {
Driver.findElement(By.xpath(xpath)).click();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
public void screenshot(String filename) throws IOException 
{
File src=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("./screenshots/" + filename + ".png"));
}

public void explicitwait (WebDriver Driver,String xpath)
{
	WebDriverWait wait=new WebDriverWait(Driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
	Driver.findElement(By.xpath("")).click();

}
}




