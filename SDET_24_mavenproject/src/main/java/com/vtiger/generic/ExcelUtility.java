package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
/**
 * 
 * @author saratha
 *
 */
public class ExcelUtility {
/**
 * 
 * @param sheetname
 * @param rnum
 * @param cnum
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String ExcelProperty(String sheetname,int rnum,int cnum) throws EncryptedDocumentException, IOException {
		FileInputStream f=new FileInputStream("./data/vitiger.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		
		String value = wb.getSheet(sheetname).getRow(rnum).getCell(cnum).getStringCellValue();
		
return value;
	}
	/**
	 * 
	 * @param sheetname
	 * @param rnum
	 * @param cnum
	 * @param value
	 * @throws Throwable
	 * @throws IOException
	 */
	public void ExcelWrite(String sheetname,int rnum,int cnum,String value) throws Throwable, IOException {
		FileInputStream fs= new FileInputStream("./data/vitiger.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		   wb.getSheet(sheetname).getRow(rnum).getCell(cnum).setCellValue(value);
		   FileOutputStream fo=new FileOutputStream("./data/vitiger.xlsx");
		   wb.write(fo);
		wb.close();
		
	}

}
