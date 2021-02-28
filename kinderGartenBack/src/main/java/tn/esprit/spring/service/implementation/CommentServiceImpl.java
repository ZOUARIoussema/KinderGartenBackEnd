package tn.esprit.spring.service.implementation;

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
	public int addComment(Comment comment) {
		commentRepository.save(comment);
		return comment.getId();
	}

	@Override
	public void deleteComment(int commentId) {
		commentRepository.deleteById(commentId);
		
	}

	@Override
	public void updateComment(String description, int commentId) {
		Comment comment = commentRepository.findById(commentId).get();
		comment.setDescription(description);
		commentRepository.save(comment);
		
	}

}
