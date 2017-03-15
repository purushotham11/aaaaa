package com.web.modules.Widget;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.FrameworkRU.PageAction;
import com.FrameworkRU.ReadObjectRepo;
import com.FrameworkRU.WaitForPage;

public class WidgetsPage {
 Map<String, Map<String, String>> WidgetsOR_Map;
 WebDriver driver;
 Actions action;
 PageAction pageAction;
 WebElement ele,element;
 private String widgetsLink = "WidgetsLink";
 private String createWidgetButton = "CreateWidgetButton";
 private String widgetsNameField = "WidgetsNameField";
 private String widgetsDescriptionField = "WidgetsDescriptionField";
 private String widgetsSourceDropDown = "WidgetsSourceDropDown";
 private String widgetsSourceOption = "WidgetsSourceOption";
 private String viewNameForSearch="ViewNameForSearch";
 private String allViewColumnsForWidget="AllViewColumnsForWidget";
 private String saveWidget = "SaveWidget";
 private String loadViewDataToWidget="LoadViewDataToWidget";
 
 

 private String cancelWidget = "WidgetsCancelButton";
 private String loadData ="LoadDataButton";
 private String sortOrder = "SortOrderDropDown";
 private String sortOrderOptionAsc = "SortOrderOptionAsc";
 private String sortColumn = "SortColumnDropDown";
 private String sortColumnOption = "SortColumnOption";
 private String searchWidgetList = "WidgetListSearchBox";
 private String exportWidgetsdata = "ExportWidgetsDataExcel";
 private String exportWidgetBtn = "ExportWidgetBtn";
 private String searchWidgetSouceInList = "SearchWidgetSourceInList";
 private String searchWidgetSourceOption = "SearchWidgetSourceOption";



 
 
 
 public WidgetsPage(WebDriver driver) throws IOException 
 {
  this.driver = driver;
  ReadObjectRepo loginORS = new ReadObjectRepo("PrimeO_OR");
  WidgetsOR_Map = loginORS.generateOR("WidgetsPage_OR");
  pageAction = new PageAction(driver);
  new WaitForPage(driver);
 }
 
 public void createWidget(String widgetName, String viewNameForWidget, String ViewColumnsForWidget)
   throws Exception 
 {
  clickOnWidgetsLink();
  //searchWidgetInList(widgetSearch);
  //searchWidgetSource();
  clickOnCreateWidgetButton();
  enterWidgetName(widgetName);
  //enterWidgetDescription(widgetDescription);
  selectWidgetSource();
  selectSourceView(viewNameForWidget);
  deselect();
  Thread.sleep(5000);
  selectViewColumnsForWidget(ViewColumnsForWidget);
  clickSaveBtn();  
 }

 

 private void clickOnWidgetsLink() {
  // TODO Auto-generated method stub
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, widgetsLink);
  we.click();
  WaitForPage.waitForPagetoLoad();
 }
 
 private void searchWidgetInList(String searchWidget)
 {
  // TODO Auto-generated method stub
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, searchWidgetList);
  WaitForPage.waitForPagetoLoad();
  we.clear();
  we.sendKeys(searchWidget);
  we.click();
  
 }
 
 private void searchWidgetSource() {
  // TODO Auto-generated method stub
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, searchWidgetSouceInList);
  WaitForPage.WaitForWebElement(we);
  we.click();
  
  WebElement we1 = pageAction.getWebElement(WidgetsOR_Map, searchWidgetSourceOption);
  we1.click();
 }
 private void clickOnCreateWidgetButton() {
  // TODO Auto-generated method stub
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, createWidgetButton);
  we.click();
  WaitForPage.waitForPagetoLoad();
 }


 private void enterWidgetName(String widgetName) throws Exception
 {
  
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, widgetsNameField);
  WaitForPage.WaitForWebElement(we);
  we.clear();
  we.sendKeys(widgetName);
 }
 
 private void enterWidgetDescription(String widgetDescription) throws Exception
 {
  
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, widgetsDescriptionField);
  WaitForPage.WaitForWebElement(we);
  we.clear();
  we.sendKeys(widgetDescription);
 }
 
 private void selectWidgetSource() throws Exception
 {
  
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, widgetsSourceDropDown);
  WaitForPage.WaitForWebElement(we);
  we.click();
  
  WebElement we1 = pageAction.getWebElement(WidgetsOR_Map, widgetsSourceOption);
  we1.click();
 }
 
 private void selectSourceView(String viewNameForWidget) throws Exception
 {
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, viewNameForSearch); 
  WaitForPage.waitForPagetoLoad();
  we.clear();
  we.sendKeys(viewNameForWidget);
  Thread.sleep(3000);
 // Actions action=new Actions(driver);
  WebElement we1 = pageAction.getWebElement(WidgetsOR_Map, viewNameForSearch);
 // WebElement we1=driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div/div/div/div/div/div[2]/div/div[1]/div[1]/input"));
  we1.sendKeys(Keys.DOWN);
  we1.sendKeys(Keys.RETURN);
  //we1.sendKeys(Keys.ENTER);
  //action.moveToElement(we1).build().perform();
  //we1.click();
  
  //we.sendKeys(Keys.ENTER);   // to perform ENTER action of Keyboard
  WaitForPage.waitForPagetoLoad();
 }
 
 private void deselect(){
	 List<WebElement> li = pageAction.getWebElements(WidgetsOR_Map, allViewColumnsForWidget);
	 int TotlaViewColumns = li.size();
	 int temp=1;
	 int count=TotlaViewColumns;
	 System.out.println(TotlaViewColumns);
	 for(int i=1;i<=count;i++){
		 WebElement element = driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div/div/div/div/div/div[4]/div[2]/div/div[1]/table"
+"["+(i)+"]//tbody/tr/td[1]/div/div"));
	
			 System.out.println(driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div")).getText());
	
			 JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
		 Actions action=new Actions(driver);
		// action.moveToElement(element).click().perform();
		 //element.click();
		 
	 }
	 }
 
 private void selectViewColumnsForWidget(String ViewColumnsForWidget) throws Exception
 {
 
	 
	 WebElement ele = null;
	  String[] strList = null;
	  //try{
	   List<WebElement> li = pageAction.getWebElements(WidgetsOR_Map, allViewColumnsForWidget);
	   int TotlaViewColumns = li.size();
	   System.out.println("intial columns of view for widget creation are -----> "+TotlaViewColumns);
	   
	    strList = ViewColumnsForWidget.split(",");
	   int temp=1;
	   int count=TotlaViewColumns;
	   
	   for(int i=temp;i<=count;i++)
	   {
	    for(int j=0;j<strList.length;j++)
	    {
	       ele=driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[2]/div"));
	       JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
	      if((ele.getText().trim().equalsIgnoreCase(strList[j])))
	         {
	        WebElement element = driver.findElement(By.xpath("//div[@class='x-grid-item-container']/table"+"["+(i)+"]//tr/td[1]/div"));
	        System.out.println("Name of "+i+"th element is "+ele.getText().trim());
	       WaitForPage.WaitForWebElement(element);
	       Thread.sleep(3000);
	        executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
	       element.click(); 
	       Thread.sleep(1000);
	       }
	         
	     }
	   }
	         /*WebElement we = pageAction.getWebElement(WidgetsOR_Map, loadViewDataToWidget); 
	      we.click();*/
	 
 }
 
private void LoadData(){
	 WebElement we = pageAction.getWebElement(WidgetsOR_Map, loadViewDataToWidget); 
    we.click();
	
}

 
 private void clickSaveBtn() {
	  // TODO Auto-generated method stub
	  WebElement we = pageAction.getWebElement(WidgetsOR_Map, saveWidget);
	  we.click();
	  WaitForPage.waitForPagetoLoad();
	 }
 
 
 
 
 
 
 
 private void selectSortColumn()
 {
  WebElement we = pageAction.getMobileWebElement(WidgetsOR_Map, sortColumn);
  we.click();
  WaitForPage.WaitForWebElement(we);
  WebElement we1 = pageAction.getWebElement(WidgetsOR_Map, sortColumnOption );
  we1.click();
  
 }
 
 private void selectSortOrder()
 {
  WebElement we = pageAction.getMobileWebElement(WidgetsOR_Map, sortOrder);
  we.click();
  WaitForPage.WaitForWebElement(we);
  WebElement we1 = pageAction.getWebElement(WidgetsOR_Map, sortOrderOptionAsc );
  we1.click();
 }
 

 private void clickOnLoadDataBtn()
 {
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, loadData );
  we.click();
  
 }

 private void clickExportBtn()
 {
  //TODO Click on the export buttton 
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, exportWidgetBtn);
  WaitForPage.waitForPagetoLoad();
  we.click();
  WebElement we1 = pageAction.getWebElement(WidgetsOR_Map, exportWidgetsdata );
  we1.click();
  
 }
 
 
 
 private void clickCancelBtn()
 {
  // TODO Auto-generated method stub
  WebElement we = pageAction.getWebElement(WidgetsOR_Map, cancelWidget);
  we.click();
  WaitForPage.waitForPagetoLoad();
 }
 
 
}
