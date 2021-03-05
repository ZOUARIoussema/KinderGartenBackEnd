package tn.esprit.spring.service.implementation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.repository.ICommentRepository;
import tn.esprit.spring.service.interfaceS.ICommentService;
@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	ICommentRepository commentRepository;
	
	@Override
	public void addComment(Comment comment) {
		comment.setDate(new Date());
		commentRepository.save(comment);
	}

	@Override
	public void deleteComment(int commentId) {
		commentRepository.deleteById(commentId);
		
	}

	@Override
	public void updateComment(Comment c) {
		
		commentRepository.save(c);
		
	}

}
