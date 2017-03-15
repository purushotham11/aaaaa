package com.web.modules.DASHBOARD;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.FrameworkRU.PageAction;
import com.FrameworkRU.ReadObjectRepo;
import com.FrameworkRU.WaitForPage;

public class DashboardPage {
	
	
	 WebDriver driver;
	 Map<String, Map<String, String>> DashBoardPageOR_Map;
	 PageAction pageAction;
	private String dashBoardsLink="DashBoardsLink";
	private String createDashBoardsButton="CreateDashBoardsButton";
	private String dashBoardsNameField="DashBoardsNameField";
	private String dashBoardSourceDropDown="DashBoardSourceDropDown";
	private String dashBoardSourceOption="DashBoardSourceOption";
	private String saveDashBoard="SaveDashBoard";
	private String allWidgetsForDashBoard="AllWidgetsForDashBoard";

	public DashboardPage(WebDriver driver) throws IOException 
	{
		this.driver = driver;
		ReadObjectRepo loginORS = new ReadObjectRepo("PrimeO_OR");
		DashBoardPageOR_Map = loginORS.generateOR("DashBoardPage_OR");
		pageAction = new PageAction(driver);
		new WaitForPage(driver);
	}
	
	public void createDashBoard(String dashBoardName, String dashBoardWidgetsList)
			throws Exception 
	{
		clickOnDashBoardsLink();
		clickOnCreateDashBoardButton();
		enterDashBoardName(dashBoardName);
		selectDashBoardSource();
		selectDashBoardWidgetsVar(dashBoardWidgetsList); 
		//validateDashBoardWidgets(dashBoardWidgetsList);
		clickSaveBtn();		
	}
	private void clickOnDashBoardsLink() {
		// TODO Auto-generated method stub
		WebElement we = pageAction.getWebElement(DashBoardPageOR_Map, dashBoardsLink);
		we.click();
		WaitForPage.waitForPagetoLoad();
	}
	
	private void clickOnCreateDashBoardButton() {
		// TODO Auto-generated method stub
		WebElement we = pageAction.getWebElement(DashBoardPageOR_Map, createDashBoardsButton);
		we.click();
		WaitForPage.waitForPagetoLoad();
	}
	private void enterDashBoardName(String dashBoardName) throws Exception
	{
		
		WebElement we = pageAction.getWebElement(DashBoardPageOR_Map, dashBoardsNameField);
		WaitForPage.WaitForWebElement(we);
		we.clear();
		we.sendKeys(dashBoardName);
	}
	private void selectDashBoardSource() throws Exception
	{
		
		WebElement we = pageAction.getWebElement(DashBoardPageOR_Map, dashBoardSourceDropDown);
		WaitForPage.WaitForWebElement(we);
		we.click();
		WebElement we1 = pageAction.getWebElement(DashBoardPageOR_Map, dashBoardSourceOption);
		we1.click();
	}
	
	private void clickSaveBtn() {
		// TODO Auto-generated method stub
		WebElement we = pageAction.getWebElement(DashBoardPageOR_Map, saveDashBoard);
		we.click();
		WaitForPage.waitForPagetoLoad();
	}

	private void selectDashBoardWidgetsVar(String dashBoardWidgetsList) throws Exception {
	WebElement ele = null;
	String[] strList = null;
	//try{
	 List<WebElement> li = pageAction.getWebElements(DashBoardPageOR_Map, allWidgetsForDashBoard);
	 int TotlaWidgets = li.size();
	 System.out.println("intial widgets in list are -----> "+TotlaWidgets);
	 
	  strList = dashBoardWidgetsList.split(",");
	 int temp=1;
	 int count=TotlaWidgets;
	 
	 for(int i=temp;i<=count;i++)
	 {
	  for(int j=0;j<strList.length;j++)
	  {
	   //try {
	     ele=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div"));
	    
	    if(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText().trim().equalsIgnoreCase(strList[j]))
	       {
	      WebElement element = driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[3]/div"));
	     if(element.isDisplayed()){
//	     Actions action=new Actions(driver);
//	     action.moveToElement(element).build().perform();
	    	 System.out.println("Name of "+i+"th element is "+ele.getText().trim());
	     JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", element);
	     WaitForPage.WaitForWebElement(element);
	     Thread.sleep(3000);
	     element.click();
	     temp=i-1;
	        count=count-1;
	        System.out.println("after clicking on "+i+"th element total columns are "+count);
	     }else{
	      System.out.println("idiotttttttttttttttttttttttt");
	      
	     }
	       
	       }  
	   
	 }
	 }
	} 
	
	
}
