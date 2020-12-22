package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestData {

	
	
	public TestData()
	{
		try
		{
			String srcfile = "xcelData.xls";
			FileInputStream f1= new FileInputStream(srcfile);
			Workbook wb = Workbook.getWorkbook(f1);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static String  getCell(int row, int col) throws BiffException, IOException
	{
		String srcfile = "xcelData.xls";
		FileInputStream f1= new FileInputStream(srcfile);
		
	Workbook wb = Workbook.getWorkbook(f1);
		
		Sheet sh = wb.getSheet(0);
		return srcfile;
	}
	
	

}
