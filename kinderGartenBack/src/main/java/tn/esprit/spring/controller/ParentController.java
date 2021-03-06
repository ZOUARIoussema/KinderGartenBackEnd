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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.JustificationAbsence;
import tn.esprit.spring.entity.Notice;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.SubscriptionChild;
import tn.esprit.spring.service.interfaceS.IChildService;
import tn.esprit.spring.service.interfaceS.ICommentService;
import tn.esprit.spring.service.interfaceS.IJustificationAbsenceService;
import tn.esprit.spring.service.interfaceS.INoticeService;
import tn.esprit.spring.service.interfaceS.IPublicationService;
import tn.esprit.spring.service.interfaceS.ISubscriptionChildService;
import tn.esprit.spring.service.interfaceS.IUploadFileService;

@RestController
@RequestMapping("/parent")
@PreAuthorize("hasRole('ROLE_parent')")
public class ParentController {

	@Autowired
	IPublicationService publicationService;
	@Autowired
	ICommentService commentService;
	@Autowired
	IJustificationAbsenceService justificationService;
	@Autowired
	IChildService childService;
	@Autowired
	INoticeService noticeService;
	@Autowired
	ISubscriptionChildService subscriptionChildService;
	@Autowired
	IUploadFileService uploadFileService;

	/* Publication */

	@PostMapping("/addPublication")
	@ResponseBody
	public void addPublication(@RequestBody Publication publication) {
		publicationService.addPublication(publication);
		
	}

	@DeleteMapping("/deletePublicationById/{idPub}")
	@ResponseBody
	public void deletePublication(@PathVariable("idPub") int publicationId) {
		publicationService.deletePublication(publicationId);
	}

	@PutMapping(value = "/updateDescription")
	
	public void updateDescriptionByPublicationId(@RequestBody Publication p) {
		publicationService.updateDescriptionByPublicationId(p);
	}

	@GetMapping(value = "/getAllPublication")
	@ResponseBody
	public List<Publication> getAllPublication() {

		return publicationService.getAllPublication();
	}

	/* Comment */

	@PostMapping("/addComment")
	@ResponseBody
	public void addComment(@RequestBody Comment comment) {
		commentService.addComment(comment);
	}

	@DeleteMapping("/deleteComment/{idComment}")
	@ResponseBody
	public void deleteComment(@PathVariable("idComment") int commentId) {
		commentService.deleteComment(commentId);
	}

	@PutMapping(value = "/updateComment")
	@ResponseBody
	public void updateComment(@RequestBody Comment c) {
		commentService.updateComment(c);
	}

	/* Add JustificationAbsence */

	@PostMapping("/addJustification")
	@ResponseBody
	public void addJustificationAbsence(@RequestBody JustificationAbsence justificationAbsence) {
		justificationService.addJustification(justificationAbsence);
		
	}

	/* Child */
	@PostMapping("/addChild")
	@ResponseBody
	public Child addChild(@RequestBody Child child) {
		childService.addChild(child);
		return child;
	}
	@PostMapping("/addPictureToChild/{id}")
	public void addPictureToChild(@PathVariable("id") int id , @RequestParam("file") MultipartFile file){
		if(uploadFileService.addFile(file)){
			childService.assignPictureToChild(id, file);
		}
		
	}

	@GetMapping(value = "/getAllChild")
	@ResponseBody
	public List<Child> getAllChild() {

		return childService.getAllChild();
	}

	/* Notice */
	@GetMapping(value = "/getAllNotice")
	@ResponseBody
	public List<Notice> getAllNotices() {
		return noticeService.getAllNotices();
	}

	@DeleteMapping("/deleteNotice/{idNotice}")
	@ResponseBody
	public void deletNoticeById(@PathVariable("idNotice") int noticeId) {
		noticeService.deletNoticeById(noticeId);
	}

	@GetMapping(value = "/GetNoticesByScore")

	public List<Notice> getAllNoticesByScore() {

		return noticeService.getAllNoticesByScore();
	}

	/***
	 * 
	 * 
	 * Crud subscription child
	 */

	@PostMapping("/addSubscriptionChild")
	@ResponseBody
	public void add(@RequestBody SubscriptionChild s) {

		subscriptionChildService.addSubscriptionChild(s);

	}

	@DeleteMapping("/deleteSubscriptionChild/{id}")
	@ResponseBody
	public void delete(@PathVariable int id) {
		subscriptionChildService.delete(id);
	}

	@GetMapping("/getListSubscriptionByChild/{id}")
	@ResponseBody
	public List<SubscriptionChild> getListSubscriptionByChild(@PathVariable int id) {

		return subscriptionChildService.getAllSubscriptionByChild(id);
	}

	@PutMapping("/updateSubscription")
	public void updateSubscriptionChild(@RequestBody SubscriptionChild s) {

		subscriptionChildService.update(s);

	}

}
