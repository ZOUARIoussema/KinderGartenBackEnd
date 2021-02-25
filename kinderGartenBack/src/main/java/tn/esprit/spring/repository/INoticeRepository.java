package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Notice;
@Repository
public interface INoticeRepository extends CrudRepository<Notice, Integer>  {

}
