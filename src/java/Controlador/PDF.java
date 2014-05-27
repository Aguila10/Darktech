package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caenhiro
 */
public class PDF {

    public static String escribePDF(String nombre) throws DocumentException {
        FileOutputStream ficheroPdf = null;
        try {

            Document documento = new Document();
            String basePath = new File("").getAbsolutePath();
            String[] parts = basePath.split("/");
            final String path = "/"+parts[1]+"/"+parts[2]+"/NetBeansProjects/pag_ingles/web/constancia.pdf";
            ficheroPdf = new FileOutputStream(path);
            try {
          PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
            } catch (DocumentException ex) {
                Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            }

            documento.open();
            try {
                Image foto = Image.getInstance("/"+parts[1]+"/"+parts[2]+"/NetBeansProjects/pag_ingles/web/img/escuela.png");
                foto.scaleToFit(200, 200);
                foto.setAlignment(Chunk.ALIGN_RIGHT);
                documento.add(foto);
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
            
            
                  documento.add(new Paragraph("Darktech Anglo Institute",
                    FontFactory.getFont("Courier-Bold", 30, Font.UNDERLINE, BaseColor.BLUE)));
           
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
           
           documento.add(new Paragraph("        OTORGA LA PRESENTE",
                     
                    FontFactory.getFont("ARIAL", 30, Font.NORMAL , BaseColor.BLACK)));
  
               

            
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
            
            documento.add(new Paragraph("            CONSTANCIA",
                    FontFactory.getFont("ARIAL", 30, Font.NORMAL , BaseColor.BLACK)));
  
            
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
            
           
            documento.add(new Paragraph("  A        " + nombre ,
                    FontFactory.getFont("ARIAL", 20, Font.BOLD, BaseColor.BLACK)));
   
            
            
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
           documento.add(new Paragraph("           "));
            
            documento.add(new Paragraph("POR HABER CONCLUIDO CON EXITO EL CURSO DE INGLES.",
                    FontFactory.getFont("ARIAL", 14, Font.NORMAL, BaseColor.BLACK)));
   
            documento.close();
           
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            try {
                ficheroPdf.close();
            } catch (IOException ex) {
                Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
    }


}