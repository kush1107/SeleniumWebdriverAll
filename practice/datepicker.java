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

public class datepicker{

	
	public  WebDriver driver;
	public  JavascriptExecutor je;
	
	
	@BeforeMethod
	public void setup()
	{
		
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://jqueryui.com/datepicker/");
	
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void selectDate()
	{
		
		
		
		
		//02-May-2022;
		
				String expectedDay = "8";
				String expectedMonth = "July";
				String expectedYear = "2023";
				
				//switch to iframe
				driver.switchTo().frame(0);
				
				//find date picker webelement to perform click action
				
				WebElement datepicker = driver.findElement(By.id("datepicker"));
				datepicker.click();

				while(true)
				{
					String calenderMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					String calenderYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				
					if(calenderMonth.equals(expectedMonth) && calenderYear.equals(expectedYear))
					{
						List <WebElement> daysList = driver.findElements(By.xpath("//table/tbody/tr/td"));
						
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
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
					}
				}

			}
		
		
		
	}
	

	
	


