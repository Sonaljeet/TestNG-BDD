/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.Component.Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// TODO: Auto-generated Javadoc
/**
 * The Class ExcelUtils.
 */
public class ExcelUtils {

	/** The fis. */
	private static InputStream fis = null;
	
	/** The fos. */
	private static OutputStream fos = null;

	/** The workbook. */
	private static Workbook workbook = null;
	
	/** The worksheet. */
	private static Sheet worksheet = null;

	/**
	 * Gets the cell data.
	 *
	 * @param excelFilePath
	 *            the excel file path
	 * @param sheetName
	 *            the sheet name
	 * @param rowNum
	 *            the row num
	 * @param colNum
	 *            the col num
	 * @return the cell data
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static RichTextString getCellData(String excelFilePath, String sheetName, int rowNum, int colNum)
			throws IOException {
		File excelFile = new File(excelFilePath);
		RichTextString cellValue = null;
		try {
			fis = new FileInputStream(excelFile);
			if (excelFile.getName().toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
				cellValue = ReadAndReturnCellData(workbook, sheetName, rowNum, colNum);
			} else if (excelFile.getName().toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
				cellValue = ReadAndReturnCellData(workbook, sheetName, rowNum, colNum);
			} else {
				cellValue = null;
				System.out.println("Invalid/corrupt excel file");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Excell file not found" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error getting cell data" + e.getMessage());
		} finally {
			workbook.close();
			fis.close();
		}
		return cellValue;
	}


	/**
	 * Read and return cell data.
	 *
	 * @param wb
	 *            the wb
	 * @param sheetName
	 *            the sheet name
	 * @param rowNum
	 *            the row num
	 * @param colNum
	 *            the col num
	 * @return the rich text string
	 */
	private static RichTextString ReadAndReturnCellData(Workbook wb, String sheetName, int rowNum, int colNum) {
		worksheet = wb.getSheet(sheetName);
		Cell cell = worksheet.getRow(rowNum).getCell(colNum);
		return cell.getRichStringCellValue();

	}

	/**
	 * Sets the cell data.
	 *
	 * @param excelFilePath
	 *            the excel file path
	 * @param sheetName
	 *            the sheet name
	 * @param rowNum
	 *            the row num
	 * @param colNum
	 *            the col num
	 * @param valueToSet
	 *            the value to set
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void setCellData(String excelFilePath, String sheetName, int rowNum, int colNum, String valueToSet)
			throws IOException {
		File excelfile = new File(excelFilePath);
		excelfile.setWritable(true);
		Row row = null;
		try {
			fis = new FileInputStream(excelfile);

			if (excelfile.getName().toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
				worksheet = workbook.getSheet(sheetName);
				if (worksheet.getRow(rowNum) == null) {
					row = worksheet.createRow(rowNum);
				} else {
					row = worksheet.getRow(rowNum);
				}
				Cell cell = row.createCell(colNum);
				cell.setCellValue(valueToSet);
				fis.close();
				fos = new FileOutputStream(excelfile);
				workbook.write(fos);
				fos.close();
			} else if (excelfile.getName().toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
				worksheet = workbook.getSheet(sheetName);
				if (worksheet.getRow(rowNum) == null) {
					row = worksheet.createRow(rowNum);
				} else {
					row = worksheet.getRow(rowNum);
				}
				Cell cell = row.createCell(colNum);
				cell.setCellValue(valueToSet);
				fis.close();
				fos = new FileOutputStream(excelfile);
				workbook.write(fos);
				fos.close();
			} else {
				System.out.println("Incorrect/corrupt excel file");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Excel file not found " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error updating the excel file " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static int getRowsCount(String excelFilePath, String sheetName){
		File excelfile = new File(excelFilePath);
		int rowCount = 0;
		int totalCount = 0;
		Row rows=null;
		int hiddenRowCount = 0;
		try {
			fis = new FileInputStream(excelfile);
			if (excelfile.getName().toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
				worksheet = workbook.getSheet(sheetName);
				totalCount = worksheet.getLastRowNum();
				
				for (int i = 0; i < rowCount; i++) {
					Cell cell= worksheet.getRow(i).getCell(0);
					if (cell.getStringCellValue().isEmpty() || cell.getStringCellValue() == "") {
						hiddenRowCount++;
					}
				}
				
				rowCount = totalCount - hiddenRowCount;
			}else if (excelfile.getName().toLowerCase().endsWith("xlsx")){
				workbook = new HSSFWorkbook(fis);
				worksheet = workbook.getSheet(sheetName);

			}
		} catch (FileNotFoundException e) {
			System.out.println("Excel file not found at path = "+excelFilePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error occured while reading excel file");
			e.printStackTrace();
		}
		return rowCount;
	}

	
	public static int getColumnCount(String excelFilePath, String sheetName){
		File excelfile = new File(excelFilePath);
		int columnCount = 0;

		try {
			fis = new FileInputStream(excelfile);
			if (excelfile.getName().toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
				worksheet = workbook.getSheet(sheetName);
				Row row = worksheet.getRow(2);
				
				columnCount = row.getPhysicalNumberOfCells();

			}else if (excelfile.getName().toLowerCase().endsWith("xlsx")){
				workbook = new XSSFWorkbook(fis);
				worksheet = workbook.getSheet(sheetName);
				Row row = worksheet.getRow(2);
				columnCount = row.getLastCellNum();
				
			}else{
				System.out.println("Not a valid excel file");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Excel file not found at path = "+excelFilePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error occured while reading excel file");
			e.printStackTrace();
		}
		return columnCount;
	}
}































