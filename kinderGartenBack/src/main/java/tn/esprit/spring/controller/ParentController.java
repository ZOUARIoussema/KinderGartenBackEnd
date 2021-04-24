package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

import tn.esprit.spring.entity.CategorySubscription;
import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Dictionary;
import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.JustificationAbsence;
import tn.esprit.spring.entity.Notice;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.Reaction;
import tn.esprit.spring.entity.ReactionPK;
import tn.esprit.spring.entity.SubscriptionChild;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.interfaceS.ICategorySubscriptionService;
import tn.esprit.spring.service.interfaceS.IChildService;
import tn.esprit.spring.service.interfaceS.IClaimService;
import tn.esprit.spring.service.interfaceS.ICommentService;
import tn.esprit.spring.service.interfaceS.IDictionaryService;
import tn.esprit.spring.service.interfaceS.IExtraService;
import tn.esprit.spring.service.interfaceS.IJustificationAbsenceService;
import tn.esprit.spring.service.interfaceS.INoticeService;
import tn.esprit.spring.service.interfaceS.IPublicationService;
import tn.esprit.spring.service.interfaceS.IReactionService;
import tn.esprit.spring.service.interfaceS.ISubscriptionChildService;
import tn.esprit.spring.service.interfaceS.IUploadFileService;
import tn.esprit.spring.service.interfaceS.IUserService;

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
	@Autowired
	IReactionService reactionService;
	@Autowired
	IDictionaryService dictionaryService;
	@Autowired
	IClaimService claimService;
	@Autowired
	IUserService userS;
	@Autowired
	IExtraService iExtraService;
	@Autowired
	ICategorySubscriptionService iCategorySubscriptionService;

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
		publicationService.update(p);
	}

	@GetMapping(value = "/getAllPublication")
	@ResponseBody
	public List<Publication> getAllPublication() {

		return publicationService.getAllPublication();
	}

	@GetMapping(value = "/getAllPublicationDesc")
	@ResponseBody
	public List<Publication> getAllPublicationDESC() {

		return publicationService.getPublicationDesc();
	}
	
	@GetMapping(value ="/getPublicationById/{id}")
	@ResponseBody
	public Publication getPublicationByid(@PathVariable int id) {

		return publicationService.getPublicationById(id);
	}


	@PostMapping("/assignAttachementToPost/{id}")
	public void assignAttachementToPost(@PathVariable("id") int id, @RequestParam("file") MultipartFile file) {
		if (uploadFileService.addFile(file)) {
			publicationService.assignAttachementToPost(id, file);
		}
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
	public void addPictureToChild(@PathVariable("id") int id, @RequestParam("file") MultipartFile file) {
		if (uploadFileService.addFile(file)) {
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

		/**
		 * 
		 * total extra
		 */

		/*double totalExtrat = 0;

		if (s.getLisExtras().size() != 0) {

			for (Extra e : s.getLisExtras()) {
				totalExtrat = totalExtrat + e.getPrice();
			}
		}

		s.setTotal(s.getCategorySubscription().getPrice() + totalExtrat);
		s.setRestPay(s.getCategorySubscription().getPrice() + totalExtrat);
		s.setTotalPay(0);
		s.setDateC(new Date());*/

		subscriptionChildService.addSubscriptionChild(s);

	}
	
	@GetMapping(value ="/getSubscriptionById/{id}")
	@ResponseBody
	public SubscriptionChild getSubscriptionByid(@PathVariable int id) {

		return subscriptionChildService.getById(id);
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

	@PostMapping("/addReact/{idu}/{idp}")
	@ResponseBody
	public void addReact(@RequestBody Reaction react, @PathVariable("idu") int idu, @PathVariable("idp") int idp) {

		ReactionPK r = new ReactionPK();

		r.setIdUser(idu);
		r.setIdPublication(idp);

		react.setLikePk(r);
		react.setDate(new Date());

		reactionService.addReaction(react);
	}

	@GetMapping(value = "/getAllReact")
	@ResponseBody
	public List<Reaction> getReaction() {
		return reactionService.retrieveAllLike();
	}

	/***
	 * 
	 * 
	 * Crud Dictionray bad words
	 */
	@PostMapping("/addword")
	@ResponseBody
	public void addWord(@RequestBody Dictionary dictionary) {
		dictionaryService.addWord(dictionary);

	}

	@GetMapping(value = "/getAllWords")
	public List<Dictionary> getAll() {
		return dictionaryService.getAll();
	}

	@GetMapping(value = "/getWordsInDisc")
	public List<?> getWords() {
		return dictionaryService.listWordsDic();
	}

	/*
	 * add event to child
	 *
	 */

	@PutMapping("/addEventChild")
	@ResponseBody
	public void addEvent(@RequestBody Child c) {

		/**
		 * 
		 * add fidelity point
		 * 
		 * ++ 50 point in event
		 */

		c.setFidelityPoint(c.getFidelityPoint() + 50);

		childService.updateChild(c);

		/**
		 * add total to current subscription child
		 */

		subscriptionChildService.updateTotalWithParticipateEvent(c);

	}

	@PostMapping("/addClaim/{id}")
	@ResponseBody
	public String addClaim(@RequestBody Claim c, @PathVariable("id") int iduser) {
		return "claim added successfully with id : " + claimService.addClaim(c, iduser);
	}

	@PutMapping("/RegisterKinderGarten/{id_kg}/{id_user}")
	@ResponseBody

	public String RegisterKinderGarten(@PathVariable("id_user") int iduser, @PathVariable("id_kg") int id_kg)

	{
		return userS.RegisterKinderGarten(iduser, id_kg);
	}
	
	@GetMapping(value = "/getAllextra")
	@ResponseBody
	public List<Extra> getAllextra() {

		return iExtraService.getAllextra();
	}
	
	@GetMapping(value = "/getExtraById/{extraId}")
	@ResponseBody
	public Extra getExtraById(@PathVariable("extraId") int extraId) {
		return iExtraService.getExtraById(extraId);
	}

	
	@GetMapping(value = "/getCategorySubscriptionById/{categorySubscriptionId}")
	@ResponseBody
	public CategorySubscription getCategorySubscriptionById(
			@PathVariable("categorySubscriptionId") int categorySubscriptionId) {
		return iCategorySubscriptionService.getCategorySubscriptionById(categorySubscriptionId);
	}

	@GetMapping(value = "/getAllCategorySubscription")
	@ResponseBody
	public List<CategorySubscription> getAllCategorySubscription() {

		return iCategorySubscriptionService.getAllCategorySubscription();
	}
	@PutMapping("/addLike/{id}")
	@ResponseBody
	public int addLike(@PathVariable("id") int id)
	{
		return publicationService.addLike(id);
		
	}
	
	@PutMapping("/addDisLike/{id}")
	@ResponseBody
	public int addDisLike(@PathVariable("id") int id)
	{
		return publicationService.addDisLike(id);
		
	}
	
	

}
