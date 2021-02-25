package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.CategorySubscription;


@Repository
public interface ICategorySubscriptionRepository extends CrudRepository<CategorySubscription, Integer>  {

}
