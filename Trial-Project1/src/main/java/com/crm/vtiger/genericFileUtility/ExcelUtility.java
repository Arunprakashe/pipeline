package com.crm.vtiger.genericFileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readFromExcelUtility(String sheet,int row,int cell) throws  IOException {
		FileInputStream fis = new FileInputStream(IpathConstant.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

}
