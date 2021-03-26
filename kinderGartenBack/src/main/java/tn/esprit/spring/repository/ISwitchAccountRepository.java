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
	@Query("select r.react ,u.id "
			+ "from user u ,reaction r "
			+ "where u.id=r.id_user " )
	public List<String> getReactParent(@Param("kindergartenId") int kindergartenId);
//method getnumbereventbycategory for each kindergarden
@Query("select count(e.id),c.id from event e , category c  where e.kinder_garten_id=kinder_garten_id and e.category_id=c.idgroup by (c.id)")
public List<Integer> getNumbereventbycategory(@Param("kindergartenId") int kindergartenId);



}
