package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Consultation;
@Repository
public interface IConsultationRepository extends CrudRepository<Consultation, Integer>  {

}
