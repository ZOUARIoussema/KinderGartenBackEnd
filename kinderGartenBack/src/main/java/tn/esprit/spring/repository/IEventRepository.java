package tn.esprit.spring.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Event;
@Repository
public interface IEventRepository extends CrudRepository<Event, Integer>  {

	@Modifying
	@Transactional
	@Query("update Event e set e.description = :description ,e.date = :date  where e.id = :eventId")
	public void updateEventJPQL(@Param("description") String description,@Param("date") Date date,@Param("eventId") int eventId);

}
