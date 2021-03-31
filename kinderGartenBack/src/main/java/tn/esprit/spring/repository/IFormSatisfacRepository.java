package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.formSatisfac;

@Repository
public interface IFormSatisfacRepository extends CrudRepository<formSatisfac, Integer>{

	
	@Query("SELECT fs.nbr_reponses from formSatisfac fs where fs.ParentStatisfac.id=:iduser")
	public int getNombreReponsesUser (@Param("iduser") int iduser);
	
}
