package com.base;

import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmailWithAttachment  {

	public static void sendEmailWithReport(String reportPath, Properties configProperties) {
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName(configProperties.getProperty("emailHostName"));
            email.setSmtpPort(Integer.parseInt(configProperties.getProperty("SmtpPort")));
            email.setAuthenticator(new DefaultAuthenticator(configProperties.getProperty("emailUsername"), configProperties.getProperty("emailPassword")));
            email.setStartTLSRequired(true);
            email.setFrom(configProperties.getProperty("emailUsername"));
            email.addTo(configProperties.getProperty("sendToCust1"));
            email.addTo(configProperties.getProperty("sendToCust2"));
            email.setSubject("Test Report with Images");
            email.setMsg("Hello, please find the attached report and images.");

            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(reportPath);
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
