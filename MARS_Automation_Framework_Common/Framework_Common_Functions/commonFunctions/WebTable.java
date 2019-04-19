/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package commonFunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTable {

	/**
	 * Gets the row count of web table.
	 *
	 * @param tableElement
	 *            {@link WebElement}
	 * @return row count if it is > 0<br>
	 *         else returns 0
	 */
	public static int getRowCountOfWebTable(WebElement tableElement) {

		List<WebElement> rowElements = tableElement.findElements(By.tagName("tr"));
		int numberOfRows = rowElements.size();
		if (numberOfRows > 0) {
			return numberOfRows;
		} else {
			return 0;
		}
	}

	/**
	 * Gets the column count of web table.
	 *
	 * @param tableElement
	 *            {@link WebElement}
	 * @return column count if it is > 0<br>
	 *         else returns 0
	 */
	public static int getColumnCountOfWebTable(WebElement tableElement) {

		List<WebElement> columnElements = tableElement.findElements(By.tagName("td"));

		int numberOfColumns = columnElements.size();

		if (numberOfColumns > 0) {
			return numberOfColumns;
		} else {
			return 0;
		}
	}
//TO-Do : Yet to write method to access dynamic web table
	public static void SearchRowInWebTableByName() {

	}
	
	/**
	 * Seacrh and return table element by name.
	 *
	 * @param tableElement the table element
	 * @param textToSearch the text to search
	 * @return the web element
	 * NOTE: This method will work only when the WebElement has text visible on UI.
	 * If there is no text visible on UI, NULL will be returned
	 */
	public static WebElement SeacrhAndReturnTableElementByName(WebElement tableName, String textToSearch){
		List<WebElement> rows = null;
		List<WebElement> columns = null;
		String visibleText = null;
		String visibleText1 = null;
		WebElement foundElement = null;
		WebElement tableElement = tableName.findElement(By.tagName("table"));
		WebElement tableBody = tableElement.findElement(By.tagName("tbody"));
		//System.out.println("Tbody found");
		rows = tableBody.findElements(By.tagName("tr"));
		if (rows !=null) {
			//System.out.println("rows not null");
			for (WebElement rowElements : rows) {
				columns = rowElements.findElements(By.tagName("td"));
				//System.out.print("Column Size : "+columns.size());
				for (WebElement columnElements : columns) {
					//System.out.print("\t\tcolumnElements Name : "+ columnElements.getAttribute("id"));
					visibleText = columnElements.getAttribute("textContent").trim().toUpperCase();
					visibleText1 = columnElements.getText().trim().toUpperCase();
					//System.out.println("visible text : " +visibleText);
					//System.out.println("visible text1 : " +visibleText1);
					if (visibleText.contentEquals(textToSearch.toUpperCase()) || visibleText1.contentEquals(textToSearch.toUpperCase())) {
						foundElement = columnElements;
						System.out.println("Text \""+visibleText +"\" found");
						break;
					}
				}
			}
		}
		return foundElement;
	}
	
	/**
	 * Gets the table row web elements.
	 *
	 * @param element The id or name of the table div. Do not give the id of <tbody> div
	 * @return the table row web elements
	 */
	public static List<WebElement> getTableRowWebElements(WebElement element){
		List<WebElement> rowElements = null;
		WebElement tableElement = element.findElement(By.tagName("tbody"));
		rowElements = tableElement.findElements(By.tagName("tr"));
		
		if (rowElements != null) {
			System.out.println("rowElements.size() = " +rowElements.size());
		}
		return rowElements;
	}
	
	public static List<WebElement> getColumnRows(WebElement rowElement){
		//WebElement tableElement = element.findElement(By.tagName("tbody"));
		List<WebElement> columnElements = rowElement.findElements(By.tagName("td"));
		
		if (columnElements !=null) {
			System.out.println(columnElements.size());
		}
		return columnElements;
	}
}
