package tn.esprit.spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.esprit.spring.service.interfaceS.IMailService;

@Service
public class MailServiceImpl implements IMailService {

	@Autowired
	public JavaMailSender emailSender;

	@Override
	public void sendSimpleMail(String destination, String subject, String text) {

		// Create a Simple MailMessage.
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(destination);
		message.setSubject(subject);
		message.setText(text);

		// Send Message!
		this.emailSender.send(message);

	}

}
