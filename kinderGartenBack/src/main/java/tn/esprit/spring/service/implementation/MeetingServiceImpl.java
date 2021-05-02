package tn.esprit.spring.service.implementation;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.Meeting;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.IMeetingRepository;
import tn.esprit.spring.repository.INotification;
import tn.esprit.spring.service.interfaceS.IMeetingService;
@Service
public class MeetingServiceImpl implements IMeetingService {
	@Autowired
	IMeetingRepository iMeetingRepository;
	@Autowired
	IKinderGartenRepository kinderRepo;
	@Autowired
	INotification inotification;
	@Override

	public int addMeeting(Meeting meeting,int idk) {
		meeting.setKinderGarten(kinderRepo.findById(idk).orElse(null));
		iMeetingRepository.save(meeting);
	  return meeting.getId();
	}

	@Override
	public void updateMeeting(Date dateStart, Date dateEnd, int meetingId) {
		iMeetingRepository.updateMeetingJPQL(dateStart, dateEnd, meetingId);
		
	}

	@Override
	public List<Meeting> getAllmeeting() {
		return (List<Meeting>) iMeetingRepository.findAll();
	}

	@Override
	public void deleteMeetingById(int meetingId) {
		Meeting meeting = iMeetingRepository.findById(meetingId).get();
		iMeetingRepository.delete(meeting);
		
	}

	@Override
	public Meeting getMeetingById(int meetingId) {
		return iMeetingRepository.findById(meetingId).get();
	}

	@Override
	public void affecterMeetingAkinderGarten(int meetingId, int kinderId) {
		KinderGarten kinderManagedEntity = kinderRepo.findById(kinderId).get();
		Meeting meetingManagedEntity = iMeetingRepository.findById(meetingId).get();
		
		meetingManagedEntity.setKinderGarten(kinderManagedEntity);
		iMeetingRepository.save(meetingManagedEntity);
		
	}

	@Override

	public List<Meeting> findAllMeetingByKinderGarten(int kinderId) {
		return iMeetingRepository.findAllMeetingByKinderGartenJPQL(kinderId);
	}

}
