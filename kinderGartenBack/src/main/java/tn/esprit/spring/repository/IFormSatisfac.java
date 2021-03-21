package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.formSatisfac;

@Repository
public interface IFormSatisfac extends CrudRepository<formSatisfac, Integer>{

	
	
}
