package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Claim;
@Repository
public interface IClaimRepository extends CrudRepository<Claim, Integer>  {
	
	@Query(value="select c from Claim where c.type=:type",nativeQuery=true)
	public Claim searchClaimByType(@Param("type") String type);
}
