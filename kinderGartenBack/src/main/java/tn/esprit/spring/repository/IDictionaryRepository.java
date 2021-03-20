package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Dictionary;

@Repository
public interface IDictionaryRepository extends CrudRepository<Dictionary, Long>{

	@Query("select word from Dictionary")
	public List<String> listWordsInDictionary();
}
