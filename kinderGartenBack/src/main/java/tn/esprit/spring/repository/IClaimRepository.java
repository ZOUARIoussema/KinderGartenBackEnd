package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entity.Claim;
@Repository
public interface IClaimRepository extends CrudRepository<Claim, Integer>  {
	
	@Query(value="select c from Claim where c.type=:type",nativeQuery=true)
	public Claim searchClaimByType(@Param("type") String type);
	
	
	@Query(value="select count(*) from claim c, user u where (u.role='ROLE_parent') and (c.parent_id=u.id) and (u.kinder_garten_inscription_id= :idkinder)",nativeQuery=true)

	public int countNbrClaimsKindergarten(@Param("idkinder") int kg);

}

