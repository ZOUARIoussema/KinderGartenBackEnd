package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Notice;
@Repository
public interface INoticeRepository extends CrudRepository<Notice, Integer>  {
	
	@Query(value="select * from notice order by score",nativeQuery=true)
	public List<Notice> getNoticesByScore();

}
