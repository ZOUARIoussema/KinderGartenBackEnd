package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

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
	@Query("update Event e set e.description = :description ,e.object = :object,e.date = :date , e.price= :price  where e.id = :eventId")
	public void updateEventJPQL(@Param("object") String object,@Param("description") String description,@Param("date") Date date,@Param("price") double price,@Param("eventId") int eventId);

	@Query(value="select * from event where kinder_garten_id=:kinderId",nativeQuery=true)
	public List<Event> findAllEventByGartenJPQL(@Param("kinderId")int kinderId);
	
	@Query("SELECT e from Event e where e.date = CURRENT_DATE()")
	 public List<Event> getAllEventPourToday();
}
