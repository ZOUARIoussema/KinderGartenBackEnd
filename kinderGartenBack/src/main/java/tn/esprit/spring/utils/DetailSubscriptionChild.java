package tn.esprit.spring.utils;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.PayementSubscription;
import tn.esprit.spring.entity.SubscriptionChild;

public class DetailSubscriptionChild {

	private SubscriptionChild subscriptionChild;

	private double totalExtra = 0;
	private double totalEvent = 0;

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

	private void writeTableEventaHeader(PdfPTable table) {

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.blue);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Date", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Desciption", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("price", font));
		table.addCell(cell);

	}

	private void writeTableDataEvent(PdfPTable table) {

		DateFormat dateFormatter = new SimpleDateFormat("yyyy");

		for (Event event : subscriptionChild.getChild().getLisEvents()) {

			System.out.println("list" + subscriptionChild.getChild().getLisEvents().size());

			if ((dateFormatter.format(subscriptionChild.getDateStart())).equals(dateFormatter.format(event.getDate()))
					|| (dateFormatter.format(subscriptionChild.getDateEnd()))
							.equals(dateFormatter.format(event.getDate()))) {

				table.addCell(String.valueOf(event.getDate()));
				table.addCell(event.getDescription());
				table.addCell(String.valueOf(event.getPrice()));

				totalEvent = totalEvent + event.getPrice();
			}

		}
	}

	private void writeTableDataPayement(PdfPTable table) {
		for (PayementSubscription p : subscriptionChild.getListPayementSubscriptions()) {
			table.addCell(String.valueOf(p.getDateC()));
			table.addCell(String.valueOf(p.getPrice()));
			table.addCell(p.getTypePayement().toString());

		}
	}

	private void writeTableCategorySubsciptionaHeader(PdfPTable table) {

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

	private void writeTableDataSusbscription(PdfPTable table) {

		table.addCell(subscriptionChild.getCategorySubscription().getDescription());
		table.addCell(String.valueOf(subscriptionChild.getCategorySubscription().getPrice()));

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

		if (this.subscriptionChild.getCategorySubscription() != null) {

			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100f);
			table.setWidths(new float[] { 3.5f, 3.5f });
			table.setSpacingBefore(10);

			this.writeTableCategorySubsciptionaHeader(table);
			this.writeTableDataSusbscription(table);

			document.add(table);

			Paragraph pTotalP = new Paragraph(
					"Total Subscription:" + this.subscriptionChild.getCategorySubscription().getPrice(), font);
			pTotalP.setAlignment(Paragraph.ALIGN_RIGHT);

			document.add(pTotalP);
		}

		//

		/* event */

		if (subscriptionChild.getChild().getLisEvents().size() != 0) {

			document.add(new Paragraph("List event :"));

			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(100f);
			table.setWidths(new float[] { 3.5f, 3.5f, 3.5f });
			table.setSpacingBefore(10);

			writeTableEventaHeader(table);
			writeTableDataEvent(table);

			document.add(table);

			Paragraph pTotalP = new Paragraph("Total Event:" + totalEvent, font);
			pTotalP.setAlignment(Paragraph.ALIGN_RIGHT);

			document.add(pTotalP);

		}

		//

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

			Paragraph pTotalP = new Paragraph("Total Extra:" + totalExtra, font);
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

		Paragraph pTotalS = new Paragraph("Total: "
				+ (this.subscriptionChild.getCategorySubscription().getPrice() + this.totalEvent + this.totalExtra),
				font);
		pTotalS.setAlignment(Paragraph.ALIGN_RIGHT);

		document.add(pTotalS);

		Paragraph pDuscount = new Paragraph("Discount: " + subscriptionChild.getDiscount(), font);
		pDuscount.setAlignment(Paragraph.ALIGN_RIGHT);

		document.add(pDuscount);

		Paragraph pRest = new Paragraph("Rest Payement: " + subscriptionChild.getRestPay(), font);
		pRest.setAlignment(Paragraph.ALIGN_RIGHT);

		document.add(pRest);

		document.close();

	}

}
