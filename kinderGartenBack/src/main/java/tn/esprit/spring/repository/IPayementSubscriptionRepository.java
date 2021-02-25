package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.PayementSubscription;
@Repository
public interface IPayementSubscriptionRepository extends CrudRepository<PayementSubscription, Integer>  {

}
