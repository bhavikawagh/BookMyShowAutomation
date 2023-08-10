package com.academian.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateBookMyShowWebsite {
	
public static void main(String[] args) {
//Launch  ChromeBrowser
	System.setProperty("WebDriver.chrome.driver","D:\\SeleniumSoftware\\chromedriver-win32\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
//Open BookMyShow Website on ChromeBrowser
	driver.get("https://in.bookmyshow.com/explore/home/");
//Maximize window
	driver.manage().window().maximize();
//Select Bengaluru as the city
	WebElement selectBengaluru=driver.findElement(By.xpath("//span[text()='Bengaluru']"));
	selectBengaluru.click();
//Click on Sign In
	WebElement clickSign=driver.findElement(By.xpath("//div[text()='Sign in']"));
	clickSign.click();
//Click on Continue with Email	
	WebElement clickContinueWithEmail=driver.findElement(By.xpath("//div[contains(text(), 'Continue with Email')]"));
	clickContinueWithEmail.click();
//Enter email and click on Continue	
	WebElement enterEmail=driver.findElement(By.id("emailId"));
	enterEmail.sendKeys("selauto@yopmail.com");
	WebElement clickContinue=driver.findElement(By.xpath("//button[text()='Continue']"));
	clickContinue.click();
//Go to Yopmail.com	
	driver.get("https://yopmail.com/");
//Type email and access inbox	
	WebElement typeEmail=driver.findElement(By.id("login"));
	typeEmail.sendKeys("selauto@yopmail.com");
	WebElement inboxAccess=driver.findElement(By.xpath("//div[@id='refreshbut']//button//i"));
	inboxAccess.click();
//Locate the latest email and fetch OTP
    driver.switchTo().frame("ifmail");
    WebElement otpElement = driver.findElement(By.xpath("//div[@id='mail']//child::table//div//tbody//tr[4]//td//table//tr[2]//table//td"));
    String otp = otpElement.getText().split(" ")[0]; 
    System.out.println("OTP="+otp);
    driver.switchTo().defaultContent();
// Step 9: Go back to the Sign In page and enter OTP
    driver.get("https://in.bookmyshow.com/explore/home/");
// Enter OTP
    WebElement enterOtp = driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div/div[2]/form/div[1]/div[3]"));
    enterOtp.sendKeys(otp);  
// Validate successful sign-in
    WebElement accessGuestText = driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/header/div[1]/div/div/div/div[2]/div[2]/span"));
    if (accessGuestText .isDisplayed()) 
      {
        System.out.println("User successfully signed in.");
      } 
    else 
      {
        System.out.println("Sign-in validation failed.");
      }
    driver.quit();
   }	
}
