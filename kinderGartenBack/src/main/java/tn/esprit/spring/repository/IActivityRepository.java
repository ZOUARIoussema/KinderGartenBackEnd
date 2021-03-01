package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Activity;

@Repository
public interface IActivityRepository extends CrudRepository<Activity, Integer>  {


	@Modifying
	@Transactional
	@Query("update Activity e set e.description = :description ,e.photo = :photo  where e.id = :activityId")
	public void updateActivityJPQL(@Param("description") String description,@Param("photo") String photo,@Param("activityId") int activityId);

}
