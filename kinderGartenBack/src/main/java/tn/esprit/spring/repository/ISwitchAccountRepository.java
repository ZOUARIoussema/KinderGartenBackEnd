package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.SwitchAccount;
@Repository
public interface ISwitchAccountRepository extends CrudRepository<SwitchAccount, Integer>  {
	@Query(value="select * from kinder_garten k where k.adress=:adress", nativeQuery=true)
	public List<KinderGarten> getKinderByAdress(@Param("adress") String adress);
	
	

}
