package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Publication;
@Repository
public interface IPublicationRepository extends CrudRepository<Publication, Integer>  {
	
	/*@Query("select count () form Publication p where p.publication.id =:id ")
	public int nbLike (@Param("id") int id);*/

}
