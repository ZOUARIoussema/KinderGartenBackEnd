package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;

@Repository
public interface IStatisticsRepository extends CrudRepository<User, Integer>{

	@Query("select  c.parent.kinderGartenInscription.name, count (*) from Child c group by c.parent.kinderGartenInscription")  
    public List<?> listChildByKinderGarten();
	
	
	@Query(value="SELECT count(*) FROM comment c where c.parent_id =:userid ",nativeQuery=true)  
    public int NbrCommentsByUser (@Param ("userid") int userid);
	
	@Query("SELECT p.numberLike,p.parent.firstName,p.parent.lastName from  Publication p group by p.parent.kinderGartenInscription")  
	
	public List<?> NbrLikeByUser ();
	
	@Query("SELECT count(*),p.parent.firstName,p.parent.lastName FROM Publication p group by p.parent.kinderGartenInscription ")  
    public List<?> nbrPublicationByUser();
	
	
	@Query("SELECT e.nParticipate,e.description,e.category.kinderGarten.name from Event e group by e.category.kinderGarten")  
    public List<?> numberParticipEventKinderGaten ();
	
	

	//@Query("select count (*) from SubscriptionChild sc where YEAR(e.dateC)=2021 and sc.child.parent.kinderGartenInscription.id =:jardinid")
   // public int NbrChildSubscribed2021(@Param ("jardinid") int jardinid);
	
}
