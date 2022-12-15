package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker3 {
	
	public  WebDriver driver;
	public  JavascriptExecutor je;
	

	//02-May-2022;
	
			String expectedDay = "8";
			String expectedMonthYear = "July 2023";
	
	
	@BeforeMethod
	public void setup()
	{
		
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://www.goibibo.com/");
	
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void selectDate()
	{
		
		
		
		//find date picker webelement to perform click action
				
				WebElement datepicker = driver.findElement(By.xpath("//span[normalize-space()='Departure']"));
				datepicker.click();

				while(true)
				{
					String calenderMonthYear = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
					
				
					if(calenderMonthYear.equals(expectedMonthYear) )
					{
						List <WebElement> daysList = driver.findElements(By.xpath("//div[@class='DayPicker-Body']"));
						
						for(WebElement e:daysList)
						{
							String calenderDay = e.getText();
							if(calenderDay.equals(expectedDay))
							{
								e.click();
								break;
								
							}
						}
							
						break;
					}
					else
					{
						driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
					}
				}

			}
		
		
	
	

}
