package itextpdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Ticket;

import java.io.FileOutputStream;

public class GeneratePdf {

    public static void genererPdf(Ticket ticket) {
        try {
            String image = "C:\\Users\\ADMIN\\Desktop\\itextPdf\\inf.jpg";
            String fileName = "C:\\Users\\ADMIN\\Desktop\\itextPdf\\ticket.pdf";
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            document.open();

            Paragraph paragraph = new Paragraph("GesCons");
            // Add Image
            //document.add(Image.getInstance(image));

            PdfPTable table = new PdfPTable(6);
            PdfPCell c1 = new PdfPCell(new Phrase("Id"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Date Prise"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Type Service"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Tarif"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Nom"));
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Prenom"));
            table.addCell(c1);

            table.setHeaderRows(1);

            table.addCell(String.valueOf(ticket.getId()));
            table.addCell(String.valueOf(ticket.getDatePrise()));
            table.addCell(ticket.getTypeService());
            table.addCell(String.valueOf(ticket.getTarif()));
            table.addCell(ticket.getNom());
            table.addCell(ticket.getPrenom());

            document.add(paragraph);
            document.add(table);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
