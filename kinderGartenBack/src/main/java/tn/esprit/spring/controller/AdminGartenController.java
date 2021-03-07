package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.CategorySubscription;
import tn.esprit.spring.entity.Club;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.Meeting;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.interfaceS.IActivityService;
import tn.esprit.spring.service.interfaceS.ICategoryService;
import tn.esprit.spring.service.interfaceS.ICategorySubscriptionService;
import tn.esprit.spring.service.interfaceS.IClubService;
import tn.esprit.spring.service.interfaceS.IEventService;
import tn.esprit.spring.service.interfaceS.IExtraService;
import tn.esprit.spring.service.interfaceS.IKinderGartenService;
import tn.esprit.spring.service.interfaceS.IMeetingService;
import tn.esprit.spring.service.interfaceS.IUserService;

@RestController
@RequestMapping("/admingarten")
@PreAuthorize("hasRole('ROLE_adminGarten')")
public class AdminGartenController {

	@Autowired
	IKinderGartenService iKinderGartenService;
	@Autowired
	IExtraService iExtraService;
	@Autowired
	ICategorySubscriptionService iCategorySubscriptionService;
	@Autowired
	IMeetingService iMeetingService;
	@Autowired
	IActivityService iActivityService;
	@Autowired
	IEventService iEventService;
	@Autowired
	ICategoryService iCategoryService;
	@Autowired
	IClubService iClubService;
	@Autowired
	IUserService iUserService;

	@PostMapping("/addKinderGarten")
	@ResponseBody
	public KinderGarten addKinderGarten(@RequestBody KinderGarten kendergarten) {
		iKinderGartenService.addKindergarten(kendergarten);
		return kendergarten;
	}

	@GetMapping(value = "/getKindergartenById/{kinderId}")
	@ResponseBody
	public KinderGarten getKindergartenById(@PathVariable("kinderId") int kinderId) {
		return iKinderGartenService.getKindergartenById(kinderId);
	}

	@GetMapping(value = "/getAllkinder")
	@ResponseBody
	public List<KinderGarten> getAllkinder() {

		return iKinderGartenService.getAllkinder();
	}

	@PutMapping(value = "/updateKinderGarten/{id}")
	@ResponseBody
	public void updateKinderGarten(@PathVariable("id") int kenderId, @RequestBody KinderGarten kendergarten) {
		iKinderGartenService.updateKindergarten(kendergarten.getName(), kendergarten.getAdress(),
				kendergarten.getEmail(), kendergarten.getTel(), kendergarten.getLogo(), kenderId);

	}

	@DeleteMapping("/deleteKindergartenById/{kenderId}")
	@ResponseBody
	public void deleteKindergartenById(@PathVariable("kenderId") int kenderId) {
		iKinderGartenService.deleteKindergartenById(kenderId);
		;
	}

	@PutMapping(value = "/affecterKinderAResponsible/{kinderId}/{ReponsibleId}")
	public void affecterKinderAResponsible(@PathVariable("kinderId") int kinderId,
			@PathVariable("ReponsibleId") int ReponsibleId) {
		iKinderGartenService.affecterKinderAResponsible(kinderId, ReponsibleId);
	}

	// Extra ...

	@PostMapping("/addExtra")
	@ResponseBody
	public Extra addExtra(@RequestBody Extra extra) {
		iExtraService.addExtra(extra);
		return extra;
	}

	@GetMapping(value = "/getExtraById/{extraId}")
	@ResponseBody
	public Extra getExtraById(@PathVariable("extraId") int extraId) {
		return iExtraService.getExtraById(extraId);
	}

	@GetMapping(value = "/getAllextra")
	@ResponseBody
	public List<Extra> getAllextra() {

		return iExtraService.getAllextra();
	}

	@PutMapping(value = "/updateExtra/{id}")
	@ResponseBody
	public void updateExtra(@PathVariable("id") int ExtraId, @RequestBody Extra extra) {
		iExtraService.updateExtra(extra.getDescription(), extra.getPrice(), ExtraId);

	}

	@DeleteMapping("/deleteExtraById/{extraId}")
	@ResponseBody
	public void deleteExtraById(@PathVariable("extraId") int extraId) {
		iExtraService.deleteExtraById(extraId);
	}

	@PutMapping(value = "/affecterExtraAkinderGarten/{extraId}/{kinderId}")
	public void affecterExtraAkinderGarten(@PathVariable("extraId") int extraId,
			@PathVariable("kinderId") int kinderId) {
		iExtraService.affecterExtraAkinderGarten(extraId, kinderId);

	}

	// categorySubscription...

	@PostMapping("/addCategorySubscription")
	@ResponseBody
	public CategorySubscription addCategorySubscription(@RequestBody CategorySubscription categorySubscription) {
		iCategorySubscriptionService.addCategorySubscription(categorySubscription);
		return categorySubscription;
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

	@PutMapping(value = "/updateCategorySubscription/{id}")
	@ResponseBody
	public void updateCategorySubscription(@PathVariable("id") int categorySubscriptionId,
			@RequestBody CategorySubscription categorySubscription) {
		iCategorySubscriptionService.updateCategorySubscription(categorySubscription.getDescription(),
				categorySubscription.getPrice(), categorySubscriptionId);

	}

	@DeleteMapping("/deleteCategorySubscriptionById/{categorySubscriptionId}")
	@ResponseBody
	public void deleteCategorySubscriptionById(@PathVariable("categorySubscriptionId") int categorySubscriptionId) {
		iCategorySubscriptionService.deleteCategorySubscriptionById(categorySubscriptionId);
	}

	@PutMapping(value = "/affecterCategorySubscriptionAkinderGarten/{categorySubscriptionId}/{kinderId}")
	public void affecterCategorySubscriptionAkinderGarten(
			@PathVariable("categorySubscriptionId") int categorySubscriptionId,
			@PathVariable("kinderId") int kinderId) {
		iCategorySubscriptionService.affecterCategorySubscriptionAkinderGarten(categorySubscriptionId, kinderId);

	}

	// Meeting ...
	@GetMapping(value = "/getMeetingByKinderGartenAndDate/{kinderId}/{dateStart}/{dateEnd}")
	@ResponseBody
	public List<Meeting> getMeetingByKinderGartenAndDate(@PathVariable("kinderId") int kinderId,
			@PathVariable("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart,
			@PathVariable("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd) {
		return iMeetingService.getMeetingByKinderGartenAndDate(kinderId, dateStart, dateEnd);
	}

	@PostMapping("/addMeeting")
	@ResponseBody
	public Meeting addMeeting(@RequestBody Meeting meeting) {
		iMeetingService.addMeeting(meeting);
		return meeting;
	}

	@GetMapping(value = "/getMeetingById/{meetingId}")
	@ResponseBody
	public Meeting getMeetingById(@PathVariable("meetingId") int meetingId) {
		return iMeetingService.getMeetingById(meetingId);
	}

	@GetMapping(value = "/getAllmeeting")
	@ResponseBody
	public List<Meeting> getAllmeeting() {

		return iMeetingService.getAllmeeting();
	}

	@PutMapping(value = "/updateMeeting/{id}")
	@ResponseBody
	public void updateMeeting(@PathVariable("id") int meetingId, @RequestBody Meeting meeting) {
		iMeetingService.updateMeeting(meeting.getDateStart(), meeting.getDateEnd(), meetingId);

	}

	@DeleteMapping("/deleteMeetingById/{meetingId}")
	@ResponseBody
	public void deleteMeetingById(@PathVariable("meetingId") int meetingId) {
		iMeetingService.deleteMeetingById(meetingId);
	}

	@PutMapping(value = "/affecterMeetingAkinderGarten/{meetingId}/{kinderId}")
	public void affecterMeetingAkinderGarten(@PathVariable("meetingId") int meetingId,
			@PathVariable("kinderId") int kinderId) {
		iMeetingService.affecterMeetingAkinderGarten(meetingId, kinderId);

	}

	// activity ...

	@PostMapping("/addActivity")
	@ResponseBody
	public Activity addActivity(@RequestBody Activity activity) {
		iActivityService.addActivity(activity);
		return activity;
	}

	@GetMapping(value = "/getActivityById/{activityaId}")
	@ResponseBody
	public Activity getActivityById(@PathVariable("activityaId") int activityaId) {
		return iActivityService.getActivityById(activityaId);
	}

	@GetMapping(value = "/getAllactivity")
	@ResponseBody
	public List<Activity> getAllactivity() {

		return iActivityService.getAllactivity();
	}

	@PutMapping(value = "/updateActivity/{id}")
	@ResponseBody
	public void updateActivity(@PathVariable("id") int activityId, @RequestBody Activity activity) {
		iActivityService.updateActivity(activity.getDescription(), activity.getPhoto(), activityId);

	}

	@DeleteMapping("/deleteActivityById/{activityId}")
	@ResponseBody
	public void deleteActivityById(@PathVariable("activityId") int activityId) {
		iActivityService.deleteActivityById(activityId);
	}

	@PutMapping(value = "/affecterActivityAkinderGarten/{activityId}/{kinderId}")
	public void affecterActivityAkinderGarten(@PathVariable("activityId") int activityId,
			@PathVariable("kinderId") int kinderId) {
		iActivityService.affecterActivityAkinderGarten(activityId, kinderId);

	}

	@PutMapping(value = "/deleteAllActivity/{kinderId}")
	public void deleteAllActivity(@PathVariable("kinderId") int kinderId) {
		iActivityService.deleteAllActivity(kinderId);
	}

	@GetMapping(value = "/findAllActivityByKinderGarten/{kinderId}")
	@ResponseBody
	public List<Activity> findAllActivityByKinderGarten(@PathVariable("kinderId") int kinderId) {
		return iActivityService.findAllActivityByKinderGarten(kinderId);
	}

	// Event...

	@PostMapping("/addEvent")
	@ResponseBody
	public Event addEvent(@RequestBody Event event) {
		iEventService.addEvent(event);
		return event;
	}

	@GetMapping(value = "/getEventById/{eventId}")
	@ResponseBody
	public Event getEventById(@PathVariable("eventId") int eventId) {
		return iEventService.getEventById(eventId);
	}

	@GetMapping(value = "/getAllevent")
	@ResponseBody
	public List<Event> getAllevent() {

		return iEventService.getAllevent();
	}

	@PutMapping(value = "/updateEvent/{id}")
	@ResponseBody
	public void updateEvent(@PathVariable("id") int eventId, @RequestBody Event event) {
		iEventService.updateEvent(event.getDescription(), event.getDate(), eventId);

	}

	@DeleteMapping("/deleteEventById/{eventId}")
	@ResponseBody
	public void deleteEventById(@PathVariable("eventId") int eventId) {
		iEventService.deleteEventaById(eventId);
	}

	@PutMapping(value = "/affecterEventAkinderGarten/{eventId}/{kinderId}")
	public void affecterEventAkinderGarten(@PathVariable("eventId") int eventId,
			@PathVariable("kinderId") int kinderId) {
		iEventService.affecterEventAkinderGarten(eventId, kinderId);

	}

	// Category ...

	@PostMapping("/addCategory")
	@ResponseBody
	public Category addCategory(@RequestBody Category category) {
		iCategoryService.addCategory(category);
		return category;
	}

	@GetMapping(value = "/getCategoryById/{categoryId}")
	@ResponseBody
	public Category getCategoryById(@PathVariable("categoryId") int categoryId) {
		return iCategoryService.getCategoryById(categoryId);
	}

	@GetMapping(value = "/getAllcategory")
	@ResponseBody
	public List<Category> getAllcategory() {

		return iCategoryService.getAllcategory();
	}

	@PutMapping(value = "/updateCategory/{id}")
	@ResponseBody
	public void updateCategory(@PathVariable("id") int categoryId, @RequestBody Category category) {
		iCategoryService.updateCategory(category.getDescription(), categoryId);

	}

	@DeleteMapping("/deleteCategoryById/{categoryId}")
	@ResponseBody
	public void deleteCategoryById(@PathVariable("categoryId") int categoryId) {
		iCategoryService.deleteCategoryById(categoryId);
	}

	// Club ...

	@PostMapping("/addClub")
	@ResponseBody
	public Club addClub(@RequestBody Club club) {
		iClubService.addClub(club);
		return club;
	}

	@GetMapping(value = "/getClubById/{clubId}")
	@ResponseBody
	public Club getClubById(@PathVariable("clubId") int clubId) {
		return iClubService.getClubById(clubId);
	}

	@GetMapping(value = "/getAllclub")
	@ResponseBody
	public List<Club> getAllclub() {

		return iClubService.getAllclub();
	}

	@PutMapping(value = "/updateClub/{id}")
	@ResponseBody
	public void updateClub(@PathVariable("id") int clubId, @RequestBody Club club) {
		iClubService.updateClub(club.getDescription(), clubId);

	}

	@DeleteMapping("/deleteClubById/{clubId}")
	@ResponseBody
	public void deleteClubById(@PathVariable("clubId") int clubId) {
		iClubService.deleteClubById(clubId);
	}

	@PutMapping(value = "/affecterClubAkinderGarten/{clubId}/{kinderId}")
	public void affecterClubAkinderGarten(@PathVariable("clubId") int clubId, @PathVariable("kinderId") int kinderId) {
		iClubService.affecterClubAkinderGarten(clubId, kinderId);

	}

	@PutMapping(value = "/affecterCategoryAClub/{clubId}/{categoryId}")
	public void affecterCategoryAClub(@PathVariable("clubId") int clubId, @PathVariable("categoryId") int categoryId) {
		iClubService.affecterCategoryAClub(clubId, categoryId);

	}

	// metier
	@GetMapping(value = "/FilterParentForDelegate")
	@ResponseBody
	public List<User> FilterParentForDelegate() {

		return iUserService.FilterParentForDelegate();
	}

}
