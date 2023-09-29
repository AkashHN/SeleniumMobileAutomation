package com.base;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmailWithAttachment  {

	public static void sendEmailWithReport(String reportPath) {
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.gmail.com"); // Your SMTP server
            email.setSmtpPort(587); // Your SMTP port
            email.setAuthenticator(new DefaultAuthenticator("akashgowda0902@gmail.com", "ecgz cptm sgfu tjds"));
            email.setStartTLSRequired(true);
            email.setFrom("akashgowda0902@gmail.com");
            email.addTo("akashgowda0902@gmail.com");
            email.setSubject("Test Report with Images");
            email.setMsg("Hello, please find the attached report and images.");

            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(reportPath); // Path to the Extent Report
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Extent Report");
            attachment.setName("extent-report.html");
            email.attach(attachment);
            email.send();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
