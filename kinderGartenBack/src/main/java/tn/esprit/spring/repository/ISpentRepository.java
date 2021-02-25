package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Spent;
@Repository
public interface ISpentRepository extends CrudRepository<Spent, Integer>  {

}
