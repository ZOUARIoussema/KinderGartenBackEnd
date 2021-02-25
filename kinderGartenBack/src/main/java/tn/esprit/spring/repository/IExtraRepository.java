package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Extra;
@Repository
public interface IExtraRepository extends CrudRepository<Extra, Integer>  {

}
