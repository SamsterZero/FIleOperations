//package in.vvm.FileOperations.util;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.multipart.MultipartFile;
//
//public class ExcelToDB {
//	public void saveExcelDataToDatabase(MultipartFile file, String tableName) {
//		try (Connection connection = DriverManager.getConnection(yourDbUrl, username, password)) {
//			XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
//			Sheet sheet = workbook.getSheetAt(0);
//			Iterator<Row> rowIterator = sheet.iterator();
//
//			// Assuming the first row contains column headers
//			Row headerRow = rowIterator.next();
//			List<String> columnNames = getColumnNames(headerRow);
//
//			// Create the table if it doesn't exist
//			createTableIfNotExists(connection, tableName, columnNames);
//
//			// Prepare the INSERT statement
//			String insertSql = generateInsertStatement(tableName, columnNames);
//
//			// Iterate through Excel rows
//			while (rowIterator.hasNext()) {
//				Row row = rowIterator.next();
//				List<Object> cellValues = getCellValues(row);
//				executeInsertStatement(connection, insertSql, cellValues);
//			}
//		} catch (IOException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private List<String> getColumnNames(Row headerRow) {
//		List<String> columnNames = new ArrayList<>();
//		for (Cell cell : headerRow) {
//			columnNames.add(cell.getStringCellValue());
//		}
//		return columnNames;
//	}
//
//	private void createTableIfNotExists(Connection connection, String tableName, List<String> columnNames)
//			throws SQLException {
//		// Implement logic to create the table if it doesn't exist
//		// Use columnNames to define the table schema
//		// Example: CREATE TABLE IF NOT EXISTS your_table_name (col1 VARCHAR(255), col2
//		// INT, ...)
//	}
//
//	private String generateInsertStatement(String tableName, List<String> columnNames) {
//		StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
//		sqlBuilder.append(tableName).append(" (");
//		for (String columnName : columnNames) {
//			sqlBuilder.append(columnName).append(", ");
//		}
//		sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length()); // Remove trailing comma
//		sqlBuilder.append(") VALUES (");
//		for (int i = 0; i < columnNames.size(); i++) {
//			sqlBuilder.append("?, ");
//		}
//		sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length()); // Remove trailing comma
//		sqlBuilder.append(")");
//		return sqlBuilder.toString();
//	}
//
//	private List<Object> getCellValues(Row row) {
//		List<Object> cellValues = new ArrayList<>();
//		for (Cell cell : row) {
//			// Extract cell values and add to cellValues list
//			// Handle different data types (e.g., String, int, etc.)
//		}
//		return cellValues;
//	}
//
//	private void executeInsertStatement(Connection connection, String insertSql, List<Object> cellValues)
//			throws SQLException {
//		try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
//			for (int i = 0; i < cellValues.size(); i++) {
//				preparedStatement.setObject(i + 1, cellValues.get(i));
//			}
//			preparedStatement.executeUpdate();
//		}
//	}
//
//}
