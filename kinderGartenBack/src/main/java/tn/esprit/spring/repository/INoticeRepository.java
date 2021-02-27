package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Notice;
@Repository
public interface INoticeRepository extends CrudRepository<Notice, Integer>  {
	/*
	@Query("select * from notice n where n.score=:score")
	public List<Notice> getNoticesByScore(@Param("score") Notice notice );
	*/
}
