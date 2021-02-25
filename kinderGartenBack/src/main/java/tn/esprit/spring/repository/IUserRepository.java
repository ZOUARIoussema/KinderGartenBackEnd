package tn.esprit.spring.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;
@Repository
public interface IUserRepository extends CrudRepository<User, Integer>  {
	
	
	
	public User  findByEmail(String email);

}
