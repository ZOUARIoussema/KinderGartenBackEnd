package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.CategorySubscription;


@Repository
public interface ICategorySubscriptionRepository extends CrudRepository<CategorySubscription, Integer>  {

	@Modifying
	@Transactional
	@Query("update CategorySubscription e set e.description = :description ,e.price = :price  where e.id = :categorySubscriptionId")
	public void updateupdateCategorySubscriptionJPQL(@Param("description") String description,@Param("price") double price,@Param("categorySubscriptionId") int categorySubscriptionId);
}