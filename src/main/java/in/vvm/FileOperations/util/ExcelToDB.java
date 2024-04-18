//package in.vvm.FileOperations.util;
//
//import java.io.IOException;
//import java.lang.reflect.Field;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.multipart.MultipartFile;
//
//public class ExcelToDB {
//
//	public void saveExcelDataToDatabase(MultipartFile file) {
//		try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
//			for (Sheet sheet : workbook) {
//				String tableName = sheet.getSheetName();
//				Iterator<Row> rowIterator = sheet.iterator();
//				// Assuming the first row contains column headers
//				Row headerRow = rowIterator.next();
//				List<String> columnNames = new ArrayList<>();
//				for (Cell cell : headerRow) {
//					columnNames.add(cell.getStringCellValue());
//				}
//				// Getting Data Types from the first row of the table
//				List<String> columnType = new ArrayList<>();
//				for (Cell cell : sheet.getRow(1)) {
//					switch (cell.getCellType()) {
//					case (Cell.CELL_TYPE_NUMERIC):
//						columnType.add(" INT");
//						break;
//					case (Cell.CELL_TYPE_STRING):
//						columnType.add(" VARCHAR(255)");
//						break;
//					case (Cell.CELL_TYPE_BOOLEAN):
//						columnType.add(" BOOLEAN");
//						break;
//					case (Cell.CELL_TYPE_ERROR):
//						columnType.add(" VARCHAR(255)");
//						break;
//					case (Cell.CELL_TYPE_FORMULA):
//						columnType.add(" VARCHAR(255)");
//						break;
//					default:
//						break;
//					}
//				}
//				String yourDbUrl = "", username = "", password = "";
//				StringBuilder coloumns = new StringBuilder("");
//				Connection connection = DriverManager.getConnection(yourDbUrl, username, password);
//				// Create the table if it doesn't exist
//				StringBuilder sqlCreate = new StringBuilder("CREATE TABLE IF NOT EXISTS ").append(tableName)
//						.append(" (").append(coloumns).append(")");
//				for (String columnName : columnNames) {
//					if (coloumns.equals(null)) {
//						coloumns.append(columnName);
//					} else {
//						coloumns.append(", ").append(columnName);
//					}
//					coloumns.append(columnType);
//				}
//				Statement statement = connection.createStatement();
//				statement.execute(sqlCreate.toString());
////				Prepare the INSERT statement
//				StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
//				sqlBuilder.append(tableName).append(" (");
//				for (String columnName : columnNames) {
//					sqlBuilder.append(columnName).append(", ");
//				}
//				sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length()); // Remove trailing comma
//				sqlBuilder.append(") VALUES (");
//				for (int i = 0; i < columnNames.size(); i++) {
//					sqlBuilder.append("?, ");
//				}
//				sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length()); // Remove trailing comma
//				sqlBuilder.append(")");
//				String insertSql = sqlBuilder.toString();
//				// Iterate through Excel rows
//				while (rowIterator.hasNext()) {
//					Row row = rowIterator.next();
//					List<Object> cellValues = new ArrayList<>();
//					for (Cell cell : row) {
//						// Extract cell values and add to cellValues list
//						// Handle different data types (e.g., String, int, etc.)
//						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
//							cell.getStringCellValue();
//						} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
//							cell.getNumericCellValue();
//						} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
//							cell.getBooleanCellValue();
//						}
//					}
//					try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
//						for (int i = 0; i < cellValues.size(); i++) {
//							preparedStatement.setObject(i + 1, cellValues.get(i));
//						}
//						preparedStatement.executeUpdate();
//					}
//				}
//			}
//		} catch (IOException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}