package mars.Business.Layer;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import static mars.JCI.Project.CEP.DailyDataCheckList.CEP_DailyDataCheckList_Page_Action.getStartTime;
import static mars.JCI.Project.CEP.DailyDataCheckList.CEP_DailyDataCheckList_Page_Action.getEndTime;

public class CEP_DailyStatusReport {

	private static String host = null;
	private static String port = null;
	private static String toAddressList = null;
	private static String ccAddressList=null;
	private static String bccAddress=null;
	private static String fromAddress = null;
	private static String EmailSubject = null;
	private static String messageText = null;
	private static String attachment1 = null;
	private static String attachment2 = null;
	private static Properties properties = null;
	private static Session session = null;
	private static Message message = null;
	private static MimeMessage mimeMessage = null;
	private static MimeBodyPart bodyPart = null;

	/**
	 * Instantiates a new email reports.
	 */
	public CEP_DailyStatusReport(String mailConfigFile) {

		// Read All properties from the property file

		System.out.println("mailConfigFile:" + mailConfigFile);
		host = ReadPropertyFile.getInstance(mailConfigFile).getProperty("host");
		port = ReadPropertyFile.getInstance(mailConfigFile).getProperty("port");
		toAddressList = ReadPropertyFile.getInstance(mailConfigFile).getProperty("toAddressList");
		ccAddressList= ReadPropertyFile.getInstance(mailConfigFile).getProperty("ccAddressList");
		bccAddress=ReadPropertyFile.getInstance(mailConfigFile).getProperty("bccAddress");
		fromAddress = ReadPropertyFile.getInstance(mailConfigFile).getProperty("fromAddress");
		EmailSubject = ReadPropertyFile.getInstance(mailConfigFile).getProperty("EmailSubject");
		// messageText =
		// ReadPropertyFile.getInstance(mailConfigFile).getProperty("messageText");
		attachment1 = ReadPropertyFile.getInstance(mailConfigFile).getProperty("attachment");
		attachment2 = ReadPropertyFile.getInstance(mailConfigFile).getProperty("reportfilepath");
		messageText = ReadTextFile.readFile(ReadPropertyFile.getInstance(mailConfigFile).getProperty("messageText"));
		properties = new Properties();
		properties.setProperty("mail.smtp.host", host);
		session = Session.getDefaultInstance(properties);
	}

	/**
	 * Send email with reports.
	 *
	 * @return true, if successful, otherwise false
	 */
	public boolean sendEmailWithReports() {
		try {

			// Create new Email Message
			message = new MimeMessage(session);

			// Set From Address
			message.setFrom(new InternetAddress(fromAddress));

			// // Set Receipients
			// InternetAddress[] recipients = { new
			// InternetAddress(toAddressList) };
			// message.setRecipients(Message.RecipientType.TO, recipients);

			// Set Receipients
			String[] toAddressListAray = toAddressList.split(";");
			String[] ccAddressListArray=ccAddressList.split(";");
			InternetAddress[] recipients = new InternetAddress[toAddressListAray.length];
			InternetAddress[] ccRecipients = new InternetAddress[ccAddressListArray.length];
			InternetAddress bccRecipient = new InternetAddress(bccAddress);
			for (int i = 0; i < recipients.length; i++) {
				recipients[i] = new InternetAddress(toAddressListAray[i].trim());
			}
			for (int i = 0; i < ccRecipients.length; i++) {
				ccRecipients[i] = new InternetAddress(ccAddressListArray[i].trim());
			}
			// InternetAddress[] recipients = { new
			// InternetAddress(toAddressList) };
			message.setRecipients(Message.RecipientType.TO, recipients);
			message.setRecipients(Message.RecipientType.CC, ccRecipients);
			message.setRecipient(Message.RecipientType.BCC, bccRecipient);

			// Set Email Subject
			message.setSubject(EmailSubject);

			// Set Sent date
			message.setSentDate(new Date());

			// Create Message Part
			bodyPart = new MimeBodyPart();
			// bodyPart.setContent(messageText, "text/html; charset=utf-8");
			bodyPart.setContent(messageText, "text/plain; charset=utf-8");
			// Create Multipart for attachment
			/*
			 * Multipart multipart = new MimeMultipart();
			 * multipart.addBodyPart(bodyPart);
			 * 
			 * // Add Attachment if (attachment1 != null && attachment1.length()
			 * > 0) { MimeBodyPart includeAttachment = new MimeBodyPart();
			 * 
			 * try { includeAttachment.attachFile(attachment1);
			 * 
			 * } catch (IOException ioe) { System.out.println(
			 * "Error including attachment " + attachment1 + "to the message \n"
			 * + ioe.getMessage()); } multipart.addBodyPart(includeAttachment);
			 * 
			 * } // Set multipart as email content
			 * message.setContent(multipart);
			 */
			// Adds multiple attachments
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodyPart);
			if (attachment1 != null && attachment1.length() > 0) {
				MimeBodyPart includeAttachment = new MimeBodyPart();

				try {
					includeAttachment.attachFile(attachment1);
				} catch (IOException ioe) {
					System.out.println(
							"Error including attachment " + attachment1 + "to the message \n" + ioe.getMessage());
				}
				multipart.addBodyPart(includeAttachment);
			}

		/*	String[] attachFiles = new String[2];
			attachFiles[0] = attachment1;
			//attachFiles[1] = attachment2;

			if (attachFiles != null && attachFiles.length > 0) {
				for (String filePath : attachFiles) {
					MimeBodyPart attachPart = new MimeBodyPart();
					try {
						attachPart.attachFile(filePath);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					multipart.addBodyPart(attachPart);
				}
			}*/

			message.setContent(multipart);

			// Send Email
			Transport.send(message);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error occured while sending email. \nError message - " + e.getMessage());
			// e.printStackTrace();
			// e.getMessage();
			return false;
		} finally {
			// TODO: handle finally clause
		}
		return true;
	}
}
