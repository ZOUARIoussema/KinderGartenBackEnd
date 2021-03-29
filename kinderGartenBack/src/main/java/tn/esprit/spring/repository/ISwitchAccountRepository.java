package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.SwitchAccount;
import tn.esprit.spring.entity.User;
@Repository
public interface ISwitchAccountRepository extends CrudRepository<SwitchAccount, Integer>  {
	

}
