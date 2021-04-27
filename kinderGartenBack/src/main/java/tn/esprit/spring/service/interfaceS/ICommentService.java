package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;

public interface ICommentService {
	public void addComment (Comment comment);
	public void deleteComment(int commentId);
	public void updateComment(Comment c );
	public List<Comment> getAllComment();
	public Comment getCommentById(int id);

}
