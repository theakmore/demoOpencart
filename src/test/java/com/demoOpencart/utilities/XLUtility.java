package com.demoOpencart.utilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	//creating the constructor of XLUtility class
	
	public XLUtility(String path)
	{
		this.path=path;
	}
	
	// method for getting the total no of rows
	
	public int getRowCount(String sheetName) throws Exception 
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);  
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
		
	}
	
	// method for getting the total no of columns
	
	public int getCellCount(String sheetName , int rownum) throws Exception
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
		
		
	}
	
	// method for fetching the data from a particular cell of excel
	
	public String getCellData(String sheetName , int rownum , int colnum) throws Exception
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		// as data in the cell of excel may be in any format(int , string....)...so we have to convert it into the String format:
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try 
		{
		data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="";  // if cell is empty
		}
		
		workbook.close();
		fi.close();
		return data;
		
	}
	
	// method for writing the data in a particular cell of excel
	
	public void setCellData(String sheetName , int rownum , int colnum , String data) throws Exception
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(path); // to write the data ....opening the file in write mode
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
	}
	
	// method for filling the green color in a particular cell of excel
	
	public void fillGreenColor(String sheetName , int rownum , int colnum) throws Exception
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
	}
	
	// method for filling the red color in a particular cell of excel
	
	public void fillRedColor(String sheetName , int rownum , int colnum) throws Exception
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
	}

}
