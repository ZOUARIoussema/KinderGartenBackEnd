package tn.esprit.spring.service.interfaceS;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import tn.esprit.spring.entity.Child;

public interface IChildService {
	
	public void addChild(Child child);
	public List<Child> getAllChild();
	public void updateChild(Child child);
	public void assignPictureToChild(int id , MultipartFile file);
	

}
