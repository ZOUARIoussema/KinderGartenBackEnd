package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Child;

public interface IChildService {
	
	public int addChild(Child child);
	public List<Child> getAllChild();
	

}
