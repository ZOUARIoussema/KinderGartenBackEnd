package tn.esprit.spring.repository;

import java.util.List;

import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {

	// @Query(value="select u.first_name,u.las_name,u.email,u.address,u.tel from
	// user u where u.role ='ROLE_parent'",nativeQuery=true)
	// public List<User> getParentsByKinderGarten();

	public User findByEmail(String email);

	/*
	 * @Query("select u.id from User u where u.role = ROLE_adminGarten ") public
	 * int findUserByRole();
	 */
	@Query(value = " select u.*,count(*) as nb  from comment c join user u where u.role =UPPER('ROLE_parent') group by c.parent_id order by nb desc limit 5", nativeQuery = true)
	public List<User> FilterParentForDelegate();
	
	@Query(value = " select Max(score_delegate) from user where role =UPPER('ROLE_parent')", nativeQuery = true)
	public int ValidateDelegateJPQL();
}
