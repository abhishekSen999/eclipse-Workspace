package src;


import java.io.*;
import org.apache.poi.hssf.usermodel.*;

public class WriteExcel 
{

	public static void main(String args[])throws IOException
	{
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("FirstExcelSheet");
		HSSFRow row=sheet.createRow(0);
		HSSFCell cell=row.createCell(0);
		cell.setCellValue("1st cell");
		sheet=workbook.createSheet("secondExcelSheet");
		row=sheet.createRow(0);
		cell=row.createCell(0);
		cell.setCellValue("1st cell");
		workbook.write(new FileOutputStream("test.xls"));
		workbook.close();
		System.out.println("end");
	}
}

  