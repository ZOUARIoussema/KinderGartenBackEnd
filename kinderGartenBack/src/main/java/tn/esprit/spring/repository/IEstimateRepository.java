package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Estimate;

@Repository
public interface IEstimateRepository extends CrudRepository<Estimate, Integer> {
	@Query(value = "SELECT * from Estimate where id_kinder=:kinderId and id_user=:ProviderId", nativeQuery = true)
	public List<Estimate> getEstimateByKinderAndProviderJPQL(@Param("kinderId") int kinderId,
			@Param("ProviderId") int ProviderId);

	@Modifying
	@Transactional
	@Query("DELETE from Estimate e where  e.pkEstimate.dateC=:date and e.pkEstimate.idUser=:iduser and e.pkEstimate.idKinder=:idkinder")
	public void deleteRepasJPQL(@Param("date") Date date, @Param("iduser") int iduser, @Param("idkinder") int idkinder);
	
	@Modifying
	@Transactional
	@Query("update Estimate e set e.qte = :qte ,e.item = :item,e.total = :total  where e.pkEstimate.dateC=:date and e.pkEstimate.idUser=:iduser and e.pkEstimate.idKinder=:idkinder")
	public void updateEstimateJPQL(@Param("qte") int qte,@Param("total") double total,@Param("item") String item,@Param("date") Date date, @Param("iduser") int iduser, @Param("idkinder") int idkinder);
	
}
