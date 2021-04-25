package tn.esprit.spring.config.webSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IMyMessageRep;
import tn.esprit.spring.repository.IUserRepository;

@CrossOrigin
@Controller
public class SocketController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	private IMyMessageRep mR;

	@Autowired
	private IUserRepository userR;


	@MessageMapping("/personalMsg")
	public void greeting(MyMessage msg) {
		
		 
		
		String sender = msg.getFrom();
		String content = msg.getContent();
		String receiver = msg.getTo();

		User senderU = userR.findByEmail(sender);

		User senderR = userR.findByEmail(receiver);

		Message newMessage = new Message(senderU, senderR, msg.getContent());

		mR.save(newMessage);

		simpMessagingTemplate.convertAndSend( "/queue/reply/"+receiver, msg);

	}

}