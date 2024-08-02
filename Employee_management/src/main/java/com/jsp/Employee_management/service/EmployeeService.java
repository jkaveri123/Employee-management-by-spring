package com.jsp.Employee_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.Employee_management.Entity.EmployeeDetails;
import com.jsp.Employee_management.dao.EmployeeDao;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;



@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	
	@Autowired
	JavaMailSender mailsender;

	public EmployeeDetails SaveEmployee(EmployeeDetails e) {
		EmployeeDetails ea = dao.saveEmployee(e);
		try {
		sendHtmlEmail(e);
		}catch(MessagingException ex){
			ex.printStackTrace();
		}
		return ea ;
	}
	
	
	public void sendHtmlEmail(EmployeeDetails emp) throws MessagingException {
	    MimeMessage message = mailsender.createMimeMessage();

	    message.setFrom(new InternetAddress("jkaveridvk123@gmail.com"));
	    message.setRecipients(MimeMessage.RecipientType.TO, emp.getEmail());
	    message.setSubject("Test email from Spring");

	    String htmlContent = "<h1>Hi " +emp.getName()+",</h1>"+
               
                "We have received your application and appreciate the time you took to apply. " +
                "Our team will review your qualifications and get back to you if your profile matches our needs. " +
                "Thank you once again for considering a career with us. We encourage you to visit our <a href=\"[Careers Page URL]\">careers page</a> for future opportunities.</p>" 
               ;

	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    mailsender.send(message);
	}
	
	

}
