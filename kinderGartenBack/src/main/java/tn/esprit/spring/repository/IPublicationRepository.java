package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Publication;
@Repository
public interface IPublicationRepository extends CrudRepository<Publication, Integer>  {
	
	@Query(value="select * from Publication order by number_like DESC",nativeQuery=true)
	public List<Publication> getAllPublicationByNbrLike();

}
