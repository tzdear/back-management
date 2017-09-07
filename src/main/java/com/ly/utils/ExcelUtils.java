package com.ly.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
* @ClassName: ExcelUtils
* @Description: 
* @author linyan
* @date 2017年8月16日 下午4:17:28
*
*/
public class ExcelUtils {

	public static void main(String[] args) {
		ExcelUtils excelUtils = new ExcelUtils();
		try {
//			excelUtils.writer();
//			
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
			excelUtils.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public Map<String, Object> read() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Workbook wb = new HSSFWorkbook(new FileInputStream(file));
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(0);
		CellStyle style = row.getRowStyle();
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(style));
		row.setRowStyle(style);
		Cell cell = row.getCell(0);
		CellStyle cellStyle = cell.getCellStyle();
		System.out.println(objectMapper.writeValueAsString(cellStyle));
		String g = cell.getStringCellValue();
		System.out.println(cell.getCellTypeEnum() == CellType.STRING);
		try {
			System.out.println(Boolean.valueOf(g));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(g);
		}
		
		return map;
	}
	
	File file = new File("D:\\linyananzhuang\\gggal.xls");
	public Map<String, Object> writer() throws Exception{
		Map<String, Object> map  = new HashMap<String, Object>();
		Workbook wb = new HSSFWorkbook();
		Sheet s = wb.createSheet("测试一个");
		Row r = s.createRow(0);
		Cell c = r.createCell(0,CellType.BOOLEAN);
		c.setCellValue("trued");
		if (!file.exists()) {
			file.createNewFile();
		}
		wb.write(new FileOutputStream(file));
		wb.close();
//		Workbook wb = new XSSFWorkbook();
		return map;
	}
	
}
