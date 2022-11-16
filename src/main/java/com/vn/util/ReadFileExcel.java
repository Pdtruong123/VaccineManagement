package com.vn.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.vn.model.Vaccine;

public class ReadFileExcel {
	public static boolean checkExcelFormat(MultipartFile file) {
		
		// check file excel
		String type = file.getContentType();
		if (type.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}else {
			return false;
		}
	}
	@SuppressWarnings("deprecation")
	public static List<Vaccine> importFileExcel(InputStream inputStream) {
		List<Vaccine> vaccines = new ArrayList<>();
		String id="";
		String contraindication="";
		String indication="";
		Integer numberOfInjection=0;
		String origin="";
		Date timeBeginNextInjection=null;
		Date timeEndNextInjection=null;
		String usage="";
		String vaccineName="";
		Boolean status = null;
		
		
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet =  workbook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			
			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.iterator();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int collumIndex = nextCell.getColumnIndex();
					switch (collumIndex) {
					case 0:
						id = (String) nextCell.getStringCellValue();
						System.out.println(id);
						break;
					case 1:
						contraindication = (String) nextCell.getStringCellValue();
						System.out.println(contraindication);
						break;
					case 2:
						indication = (String) nextCell.getStringCellValue();
						System.out.println(indication);
						break;
					case 3:
						numberOfInjection = (int) nextCell.getNumericCellValue();
						System.out.println(numberOfInjection);
						break;
					case 4:
						origin = (String) nextCell.getStringCellValue();
						System.out.println(origin);
						break;
					case 5:
						Date dateBegin = nextCell.getDateCellValue();
						timeBeginNextInjection = dateBegin;
						System.out.println(dateBegin);
						break;
					case 6:
						Date dateNext = nextCell.getDateCellValue();
						timeEndNextInjection = dateNext;
						System.out.println(dateNext);
						break;
					case 7:
						usage = (String) nextCell.getStringCellValue();
						System.out.println(usage);
						break;
					case 8:
						vaccineName = (String) nextCell.getStringCellValue();
						System.out.println(vaccineName);
						break;
					case 9:
						status = (Boolean) nextCell.getBooleanCellValue();
						System.out.println(status);
						break;
					default:
						break;
					}
				}
				vaccines.add(new Vaccine(id, contraindication, indication, numberOfInjection, origin, timeBeginNextInjection, timeEndNextInjection, usage, vaccineName, status));
				
			}
			workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Vaccine vaccine : vaccines) {
			System.out.println(vaccine.toString());
		}
		return vaccines;
	}
}
