package in.vvm.FileOperations.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("hiding")
public class ExcelConverter<T> {

	public List<T> excelToObjectList(MultipartFile file, Class<T> objectType) {
		List<T> objectList = new ArrayList<>();
		try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			if (rowIterator.hasNext()) {
				rowIterator.next();
			}
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				T obj = createObjectFromRow(row, objectType);
				objectList.add(obj);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objectList;
	}

	private T createObjectFromRow(Row row, Class<T> objectType) {
		try {
			T obj = objectType.getDeclaredConstructor().newInstance();
			Field[] fields = objectType.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Cell cell = row.getCell(i);
				if (cell != null) {
					fields[i].setAccessible(true);
					setFieldValue(obj, fields[i], cell);
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void setFieldValue(T obj, Field field, Cell cell) throws IllegalAccessException {
		if (field.getType() == int.class) {
			field.setInt(obj, (int) cell.getNumericCellValue());
		} else if (field.getType() == String.class) {
			field.set(obj, cell.getStringCellValue());
		}
	}
}