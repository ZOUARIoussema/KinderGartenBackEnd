package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Activity;
@Repository
public interface IActivityRepository extends CrudRepository<Activity, Integer>  {

}
