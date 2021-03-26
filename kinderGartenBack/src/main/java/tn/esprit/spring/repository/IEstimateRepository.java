package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Estimate;

@Repository
public interface IEstimateRepository extends CrudRepository<Estimate ,Integer>{
	@Query(value="SELECT * from Estimate where id_kinder=:kinderId and id_user=:ProviderId",nativeQuery=true)
	 public List<Estimate> getEstimateByKinderAndProviderJPQL(@Param("kinderId") int kinderId,@Param("ProviderId") int ProviderId);
}
