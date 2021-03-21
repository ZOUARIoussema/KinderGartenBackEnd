package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Estimate;

@Repository
public interface IEstimateRepository extends CrudRepository<Estimate ,Integer>{

}
