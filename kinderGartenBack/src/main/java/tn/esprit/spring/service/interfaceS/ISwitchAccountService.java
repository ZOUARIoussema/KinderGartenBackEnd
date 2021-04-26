package tn.esprit.spring.service.interfaceS;


import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.Statistique;
import tn.esprit.spring.entity.SwitchAccount;
import tn.esprit.spring.entity.User;

public interface ISwitchAccountService {


	public void RequestForSwitchingAccount(SwitchAccount sw);
	
	public int addSwitchAccount(SwitchAccount switchaccount);
	
	public List<KinderGarten> getKinderGartenByAdress(String adress);
	
	
	
//method call of get all kindergarden
	public List<KinderGarten> getAllKinderGarden();
	
	
	//method call of nearestpoint
	public List<KinderGarten> Nearpoint(double lat1, double lon1);
	

	
	//method call of get message from  user and send message to user id
	public List <Message> getmail(int id);
	public void  SendMail(Message message);
	//methode call of get statistique event by kindergarden
	public List<Statistique> getStatistiqueEventBykindergarten(int id);
	//methode call of get all notification
	public List<Notification> getAllNotification();

	

}
