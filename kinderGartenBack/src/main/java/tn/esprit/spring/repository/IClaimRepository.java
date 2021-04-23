package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.User;
@Repository
public interface IClaimRepository extends CrudRepository<Claim, Integer>  {
	
	@Query(value="select * from claim c where c.parent_id=:iduser",nativeQuery=true)
	public List<Claim> getClaimsByUser(@Param("iduser") int iduser);
	
	
	@Query(value="select * from claim c where c.type=:type",nativeQuery=true)
	public List<Claim> searchClaimByType(@Param("type") String type);
	
	
	@Query(value="select count(*) from claim c, user u where (u.role='ROLE_parent') and (c.parent_id=u.id) and (u.kinder_garten_inscription_id= :idkinder)",nativeQuery=true)

	public int countNbrClaimsKindergarten(@Param("idkinder") int kg);
	
	@Query("SELECT  DISTINCT c.parent.firstName,c.parent.lastName FROM Claim c")
	public List<String> getAllParents ();
	
	@Query(value="select * from claim where object LIKE '%URGENT%' ",nativeQuery=true)
	public List<Claim> getClaimsByObject();
	
	
}

