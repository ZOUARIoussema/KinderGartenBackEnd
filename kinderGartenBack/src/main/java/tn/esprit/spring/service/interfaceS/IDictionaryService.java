package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Dictionary;



public interface IDictionaryService {

	public void addWord (Dictionary dictionary);
	public List<Dictionary> getAll();
	public List<?> listWordsDic();

}
