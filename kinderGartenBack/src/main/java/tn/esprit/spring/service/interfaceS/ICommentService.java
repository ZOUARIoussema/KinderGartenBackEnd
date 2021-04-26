package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Comment;

public interface ICommentService {
	public void addComment (Comment comment);
	public void deleteComment(int commentId);
	public void updateComment(Comment c );
	public List<Comment> getAllComment();
	

}
