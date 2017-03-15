package com.web.modules.Views;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FrameworkRU.PageAction;
import com.FrameworkRU.ReadObjectRepo;
import com.FrameworkRU.WaitForPage;


public class ViewsPage {
	
	Map<String, Map<String, String>> viewsOR_Map;
	WebDriver driver;
	Actions action;
	PageAction pageAction;
	WebElement ele,element;
	private String viewsLink = "ViewsLink";
	private String createViewButton = "CreateViewButton";
	private String viewsNameField = "ViewsNameField";
	private String viewsSourceDropDown = "SelectSourceDropDown";
	private String viewsSourceOption = "SelectSourceOption";
	private String viewsSourceTable = "SelectSourceTable";
	private String saveView = "SaveButton";
	private String allSourceTableColumns= "AllSourceTableColumns";
	private String allSourceTableColumns1= "AllSourceTableColumns1";
	private String allSourceTables= "AllSourceTables";
	
	public ViewsPage(WebDriver driver) throws IOException 
	{
		this.driver = driver;
		ReadObjectRepo loginORS = new ReadObjectRepo("PrimeO_OR");
		viewsOR_Map = loginORS.generateOR("ViewsPage_OR");
		pageAction = new PageAction(driver);
		new WaitForPage(driver);
	}
	
	public void createView(String viewName,String viewSourceName, String ViewColumnsList)
			throws Exception 
	{
		clickOnViewsLink();
		clickOnCreateViewButton();
		enterViewName(viewName);
		selectViewSource();
		selectViewSourceTableVar(viewSourceName);
		
		//selectViewSourceTable();
		selectTableColumnsVar21(ViewColumnsList);
		//selectTableColumns();   // as of now hard coded to select top 2 columns of the ViewTable
		//selectTableColumnsVar(ViewColumnsList,"Address City"); 
		//selectTableColumnsVar(ViewColumnsList,"Work Order Number");  
		//selectTableColumnsVar(ViewColumnsList,"Status");  
		//selectTableColumnsVar(ViewColumnsList,"Item"); 
		clickSaveBtn();		
	}

	private void clickOnViewsLink() {
		// TODO Auto-generated method stub
		WebElement we = pageAction.getWebElement(viewsOR_Map, viewsLink);

		WaitForPage.waitForPagetoLoad();
		we.click();
	}
	
	private void clickOnCreateViewButton() {
		// TODO Auto-generated method stub
		WebElement we = pageAction.getWebElement(viewsOR_Map, createViewButton);
		we.click();
		WaitForPage.waitForPagetoLoad();
	}


	private void enterViewName(String viewName) throws Exception
	{
		
		WebElement we = pageAction.getWebElement(viewsOR_Map, viewsNameField);
		WaitForPage.WaitForWebElement(we);
		we.clear();
		we.sendKeys(viewName);
	}
	
	private void selectViewSource() throws Exception
	{
		
		WebElement we = pageAction.getWebElement(viewsOR_Map, viewsSourceDropDown);
		WaitForPage.WaitForWebElement(we);
		we.click();
		WebElement we1 = pageAction.getWebElement(viewsOR_Map, viewsSourceOption);
		WaitForPage.WaitForWebElement(we);
		Thread.sleep(2000);
		we1.click();
	}
	
	private void selectViewSourceTable() throws Exception
	{
		
		WebElement we = pageAction.getWebElement(viewsOR_Map, viewsSourceTable);
		we.click();
		driver.findElement(By.xpath("//ul[@id='boundlist-1223-listEl']/li[1]")).click();
		WaitForPage.waitForPagetoLoad();
		//driver.findElement(By.xpath("//ul[@class='x-list-plain']/li[2]")).click();
		
	}
	
	private void selectViewSourceTableVar(String viewSourceName) throws Exception
	{
		WebElement we = pageAction.getWebElement(viewsOR_Map, viewsSourceTable);
		we.click();
		System.out.println("Input source table is "+viewSourceName);
		List<WebElement> li = pageAction.getWebElements(viewsOR_Map, allSourceTables);
		int TotlaSourceTable = li.size();
		System.out.println("total source tables are "+ TotlaSourceTable);
		
		for(int i=0;i<TotlaSourceTable;i++)
		{
			//if(li.get(i).isDisplayed())
			//{
			System.out.println("Current Source name of "+i+" is "+ li.get(i).getText().trim());
			
			if(li.get(i).getText().trim().equalsIgnoreCase(viewSourceName))
			{
				
				/*System.out.println(li.get(i).getText().trim()+" is equals with "+viewSourceName);
				for(int j=i;j<=TotlaSourceTable;j++){
				WebElement we_table=driver.findElement(By.xpath("//ul[@class='x-list-plain']/li["+(j)+"]"));
				if(we_table.isDisplayed()){
				//driver.findElement(By.xpath("//ul[@class='x-list-plain']/li["+(i-1)+"]")).click();
					we_table.click();
			}
			}*/
				
				li.get(i).click();
				
		}
			}
	}
	
	private void clickSaveBtn() {
		// TODO Auto-generated method stub
		WebElement we = pageAction.getWebElement(viewsOR_Map, saveView);
		we.click();
		WaitForPage.waitForPagetoLoad();
	}
	
	private void selectTableColumns() {
		
		driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table[1]//td[3]")).click();
		driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table[2]//td[3]")).click();
		
	}
	
private void selectTableColumnsVar1(String ViewColumnsList) throws Exception {
	
	List<WebElement> li = pageAction.getWebElements(viewsOR_Map, allSourceTableColumns);
	int TotlaColumns = li.size();
	System.out.println(TotlaColumns);
	
	String[] strList = ViewColumnsList.split(",");
	int temp=1;
	int count=TotlaColumns;
	
	
		
			for(int i=1;i<=count;i++)
			{
				for(int j=0;j<strList.length;j++)
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
					//executor.executeScript("arguments[0].scrollIntoView(true);",element);
					WaitForPage.WaitForWebElement(element);
					Thread.sleep(3000);
					element.click();
					}else{
						System.out.println("idiotttttttttttttttttttttttt");
						
					}
				    temp=j;
				    count=TotlaColumns-1;
				    System.out.println("after clicking on "+i+"th element total columns are"+TotlaColumns);
				   }  
			
	}
	}
	    WebElement ele1=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(TotlaColumns-1)+"]//tr/td[2]/div"));
		
		Coordinates coordinate=((Locatable)ele1).getCoordinates();
		coordinate.inViewPort();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele1);
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		List<WebElement> li1 = pageAction.getWebElements(viewsOR_Map, allSourceTableColumns);
		int TotlaColumns1 = li1.size();
		int temp1=1;
		int count1=TotlaColumns1;
		System.out.println(TotlaColumns1);
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii purush");
			
				for(int i=1;i<=count1;i++)
				{
					for(int j=0;j<strList.length;j++)
					{
				
				
					 //ele=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div"));
					
					if(strList[j].equalsIgnoreCase(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().trim()))
					   {
						//System.out.println("helloooooooooooooooooooooooooooPurush");
						  WebElement source=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div"));
						//WebElement element=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[3]/div"));*/
						if(source.isDisplayed()){
							JavascriptExecutor executor1 = (JavascriptExecutor)driver;
							executor1.executeScript("arguments[0].scrollIntoView(true);",source);
							Actions action=new Actions(driver);
							action.moveToElement(source).build().perform();
							
							executor1.executeScript("arguments[0].click();", source);
							executor1.executeScript("arguments[0].scrollIntoView(true);",source);
						WebElement we=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[3]/div"));
						System.out.println(source.getText());
						System.out.println("hey hi"+i);
						Actions action1=new Actions(driver);
						action1.moveToElement(source).build().perform();
					    Thread.sleep(10000);
						WebElement dest=driver.findElement(By.id("CreateQueryDropDownPanelId-innerCt"));
						action1.dragAndDrop(source, dest).build().perform();
						//WaitForPage.WaitForWebElement(element);
						Thread.sleep(2000);
						/*WebDriverWait wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[3]/div")));
						element.click();*/
						}else{
							System.out.println("idiotttttttttttttttttttttttt");
							
						}
					    temp1=j;
					    count1=TotlaColumns1-1;
					    System.out.println("after clicking on "+i+"th element total columns are"+TotlaColumns);
					   }
				

					
					   }
					//i=1;	
				/*if(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().equalsIgnoreCase("Work Order Number")){
				WebElement source=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div"));
				WebElement we=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[3]/div"));
				System.out.println(source.getText());
				System.out.println("hey hi"+i);
				Actions action=new Actions(driver);
				action.moveToElement(source).build().perform();
			    Thread.sleep(3000);
				WebElement dest=driver.findElement(By.id("CreateQueryDropDownPanelId-innerCt"));
				action.dragAndDrop(source, dest).build().perform();*/
				
	}
				
	}

private void selectTableColumnsVar21(String ViewColumnsList) throws Exception {
	   
	   List<WebElement> li = pageAction.getWebElements(viewsOR_Map, allSourceTableColumns);
	   int TotlaColumns = li.size();
	   System.out.println("Total columns identified are ----"+TotlaColumns);
	   
	   String[] strList = ViewColumnsList.split(",");
	   //int temp=1;
	   int count=TotlaColumns;
	   int i,j;
	   try{
	   for( i=1;i<=count;i++){
	    System.out.println("Count is "+count+" and Value of i "+i+" is --"+ driver.findElement(By.xpath("//table/div[@data-recordindex=i]/tr/td[2]/div")).getText().trim());
	         for( j=0;j<strList.length;j++){
	          System.out.println("Value of j is "+strList[j]);
	           if(driver.findElement(By.xpath("//table/div[@data-recordindex='1']/tr/td[2]/div")).getText().trim().equalsIgnoreCase(strList[j]))
	           {
	            WebElement source=driver.findElement(By.xpath("//table/div[@data-recordindex='1']/tr/td[2]/div"));
	    System.out.println(source.getText());
	    System.out.println("hey hi --"+i+ " value is equal with "+strList[j]  );
	     action=new Actions(driver);
	    action.moveToElement(source).build().perform();
	       Thread.sleep(3000);
	    WebElement dest=driver.findElement(By.id("CreateQueryDropDownPanelId-innerCt"));
	    action.dragAndDrop(source, dest).build().perform();
	              i=i-1;
	              count=count-1;
	  }
	   }
	  }
	   }
	   
	   catch(Exception e)
	   {
	    System.out.println("Scrolling down .............");
 WebElement ele1=driver.findElement(By.xpath("//table/div[@data-recordindex="+48+"]/tr/td[2]/div"));
		
		Coordinates coordinate=((Locatable)ele1).getCoordinates();
		coordinate.inViewPort();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele1);
	     /*JavascriptExecutor jse = (JavascriptExecutor)driver;
	         jse.executeScript("window.scrollBy(0,-250)", "");*/
	         
	         
	         List<WebElement> li1 = pageAction.getWebElements(viewsOR_Map, allSourceTableColumns);
	     int TotlaColumns1 = li1.size();
	     System.out.println("Total columns identified are ----"+TotlaColumns1);
	     
	     int count1=TotlaColumns1;
	     
	     for( i=1;i<=count1;i++){
	      System.out.println("Count is "+count1+" and Value of i "+i+" is --"+ driver.findElement(By.xpath("//table/div[@data-recordindex="+i+"]/tr/td[2]/div")).getText().trim());
	           for( j=0;j<strList.length;j++){
	            System.out.println("Value of j is "+strList[j]);
	            if(driver.findElement(By.xpath("//table/div[@data-recordindex="+i+"]/tr/td[2]/div")).isDisplayed()){
	             if(driver.findElement(By.xpath("//table/div[@data-recordindex="+i+"]/tr/td[2]/div")).getText().trim().equalsIgnoreCase(strList[j]))
	             {
	              WebElement source=driver.findElement(By.xpath("//table/div[@data-recordindex="+i+"]/tr/td[2]/div"));
	      System.out.println(source.getText());
	      System.out.println("hey hi --"+i+ " value is equal with "+strList[j]  );
	       action=new Actions(driver);
	      action.moveToElement(source).build().perform();
	         Thread.sleep(3000);
	      WebElement dest=driver.findElement(By.id("CreateQueryDropDownPanelId-innerCt"));
	      action.dragAndDrop(source, dest).build().perform();
	                i=i-1;
	                count=count-1;
	                 /*if(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().trim().equalsIgnoreCase(strList[strList.length]));
	                 {
	                 throw new Exception("All input elements are selected for view");
	                 }*/
	             }
	              
	    }else
	     System.out.println("Element is not *****************  ");
	     }
	   }
	 }
	 }

private void selectTableColumnsVar22(String ViewColumnsList) throws Exception {
	   
	   List<WebElement> li = pageAction.getWebElements(viewsOR_Map, allSourceTableColumns);
	   int TotlaColumns = li.size();
	   System.out.println("Total columns identified are ----"+TotlaColumns);
	   
	   String[] strList = ViewColumnsList.split(",");
	   //int temp=1;
	   int count=TotlaColumns;
	   int i,j;
	   try{
	   for( i=1;i<count;i++){
	    System.out.println("Count is "+count+" and Value of i "+i+" is --"+ driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().trim());
	         for( j=0;j<strList.length;j++){
	          System.out.println("Value of j is "+strList[j]);
	           if(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().trim().equalsIgnoreCase(strList[j]))
	           {
	            WebElement source=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div"));
	    System.out.println(source.getText());
	    System.out.println("hey hi --"+i+ " value is equal with "+strList[j]  );
	     action=new Actions(driver);
	    action.moveToElement(source).build().perform();
	       Thread.sleep(3000);
	    WebElement dest=driver.findElement(By.id("CreateQueryDropDownPanelId-innerCt"));
	    action.dragAndDrop(source, dest).build().perform();
	              i=i-1;
	              count=count-1;
	  }
	   }
	  }
	   }
	   
	   catch(Exception e)
	   {
	    System.out.println("Scrolling down .............");
	     JavascriptExecutor jse = (JavascriptExecutor)driver;
	         jse.executeScript("window.scrollBy(0,-250)", "");
	         
	         
	         List<WebElement> li1 = pageAction.getWebElements(viewsOR_Map, allSourceTableColumns);
	     int TotlaColumns1 = li1.size();
	     System.out.println("Total columns identified are ----"+TotlaColumns1);
	     
	     int count1=TotlaColumns1;
	     
	     for( i=1;i<count1;i++){
	      System.out.println("Count is "+count1+" and Value of i "+i+" is --"+ driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().trim());
	           for( j=0;j<strList.length;j++){
	            System.out.println("Value of j is "+strList[j]);
	            if(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).isDisplayed()){
	             if(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().trim().equalsIgnoreCase(strList[j]))
	             {
	              WebElement source=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div"));
	      System.out.println(source.getText());
	      System.out.println("hey hi --"+i+ " value is equal with "+strList[j]  );
	       action=new Actions(driver);
	      action.moveToElement(source).build().perform();
	         Thread.sleep(3000);
	      WebElement dest=driver.findElement(By.id("CreateQueryDropDownPanelId-innerCt"));
	      action.dragAndDrop(source, dest).build().perform();
	                i=i-1;
	                count=count-1;
	                 /*if(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().trim().equalsIgnoreCase(strList[strList.length]));
	                 {
	                 throw new Exception("All input elements are selected for view");
	                 }*/
	             }
	              
	    }else
	     System.out.println("Element is not *****************  ");
	     }
	   }
	 }
	 }
}

		
		
		

		



	


	  




