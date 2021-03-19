package tn.esprit.spring.utils;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import tn.esprit.spring.entity.ChildVaccine;
import tn.esprit.spring.entity.FolderMedical;

public class DetailVaccineChild {

	private FolderMedical folderMedical;

	public DetailVaccineChild(FolderMedical f) {

		this.folderMedical = f;
	}

	private void writeTableVaccinHistoriqueHeader(PdfPTable table) {

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.blue);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Month Number", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Description", font));
		table.addCell(cell);

	}

	private void writeTableDataHistoriqueVaccin(PdfPTable table) {
		for (ChildVaccine child : this.folderMedical.getLisChildVaccines()) {
			table.addCell(String.valueOf(child.getMonthNumber()));
			table.addCell(String.valueOf(child.getDescription()));
		}
	}

	private void writeTableDataVaccinToDo(PdfPTable table) {
		for (ChildVaccine child : this.folderMedical.getListVaccinesToDo()) {
			table.addCell(String.valueOf(child.getMonthNumber()));
			table.addCell(String.valueOf(child.getDescription()));
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph pT = new Paragraph(" Child Vaccine ", font);
		pT.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(pT);

		document.add(new Paragraph("Vaccine history :"));

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 3.5f, 3.5f });
		table.setSpacingBefore(10);

		writeTableVaccinHistoriqueHeader(table);
		writeTableDataHistoriqueVaccin(table);

		document.add(table);

		document.add(new Paragraph("Vaccine to do :"));

		PdfPTable tableToDo = new PdfPTable(2);
		tableToDo.setWidthPercentage(100f);
		tableToDo.setWidths(new float[] { 3.5f, 3.5f });
		tableToDo.setSpacingBefore(10);

		writeTableVaccinHistoriqueHeader(tableToDo);
		writeTableDataVaccinToDo(tableToDo);

		document.add(tableToDo);
		
		document.close();

	}

}
