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
import tn.esprit.spring.entity.Spent;

public class ReportAccountingExel {

	private int rowCountGlobal = 1;

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<PayementSubscription> listPayementSubscriptions;
	private List<Spent> lisSpents;
	private double totalSpent;
	private double totalPay;

	public ReportAccountingExel(List<PayementSubscription> listPayementSubscriptions, List<Spent> lSpent) {

		this.listPayementSubscriptions = listPayementSubscriptions;
		this.lisSpents = lSpent;
		this.workbook = new XSSFWorkbook();

	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Cash register");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "Creation date", style);
		createCell(row, 1, "Type of payement", style);
		createCell(row, 2, "user", style);
		createCell(row, 3, "price", style);
		 
		
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

			rowCountGlobal++;

			createCell(row, columnCount++, String.valueOf(p.getDateC()), style);
			createCell(row, columnCount++, p.getTypePayement().toString(), style);
			createCell(row, columnCount++, p.getUser().getFirstName()+" "+p.getUser().getLastName(), style);
			createCell(row, columnCount++, String.valueOf(p.getPrice()), style);

			totalPay = totalPay + p.getPrice();

		}

		// total column

		Row rowT = sheet.createRow(rowCountGlobal);

		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(rowT, 2, "Total payement", style);
		createCell(rowT, 3, String.valueOf(totalPay), style);

		rowCountGlobal++;

	}

	private void createHeaderSpent() {

		// crete row Spent

		Row row = sheet.createRow(rowCountGlobal);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "Creation date", style);
		createCell(row, 1, "Description", style);
		createCell(row, 2, "Type", style);
		createCell(row, 3, "user", style);
		createCell(row, 4, "Total", style);

		rowCountGlobal++;

	}

	private void writeDataSpent() {

		int rowCount = rowCountGlobal;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Spent s : lisSpents) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			rowCountGlobal++;

			createCell(row, columnCount++, String.valueOf(s.getDateC()), style);
			createCell(row, columnCount++, String.valueOf(s.getDescription()), style);
			createCell(row, columnCount++, s.getType().toString(), style);
			createCell(row, columnCount++, s.getAgentCashier().getFirstName()+" "+s.getAgentCashier().getLastName(), style);
			createCell(row, columnCount++, String.valueOf(s.getTotal()), style);

			totalSpent = totalSpent + s.getTotal();

		}

		// total column

		Row rowT = sheet.createRow(rowCountGlobal);

		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(rowT, 3, "Total Spent", style);
		createCell(rowT, 4, String.valueOf(totalSpent), style);

		rowCountGlobal++;

	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		createHeaderSpent();
		writeDataSpent();

		//

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		Row rowT = sheet.createRow(rowCountGlobal);

		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(rowT, 3, "Total Cash", style);
		createCell(rowT, 4, String.valueOf(totalPay-totalSpent), style);

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
