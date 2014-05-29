package Controlador;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
/**
 *
 * @author caenhiro
 */
import java.io.File;
import java.io.IOException;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caenhiro
 */
public class EnviaMail {
    
    final String miCorreo = "escueladeinglesdt@gmail.com";
    final String miContraseña = "holamundo";
    final String servidorSMTP = "smtp.gmail.com";
    final String puertoEnvio = "465";
    String mailReceptor = null;
    String asunto = null;
    String cuerpo = null;
    
    /**
     *Constructor
     * @param mailReceptor mail del destinatario
     * @param asunto asunto del mail
     * @param cuerpo curapo del mail
     */
    public EnviaMail(String mailReceptor, String asunto,
            String cuerpo) {
        this.mailReceptor = mailReceptor;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        
        Properties props = new Properties();
        props.put("mail.smtp.user", miCorreo);
        props.put("mail.smtp.host", servidorSMTP);
        props.put("mail.smtp.port", puertoEnvio);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", puertoEnvio);
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        
        SecurityManager security = System.getSecurityManager();
        
        try {
            Authenticator auth = new autentificadorSMTP();
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.setText(cuerpo);
            msg.setSubject(asunto);
            msg.setFrom(new InternetAddress(miCorreo));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    mailReceptor));
            Transport.send(msg);
        } catch (MessagingException mex) {
            System.out.println(mex);
            
        }
        
    }
    
    private class autentificadorSMTP extends javax.mail.Authenticator {
        
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(miCorreo, miContraseña);
        }
    }
//    
//    public static void main(String[] args) {
//        
//        /*
//        for(int cont = 0; cont < 500; cont++){
//        EnviaMail mail = new EnviaMail("hdez_bastida_353@yahoo.com.mx", "[Estas siendo spameado]", "Estas siendo spameado");
//        }
//        */
//        
//        
//        String basePath = new File("").getAbsolutePath();
//        System.out.println(basePath);
//        String[] parts = basePath.split("/");
//        System.out.println("/"+parts[1]+"/"+parts[2]);
//        
//    }
}