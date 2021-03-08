package tn.esprit.spring.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tn.esprit.spring.entity.PayementSubscription;

public class ReportAccountingExel {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<PayementSubscription> listPayementSubscriptions;

	public ReportAccountingExel(List<PayementSubscription> listPayementSubscriptions) {

		this.listPayementSubscriptions = listPayementSubscriptions;
		this.workbook = new XSSFWorkbook();
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Accounting");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "Creation date", style);
		createCell(row, 1, "Price", style);
		createCell(row, 2, "Type of payement", style);
		createCell(row, 3, "user", style);
		createCell(row, 4, "subsription", style);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeDataLines() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (PayementSubscription p : listPayementSubscriptions) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++,String.valueOf(p.getDateC()), style);
			createCell(row, columnCount++,String.valueOf(p.getPrice()), style);
			createCell(row, columnCount++, p.getTypePayement().toString(), style);
			createCell(row, columnCount++, p.getUser().getEmail(), style);
			createCell(row, columnCount++, p.getSubscriptionChild().getId(), style);

		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
