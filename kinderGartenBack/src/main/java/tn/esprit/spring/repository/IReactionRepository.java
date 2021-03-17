package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reaction;
@Repository

public interface IReactionRepository extends CrudRepository<Reaction, Integer> {
	@Query("select p  from Reaction p  where ( p.user.id=: idUser and p.publication.id=: idPublication)")
	 public Reaction reactionExist(@Param("idUser") Long idUser,@Param("idPublication") Long idPublication);

}
