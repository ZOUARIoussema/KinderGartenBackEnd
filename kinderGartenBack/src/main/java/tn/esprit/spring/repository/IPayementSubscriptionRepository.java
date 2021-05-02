package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.PayementSubscription;
@Repository
public interface IPayementSubscriptionRepository extends CrudRepository<PayementSubscription, Integer>  {

	
	public List<PayementSubscription>findByDateC(Date d);
	
	@Query("select p from PayementSubscription p where (p.subscriptionChild.id = :id)")
	public List<PayementSubscription>findBySubscription(@Param("id")int id);
}
