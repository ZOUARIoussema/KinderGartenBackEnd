package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.User;

public interface IUserService {
	
	
	public void add(User u);
	
	public List<User> getAll();
	
	public void initialize();
	
	public void delete(int id);
	
	public void update(User u);
	
	public void changePassWord(int id,String pwd);
	
	
	
	
	
	public User findByEmail(String email);
	
	public List<User> getParentsByKinderGartens();
	
	public void ChangeStateUser(User u);
	
	
	
	

}
