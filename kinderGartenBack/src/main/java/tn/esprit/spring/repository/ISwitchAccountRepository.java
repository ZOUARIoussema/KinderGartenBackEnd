package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.SwitchAccount;
import tn.esprit.spring.entity.User;
@Repository
public interface ISwitchAccountRepository extends CrudRepository<SwitchAccount, Integer>  {
	//methode jpql en faite cest une jointure entre trois table et reccuperer lz somme des like et dislike pour chaque parents ainsi que son react et le nom du parent
	@Query(value="select u.first_name,sum(number_like),sum(number_dislike), r.react"
			+ " from user u , publication p , reaction r where u.id =p.parent_id and r.id_user=u.id and u.kinder_garten_inscription_id=:kindergartenId"
			+ " group by parent_id,react", nativeQuery = true)
	public List<String> getReactParent(@Param("kindergartenId") int kindergartenId);
	
	

}
