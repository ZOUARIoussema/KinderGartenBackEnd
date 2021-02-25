package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Meeting;
@Repository
public interface IMeetingRepository extends CrudRepository<Meeting, Integer>  {

}
