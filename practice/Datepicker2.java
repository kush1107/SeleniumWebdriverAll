package com.practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Datepicker2 {

	public  WebDriver driver;
	public  JavascriptExecutor je;
	
	//08-July-2022;

	String expectedDay = "8";
	String expectedMonthYear = "July 2023";

	
	
	
	@BeforeMethod
	public void setup()
	{
		
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://www.redbus.in/");
	
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void selectDate()
	{
		
		
		
		
		

				WebElement datepicker = driver.findElement(By.id("onward_cal"));
				datepicker.click();

				while(true)
				{
					String calenderMonthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();

					if(calenderMonthYear.equals(expectedMonthYear))
					{
						driver.findElement(By.xpath("//td[text()='" + expectedDay+ "']")).click();

						break;
					}
					else
					{
						driver.findElement(By.xpath("//td[@class='next']")).click();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
}
