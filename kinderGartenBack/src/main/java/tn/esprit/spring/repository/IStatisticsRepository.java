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
	
	@Query("SELECT numberLike FROM Publication p where p.parent.id =:userid ")  
	
	public int NbrLikeByUser (@Param ("userid") int userid);
	
	@Query("SELECT count(*) FROM Publication p where p.parent.id =:userid ")  
    public int nbrPublicationByUser(@Param ("userid") int userid);
	
	
	//@Query(value="SELECT count(*) FROM event e,kinder_garten kg,user u where (e.kinder_garten_id=kg.id) and (kg.id=u.kinder_garten_inscription_id) and(u.id=:userid) ")  
   // public int nbrParticpEventByUser (@Param ("userid") int userid);
	
	

	
	@Query("SELECT count(*) FROM Child c where c.parent.kinderGartenInscription.id =:kgid ")  
	public int nbrChildByKinderGarten(@Param ("kgid") int kgid);
	
	//@Query("select count (*) from SubscriptionChild sc where YEAR(e.dateC)=2021 and sc.child.parent.kinderGartenInscription.id =:jardinid")
   // public int NbrChildSubscribed2021(@Param ("jardinid") int jardinid);
	
}
