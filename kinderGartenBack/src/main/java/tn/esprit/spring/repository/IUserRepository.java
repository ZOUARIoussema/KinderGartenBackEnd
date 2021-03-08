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
	@Query(value = "select * from user u right  "
			+ "join (select   parent_id , count( parent_id) AS  \"number_comments\" from comment group by parent_id )  AS c ON u.id = c.parent_id right  "
			+ "join (select   parent_id , count( parent_id) AS  \"number_publications\" from publication"
			+ " group by parent_id ) AS p ON p.parent_id = c.parent_id where u.kinder_garten_inscription_id = ?1"
			+ " order by ( c.number_comments + p.number_publications) DESC LIMIT 5", nativeQuery = true)
	public List<User> listDelegators(int kindergartenId);
	
	@Query(value = " select * from user  u where  u.score_delegate = ( select Max( score_delegate) from user ) and u.kinder_garten_inscription_id = ?1", nativeQuery = true)
	public User delegatorsElection(int kindergartenId);
	
	@Query(value = " select * from user  u where  u.kinder_garten_inscription_id = ?1 LIMIT 1", nativeQuery = true)
	public User Votes(int kindergartenId);
}
