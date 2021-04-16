package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.User;

public interface IUserService {

	public void add(User u);

	public List<User> getAll();

	public void initialize();

	public void delete(int id);

	public void update(User u);

	public void changePassWord(int id, String pwd);

	public User findByEmail(String email);

	public void ChangeStateUser(int id);
	
	public void blockAccount(int id);
	
	public void confirmerInscriptionParMail (User u);
	
	public String RegisterKinderGarten(int iduser, int  id_kg);
	
	public void sendMailAlertToResponsibleKinderGarten(int id);
	
	public User finduserbyid(int id);
	
	

}
