package tn.esprit.spring.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Dictionary;
import tn.esprit.spring.repository.IDictionaryRepository;
import tn.esprit.spring.service.interfaceS.IDictionaryService;

@Service
public class DictionaryServiceImpl  implements IDictionaryService{
	@Autowired
	IDictionaryRepository dictionaryRepository;
	
	@Override
	public List<Dictionary> getAll() {
		return (List<Dictionary>) dictionaryRepository.findAll();
	}
	@Override
	public void addWord(Dictionary dictionary) {
		dictionaryRepository.save(dictionary);
		
	}
	
	@Override
	public List<?> listWordsDic() {
		return dictionaryRepository.listWordsInDictionary();
	}

}
