package tn.esprit.spring.service.interfaceS;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.Meeting;


public interface IMeetingService {
	public int addMeeting(Meeting meeting,int idk);
	public void updateMeeting(Date dateStart,Date dateEnd,int meetingId);
	public List<Meeting> getAllmeeting();
	public void deleteMeetingById(int meetingId);
	public Meeting getMeetingById(int meetingId);
	public void affecterMeetingAkinderGarten(int meetingId, int kinderId);
	public List<Meeting> findAllMeetingByKinderGarten(int kinderId) ;
}
