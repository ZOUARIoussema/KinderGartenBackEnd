package tn.esprit.spring.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Club;
@Repository
public interface IClubRepository extends CrudRepository<Club, Integer>  {
	@Modifying
	@Transactional
	@Query("update Club e set e.description = :description  where e.id = :clubId")
	public void updateClubJPQL(@Param("description") String description,@Param("clubId") int clubId);

}
