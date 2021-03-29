package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entity.Message;
@Repository
public interface IMyMessageRep extends CrudRepository<Message, Long> {
	

	@Query(value="select * from messages where to_user_id=:id",nativeQuery=true)
	public List<Message> getmail(@Param("id")int id);
	
    @Modifying
    @Transactional
	@Query(value="insert into messages(content,date,from_user_id,to_user_id)values(:content,:from_user_id,:to_user_id)",nativeQuery=true)
	public void  SendMail(@Param("content")String content, @Param("from_user_id") int from_user_id,@Param("to_user_id") int to_user_id);
	
	
}


