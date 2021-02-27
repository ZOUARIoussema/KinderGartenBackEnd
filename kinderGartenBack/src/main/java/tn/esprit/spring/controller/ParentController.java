package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.service.interfaceS.ICommentService;
import tn.esprit.spring.service.interfaceS.IPublicationService;

@RestController
@RequestMapping("/parent")
@PreAuthorize("hasRole('ROLE_parent')")
public class ParentController {
	@Autowired
	IPublicationService publicationService;
	@Autowired
	ICommentService commentService;
	
	/*Publication*/
	
	@PostMapping("/addPublication")
	@ResponseBody
	public Publication addPublication(@RequestBody Publication publication){
		publicationService.addPublication(publication);
		return publication;
	}
	
	@DeleteMapping("/deletePublicationById/{idPub}")
	@ResponseBody
	public void deletePublication (@PathVariable("idPub") int publicationId){
		publicationService.deletePublication(publicationId);
	}
	
	
	@PutMapping(value="/updateDescription/{id}/{newDescription}")
	@ResponseBody
	public void updateDescriptionByPublicationId(@PathVariable("newDescription") String description , @PathVariable("id") int publicationId){
		publicationService.updateDescriptionByPublicationId(description, publicationId);
	}
	
	
	@GetMapping(value = "/getAllPublication")
    @ResponseBody
	public List<Publication> getAllPublication() {
		
		return publicationService.getAllPublication();
	}
	
	/*Comment*/
	
	@PostMapping("/addComment")
	@ResponseBody
	public Comment addComment(@RequestBody Comment comment){
		commentService.addComment(comment);
		return comment;
	}
	
	@DeleteMapping("/deleteComment/{idComment}")
	@ResponseBody
	public void deleteComment (@PathVariable("idComment") int commentId){
		commentService.deleteComment(commentId);
	}
	
	
	@PutMapping(value="/updateComment/{id}/{newDescription}")
	@ResponseBody
	public void updateComment(@PathVariable("newDescription") String description , @PathVariable("id") int commentId){
		commentService.updateComment(description, commentId);
	}
	
	
	
	
	
}
