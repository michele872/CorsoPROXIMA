package utils;

public class MiaMailTest {

	import javax.mail.*;
	import javax.mail.internet.*;
	import java.util.*;
	 
	public void inviaMail(String recipients[], String subject, String message , String from) throws MessagingException
	{
	  boolean debug = false;
	 
	  // Impostazioni SMTP
	  Properties props = new Properties();
	  props.put("mail.smtp.host", "smtp.example.com");
	 
	  // istanzio un oggetto Session
	  Session session = Session.getDefaultInstance(props, null);
	  session.setDebug(debug);
	 
	  // creo l'oggetto Message partendo da Session
	  Message msg = new MimeMessage(session);
	 
	  // Definisco mittente
	  InternetAddress addressFrom = new InternetAddress(from);
	  msg.setFrom(addressFrom);
	 
	  // Destinatari
	  InternetAddress[] addressTo = new InternetAddress[recipients.length]; 
	  for (int i = 0; i < recipients.length; i++)
	  {
	    addressTo[i] = new InternetAddress(recipients[i]);
	  }
	  msg.setRecipients(Message.RecipientType.TO, addressTo);
	    
	  // OPZIONALE: è possibile definire anche dei custom headers...
	  msg.addHeader("MyHeaderName", "myHeaderValue");
	 
	  // Imposto il subject, il contenuto ed il content type (testo semplice)
	  msg.setSubject(subject);
	  msg.setContent(message, "text/plain");
	  
	  // Spedisco
	  Transport.send(msg);
	}

}
