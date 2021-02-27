package tn.esprit.spring.repository;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 99bf506d3e5cf36fdfc6f122a87288ec94174114
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.User;
@Repository
public interface IUserRepository extends CrudRepository<User, Integer>  {
	
	
	@Query(value="select * from user u,KinderGarten kg where u.role=ROLE_parent and u.id = kg.responsible_id",nativeQuery=true)
	public List<User> getParentsByKinderGarten();
	
	public User  findByEmail(String email);
/*
	@Query("select u.id from User u where u.role = ROLE_adminGarten ")
	public int findUserByRole();
	*/
}
