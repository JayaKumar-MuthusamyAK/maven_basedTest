package com.commonsite.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon_Test

{
	public WebDriver dr = null;
	String Expect_Title= "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
	String User_Keywords="shirts for men";
	
	@Test
	public void Project_AddCartValidation()
	{
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		dr.get("https://www.amazon.com/ref=nav_logo");
		
		System.out.println("Title of the page :"+dr.getTitle());
		
		// Verity Title Using by assert class
		
		String Actual_Title= dr.getTitle();
		Assert.assertEquals(Actual_Title, Expect_Title);
		
		
		dr.findElement(By.className("redir-overlay-close")).click();
		
		dr.findElement(By.id("twotabsearchtextbox")).sendKeys("Shirt");
		
		//div[@id='suggestions-template']/suggestions
		List<WebElement> List_Of_Suggest = dr.findElements(By.xpath("//div[@id='suggestions-template']/div/div[@class='s-suggestion']"));
		/*for(int i=0; i<List_Of_Suggest.size();i++)
		{
			System.out.println(List_Of_Suggest.get(i).getText());
			
		}
		*/
		
		int i=0;
		while(i<List_Of_Suggest.size())
		{
			if(List_Of_Suggest.get(i).getText().equalsIgnoreCase(User_Keywords))
			{
				List_Of_Suggest.get(i).click();
				break;
			}
				i++;
		}
		
		System.out.println("Product Count"+dr.findElement(By.xpath("//*[@id='s-result-count']")).getText());
		
		
		String Project_Name1 = "Dream USA Men's Casual 3/4 Sleeve Baseball Tshirt Raglan Jersey Shirt";
		String Project_Name2 ="PAUL JONES Mens Long Sleeves Slim Fit Dress Shirts";
		List<WebElement>List_of_Project= dr.findElements(By.xpath(".//ul[@id='s-results-list-atf']/li/div/div[3]/div[1]/a"));
		for(int j=0; j<List_of_Project.size();j++)
		{
			System.out.println(List_of_Project.get(j).getText());
			
		}
		
		int check=0;
		
	    while(check<List_of_Project.size())
	    {
	    	if(List_of_Project.get(check).equals(Project_Name1))
	    	{
	    		List_of_Project.get(check).click();
	    		break;
	    	}
	    	check++;
	    }
	}
}
