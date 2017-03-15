package com.web.tests.Views;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FrameworkRU.WaitForPage;

public class Code {
	/*List<WebElement> li = pageAction.getWebElements(viewsOR_Map, allSourceTableColumns);
	int TotlaColumns = li.size();
	System.out.println(TotlaColumns);
	
	String[] strList = ViewColumnsList.split(",");
	int temp=1;
	int count=TotlaColumns;
	
	
		for(int j=0;j<strList.length;j++)
		{
			for(int i=1;i<=count;i++)
			{
			//try {
				 //ele=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div"));
				
				if(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().trim().equalsIgnoreCase(strList[j]))
				   {
					 element=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[3]/div"));
					if(element.isDisplayed()){
					Actions action=new Actions(driver);
					action.moveToElement(element).build().perform();
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", element);
					WaitForPage.WaitForWebElement(element);
					Thread.sleep(3000);
					element.click();
					}else{
						System.out.println("idiotttttttttttttttttttttttt");
						
					}
				    temp=j;
				    //count=TotlaColumns;
				    System.out.println("after clicking on "+i+"th element total columns are"+TotlaColumns);
				   }  
			
	}
	}
	    WebElement ele1=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(TotlaColumns)+"]//tr/td[2]/div"));
		if(ele1.isDisplayed()){
		Coordinates coordinate=((Locatable)ele1).getCoordinates();
		coordinate.inViewPort();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele1);
		List<WebElement> li1 = pageAction.getWebElements(viewsOR_Map, allSourceTableColumns);
		int TotlaColumns1 = li1.size();
		int temp1=1;
		int count1=TotlaColumns1;
		System.out.println(TotlaColumns1);
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii purush");
			for(int j=0;j<strList.length;j++)
			{
				for(int i=1;i<=count1;i++)
				{
				//try {
					 //ele=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div"));
					
					if(strList[j].equalsIgnoreCase(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().trim()))
					   {
						System.out.println("helloooooooooooooooooooooooooooPurush");
						WebElement element=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[3]/div"));
						if(element.isDisplayed()){
						Actions action=new Actions(driver);
						action.moveToElement(element).build().perform();
						JavascriptExecutor executor1 = (JavascriptExecutor)driver;
						executor1.executeScript("arguments[0].click();", element);
						WaitForPage.WaitForWebElement(element);
						Thread.sleep(2000);
						WebDriverWait wait = new WebDriverWait(driver, 10);
						//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[3]/div")));
						element.click();
						}else{
							System.out.println("idiotttttttttttttttttttttttt");
							
						}
					    temp1=j;
					    //count1=TotlaColumns1;
					    System.out.println("after clicking on "+i+"th element total columns are"+TotlaColumns);
					   }
		
	}
	}
}*/
//Bill Code,PO Number,Address City,Call ID,Travel Rate---coming
}
