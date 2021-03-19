package tn.esprit.spring.service.implementation;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.repository.ICategoryRepository;
import tn.esprit.spring.repository.IEventRepository;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.service.interfaceS.IEventService;
@Service
public class EventServiceImpl implements IEventService {
	@Autowired
	IEventRepository iEventRepository;
	@Autowired
	ICategoryRepository iCategoryRepository;
	
	@Override
	public int addEvent(Event event) {
		iEventRepository.save(event);
		return event.getId();
	}

	@Override
	public void updateEvent(String description, Date date,double price, int eventId) {
		iEventRepository.updateEventJPQL(description, date,price, eventId);
		
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
	public void affecterEventACategory(int eventId, int categoryId) {
		Category categoryManagedEntity = iCategoryRepository.findById(categoryId).get();
		Event eventManagedEntity = iEventRepository.findById(eventId).get();
		
		eventManagedEntity.setCategory(categoryManagedEntity);
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
