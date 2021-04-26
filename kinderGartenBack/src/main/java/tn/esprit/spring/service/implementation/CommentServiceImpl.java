package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Dictionary;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.repository.ICommentRepository;
import tn.esprit.spring.repository.IDictionaryRepository;
import tn.esprit.spring.service.interfaceS.ICommentService;
@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	ICommentRepository commentRepository;
	@Autowired
	IDictionaryRepository dictionaryRepository;
	
	public boolean verif(Comment c) {

		for (Dictionary d : dictionaryRepository.findAll()) {

			if (d.getWord() != null && c.getDescription() != null && c.getDescription().length()!=0) {

				if (c.getDescription().toLowerCase().contains(d.getWord().toLowerCase())) {
					return false;
				}

			}
		}

		return true;

	}
	
	@Override
	public void addComment(Comment comment) {
		if (this.verif(comment)) {
		comment.setDate(new Date());
		commentRepository.save(comment);
		}
}

	@Override
	public void deleteComment(int commentId) {
		commentRepository.deleteById(commentId);
		
	}

	@Override
	public void updateComment(Comment c) {
		c.setDate(new Date());
		commentRepository.save(c);
		
	}

	@Override
	public List<Comment> getAllComment() {
		return (List<Comment>) commentRepository.findAll();
	}

}
