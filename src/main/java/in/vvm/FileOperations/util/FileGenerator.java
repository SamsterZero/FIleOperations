package in.vvm.FileOperations.util;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;

public class FileGenerator<T> {

	public ByteArrayResource generateExcel(String name, List<T> objList) {
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Sheet1");
			Row headerRow = sheet.createRow(0);
			Field[] fieldheaders = objList.get(0).getClass().getDeclaredFields();
			for (int i = 0; i < fieldheaders.length; i++) {
				Cell headerCell = headerRow.createCell(i);
				headerCell.setCellValue(fieldheaders[i].getName());
			}
			System.out.println(objList.getClass().getTypeName());
			for (int i = 1; i < objList.size(); i++) {
				Row dataRow = sheet.createRow(i);
				T obj = objList.get(i);
				Field[] fields = obj.getClass().getDeclaredFields();
				for (int j = 0; j < fields.length; j++) {
					Cell dataCell = dataRow.createCell(j);
					fields[j].setAccessible(true);
					try {
						dataCell.setCellValue(fields[j].get(obj).toString());
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}

//			FileOutputStream fileOutputStream = new FileOutputStream(name);
//			workbook.write(fileOutputStream);
//			fileOutputStream.close();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			byte[] excelBytes = outputStream.toByteArray();
			return new ByteArrayResource(excelBytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}