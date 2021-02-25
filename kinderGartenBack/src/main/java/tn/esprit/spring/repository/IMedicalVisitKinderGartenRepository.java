package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.MedicalVisitKinderGarten;
@Repository
public interface IMedicalVisitKinderGartenRepository extends CrudRepository<MedicalVisitKinderGarten, Integer>  {

}
