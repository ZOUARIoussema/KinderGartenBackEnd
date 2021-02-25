package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.User;

public interface IUserService {
	
	
	public void add(User u);
	
	public List<User> getAll();
	
	public void initialize();
	
	
	public User findByEmail(String email);
	
	
	

}
