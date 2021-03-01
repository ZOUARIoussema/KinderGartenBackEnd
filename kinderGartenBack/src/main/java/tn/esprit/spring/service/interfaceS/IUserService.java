package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.User;

public interface IUserService {
	
	
	public void add(User u);
	
	public List<User> getAll();
	
	public void initialize();
	
	public void delete(int id);
	
	public void update(User u);
	
<<<<<<< HEAD

=======
	public void changePassWord(int id,String pwd);
	
	
	
	
	
>>>>>>> 2dae691cbac7ddc556778d8bc9574087c6d6ed3b
	public User findByEmail(String email);
	
	public void ChangeStateUser(User u);
	
	
	
	

}
