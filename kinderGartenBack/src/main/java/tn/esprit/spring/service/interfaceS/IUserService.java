package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.User;

public interface IUserService {

	public void add(User u);

	public List<User> getAll();

	public void initialize();

	public void delete(int id);

	public void update(User u);

	public void changePassWord(int id, String pwd);

	public User findByEmail(String email);

	public void ChangeStateUser(User u);
<<<<<<< HEAD

	// ahmed
	public List<User> FilterParentForDelegate();

	public void delegate(User u);
=======
	
	public void confirmerInscriptionParMail (User u);
	
>>>>>>> 65b57c65de6fab3ebb63a318f22529cb0cf8b2fc
	

}
