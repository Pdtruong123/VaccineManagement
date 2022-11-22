package com.vn.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.vn.model.Vaccine;
import com.vn.model.VaccineType;
import com.vn.repository.VaccineRepository;
import com.vn.repository.VaccineTypeRepository;
import com.vn.service.VaccineService;
import com.vn.service.VaccineTypeService;
import com.vn.service.impl.VaccineServiceImpl;
import com.vn.service.impl.VaccineTypeServiceImpl;

@Component
public class ReadFileExcel {

	@Autowired
	VaccineTypeService vaccineTypeService;

	public boolean checkExcelFormat(MultipartFile file) {
		// check file excel
		String type = file.getContentType();
		return type.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}

	public List<Vaccine> importFileExcel(InputStream inputStream) {
		List<Vaccine> vaccines = new ArrayList<>();
		String id = "";
		String contraindication = "";
		String indication = "";
		Integer numberOfInjection = 0;
		String origin = "";
		Date timeBeginNextInjection = null;
		Date timeEndNextInjection = null;
		String usage = "";
		String vaccineName = "";
		Boolean status = null;
		String vaccineTypeName = "";
		VaccineType vaccineType = new VaccineType();

		try {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);

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
							id = nextCell.getStringCellValue();

							break;
						case 1:
							contraindication = nextCell.getStringCellValue();

							break;
						case 2:
							indication = nextCell.getStringCellValue();

							break;
						case 3:
							numberOfInjection = (int) nextCell.getNumericCellValue();

							break;
						case 4:
							origin = nextCell.getStringCellValue();

							break;
						case 5:
							Date dateBegin = nextCell.getDateCellValue();
							timeBeginNextInjection = dateBegin;

							break;
						case 6:
							Date dateNext = nextCell.getDateCellValue();
							timeEndNextInjection = dateNext;

							break;
						case 7:
							usage = nextCell.getStringCellValue();

							break;
						case 8:
							vaccineName = nextCell.getStringCellValue();

							break;
						case 9:
							status = nextCell.getBooleanCellValue();

							break;
						case 10:
							vaccineTypeName = nextCell.getStringCellValue();

							vaccineType = vaccineTypeService.findByVaccineTypeName(vaccineTypeName);

							break;
						default:
							break;
					}
				}
				if (vaccineType != null) {
					vaccines.add(new Vaccine(id, contraindication, indication, numberOfInjection, origin, timeBeginNextInjection, timeEndNextInjection, usage, vaccineName, status, vaccineType));
				}
			}
			workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vaccines;
	}
}
