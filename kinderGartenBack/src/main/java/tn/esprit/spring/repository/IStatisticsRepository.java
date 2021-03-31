package tn.esprit.spring.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;

@Repository
public interface IStatisticsRepository extends CrudRepository<User, Integer>{

	@Query("select  c.parent.kinderGartenInscription.name, count (*) from Child c group by c.parent.kinderGartenInscription")  
    public List<?> listChildByKinderGarten();
	
	
	@Query("SELECT count(*),c.parent.firstName,c.parent.lastName FROM Comment c,User u where (c.parent.id=u.id) group by c.parent.id ")  
    public List<?> NbrCommentsByUser ();
	
	@Query("SELECT p.numberLike,p.parent.firstName,p.parent.lastName from  Publication p group by p.parent.kinderGartenInscription")  
	
	public List<?> NbrLikeByUser ();
	
	@Query("SELECT count(*),p.parent.firstName,p.parent.lastName FROM Publication p group by p.parent.kinderGartenInscription ")  
    public List<?> nbrPublicationByUser();
	
	
	@Query("SELECT e.nParticipate,e.description,e.category.kinderGarten.name from Event e group by e.category.kinderGarten")  
    public List<?> numberParticipEventKinderGaten ();
	
	
	@Query(value="SELECT kg.name,count(*) as numberChildSubscribed from child c,subscription_child s,user u,kinder_garten kg where c.parent_id=u.id and u.kinder_garten_inscription_id=kg.id and YEAR(s.datec)=:year group by kg.id",nativeQuery=true)
	public List<?> NbrChildSubscribed (@Param("year") int year);
	
	
	@Query("SELECT count(*) from Comment c where c.parent.id=:iduser")
	public int countNbrCommentaires(@Param("iduser") int iduser);
	
	@Query("SELECT count(*) from Publication p where p.parent.id=:iduser")
	public int countNbrPublications(@Param("iduser") int iduser);
	
	@Query("SELECT count(p.numberLike) from Publication p where p.parent.id=:iduser")
	public int countNbrLikes(@Param("iduser") int iduser);
	
	
	
	
	
}
