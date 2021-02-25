package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.KinderGarten;
@Repository
public interface IKinderGartenRepository extends CrudRepository<KinderGarten, Integer>  {

}
