package tn.esprit.spring.service.implementation;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.repository.IEventRepository;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.service.interfaceS.IEventService;
@Service
public class EventServiceImpl implements IEventService {
	@Autowired
	IEventRepository iEventRepository;
	@Autowired
	IKinderGartenRepository kinderRepo;
	
	@Override
	public int addEvent(Event event) {
		iEventRepository.save(event);
		return event.getId();
	}

	@Override
	public void updateEvent(String description, Date date, int eventId) {
		iEventRepository.updateEventJPQL(description, date, eventId);
		
	}

	@Override
	public List<Event> getAllevent() {
		return (List<Event>) iEventRepository.findAll();
	}

	@Override
	public void deleteEventaById(int eventId) {
		Event event = iEventRepository.findById(eventId).get();
		iEventRepository.delete(event);		
	}

	@Override
	public Event getEventById(int eventId) {
		return iEventRepository.findById(eventId).get();

	}

	@Override
	public void affecterEventAkinderGarten(int eventId, int kinderId) {
		KinderGarten kinderManagedEntity = kinderRepo.findById(kinderId).get();
		Event eventManagedEntity = iEventRepository.findById(eventId).get();
		
		eventManagedEntity.setKinderGarten(kinderManagedEntity);
		iEventRepository.save(eventManagedEntity);		
	}

	@Override
	public List<Event> findAllEventByKinderGarten(int kinderId) {
		return iEventRepository.findAllEventByGartenJPQL(kinderId);
	}

	@Override
	public List<Event> getAllEventForToday() {
		return iEventRepository.getAllEventPourToday();
	}

}
