package sendmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class sendmail {

	public static void main(String[] args) throws EmailException {
		// TODO Auto-generated method stub

		Email email= new SimpleEmail();
		email.setHostName("smtp.yahoo.com");
		System.out.println("connected to yahoo");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("akulavenkatesh666", "venky@789"));
		email.setSSLOnConnect(true);
		email.setFrom("akulavenkatesh666@yahoo.com");
			email.setSubject("Test Mail");
			email.setMsg("Test passed");
			email.addTo("akulavenkatesh666@outlook.com");
			email.send();
			
		
		
		
	}

}
