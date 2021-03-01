package tn.esprit.spring.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Meeting;
@Repository
public interface IMeetingRepository extends CrudRepository<Meeting, Integer>  {

	@Modifying
	@Transactional
	@Query("update Meeting e set e.dateStart = :dateStart ,e.dateEnd = :dateEnd  where e.id = :meetingId")
	public void updateMeetingJPQL(@Param("dateStart") Date dateStart,@Param("dateEnd") Date dateEnd,@Param("meetingId") int meetingId);

}
