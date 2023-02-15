package com.pdf.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


@Service
public class PdfService {
	
	
	private Logger logger= LoggerFactory.getLogger(PdfService.class);
	public ByteArrayInputStream createPdf() {
		
		logger.info("Create PDF Started : ");
		
		
		String title="Welcome to Learn Code with Durgesh";
		String content="We provide technical content . Please do subscribe youtube channel for more contents ";
		
		
		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
		
		Document document = new Document();
		
		PdfWriter.getInstance(document, out);
		
		document.open();
		
		Font titleFont= FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
		Paragraph titlePara=new Paragraph(title, titleFont);
		
		titlePara.setAlignment(Element.ALIGN_CENTER);
		
		document.add(titlePara);
		
		Font paraFont= FontFactory.getFont(FontFactory.HELVETICA,18);
		Paragraph paragraph= new Paragraph(content);
		paragraph.add(new Chunk("Wow this tsext is added  after creating paragraph "));
		document.add(paragraph);
		
		document.close();
		
		
		return new ByteArrayInputStream(out.toByteArray());
		
		
		
		
		
		
		
		
		
		
	}

}
