package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.entity.Notification;
@Repository
public interface INotification extends CrudRepository<Notification, Integer> {
	
@Query(value="select * from notification",nativeQuery=true)
public List<Notification> getAllNotification();
}
