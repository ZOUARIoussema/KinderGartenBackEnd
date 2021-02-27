package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.KinderGarten;
@Repository
public interface IKinderGartenRepository extends CrudRepository<KinderGarten, Integer>  {

	@Modifying
	@Transactional
	@Query("update KinderGarten e set e.name = :name ,e.adress = :adress,e.email = :email,e.tel = :tel,e.logo = :logo  where e.id = :kinderId")
	public void updateKindergartenJPQL(@Param("name") String name,@Param("adress") String adress
			,@Param("email") String email,@Param("tel") int tel,@Param("logo") String logo,@Param("kinderId") int kinderId);
}
