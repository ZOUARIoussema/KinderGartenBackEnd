package tn.esprit.spring.utils;

import java.util.List;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.GroupLayout.Alignment;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import tn.esprit.spring.entity.CategorySubscription;
import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.PayementSubscription;
import tn.esprit.spring.entity.SubscriptionChild;

public class DetailSubscriptionChild {

	private SubscriptionChild subscriptionChild;

	private double totalExtra;

	public DetailSubscriptionChild(SubscriptionChild s) {
		this.subscriptionChild = s;
	}

	private void writeTableExtraHeader(PdfPTable table) {

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.blue);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Desciption", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("price", font));
		table.addCell(cell);

	}

	private void writeTableDataExtra(PdfPTable table) {
		for (Extra extra : subscriptionChild.getLisExtras()) {
			table.addCell(extra.getDescription());
			table.addCell(String.valueOf(extra.getPrice()));
			totalExtra = totalExtra + extra.getPrice();

		}
	}

	private void writeTablePayementHeader(PdfPTable table) {

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Date create", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("price", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Type", font));
		table.addCell(cell);

	}

	private void writeTableDataPayement(PdfPTable table) {
		for (PayementSubscription p : subscriptionChild.getListPayementSubscriptions()) {
			table.addCell(String.valueOf(p.getDateC()));
			table.addCell(String.valueOf(p.getPrice()));
			table.addCell(p.getTypePayement().toString());

		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph pT = new Paragraph("Detail Subsciption child", font);
		pT.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(pT);

		document.add(new Paragraph("Detail subscription"));

		Paragraph pD = new Paragraph(
				"categry subscription: " + subscriptionChild.getCategorySubscription().getDescription());

		document.add(pD);

		document.add(new Paragraph("Price :" + subscriptionChild.getCategorySubscription().getPrice()));

		//

		if (subscriptionChild.getLisExtras().size() != 0) {

			document.add(new Paragraph("List extra :"));

			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100f);
			table.setWidths(new float[] { 3.5f, 3.5f });
			table.setSpacingBefore(10);

			writeTableExtraHeader(table);
			writeTableDataExtra(table);

			document.add(table);

			Paragraph pTotalP = new Paragraph("Total Extra:" + subscriptionChild.getTotalPay(), font);
			pTotalP.setAlignment(Paragraph.ALIGN_RIGHT);

			document.add(pTotalP);

		}

		//

		if (subscriptionChild.getListPayementSubscriptions().size() != 0) {

			document.add(new Paragraph("Historie Payement:"));

			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(100f);
			table.setWidths(new float[] { 3.5f, 3.5f, 3.5f });
			table.setSpacingBefore(10);

			writeTablePayementHeader(table);
			writeTableDataPayement(table);

			document.add(table);

			Paragraph pTotalP = new Paragraph("Total Payement:" + subscriptionChild.getTotalPay(), font);
			pTotalP.setAlignment(Paragraph.ALIGN_RIGHT);

			document.add(pTotalP);

		}

		Paragraph pRest = new Paragraph("Rest Payement: " + subscriptionChild.getRestPay(), font);
		pRest.setAlignment(Paragraph.ALIGN_RIGHT);

		document.add(pRest);

		document.close();

	}

}
