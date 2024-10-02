package view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modele.Direction;

public class test {
	
	static Scanner sc = new Scanner(System.in);
	static Object[][] data;
	static Direction dir = new Direction(); 
	
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
//		now.getDayOfMonth();
//		now.getDayOfWeek();
//		now.getDayOfYear();
		now.getMonthValue();
		now.getMonth();
		System.out.println("Date: "+now.toString());
		System.out.println("day of month: "+now.getDayOfMonth());
		System.out.println("day of week: "+now.getDayOfWeek());
		System.out.println("day of year: "+now.getDayOfYear());
		System.out.println(now.getMonthValue());
		System.out.println("Month: "+now.getMonth());
		
		
		
		/**
		 * PDF
		 */
		System.out.println("le nom: ");
		String nom = sc.next();
		
		Document doc = new Document();
		try {
			PdfWriter writer;
			writer = PdfWriter.getInstance(doc, new FileOutputStream("D://"+nom+".pdf"));
			System.out.println("PDF created.");
			
			doc.open();
			doc.add(new Paragraph("Liste des consultation "));
			doc.add(new Paragraph(""+now));
			
			PdfPTable table = new PdfPTable(4); // Assuming you have 7 columns in your data array
		    table.setWidthPercentage(100);
		    
		    
		    table.addCell("ID");
		    table.addCell("Acronyme");
		    table.addCell("nomination");
		    int len = dir.getLengthTable();
		    data = new Object[len][3];
		    dir.Liste_direction(data);
		    
		    
		 // Add table data
		    for (int i = 0; i < data.length; i++) {
		        for (int col = 0; col < data[i].length; col++) {
		            table.addCell(data[i][col].toString());
		        }
		    }
			doc.add(table);
			doc.close();
			writer.close();
			System.out.println("PDF créer avec succès!");
		} catch (DocumentException e){
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
