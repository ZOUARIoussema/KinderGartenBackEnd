package tn.esprit.spring.service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.ParseInfo;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.Statistique;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ICategoryRepository;
import tn.esprit.spring.repository.IChildRepository;
import tn.esprit.spring.repository.IEventRepository;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.IUserRepository;
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
	public void updateEvent(String object, String description, Date date, double price, int eventId) {
		iEventRepository.updateEventJPQL(description, date, price, eventId);		
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
@Autowired
IChildRepository iChildRepository;
	@Override
	public List<Event> getEventForChild(int idChild) {
		Child c= iChildRepository.findById(idChild).orElse(null);
		List<Event> liste = (List<Event>) iEventRepository.findAll();
		//List<Category> listCategory = (List<Category>)iCategoryRepository.findAll();
		List<Category> listInterest = c.getListInterest();
		List<Event> lis= new ArrayList<>();
		for (int i = 0; i < liste.size(); i++) {
			for (int j = 0; j < listInterest.size(); j++) {
				if (liste.get(i).getCategory().equals(listInterest.get(j))&&listInterest.get(j).getListChild().contains(c)) {
					lis.add(liste.get(i));
					
				}
			}
		}
		return lis;
	}


	
	@Override
	public void SendRequestItem(int id_event, int userId, int kindergartenId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<?> getEstimateByEvent(int idEvent) {
		// TODO Auto-generated method stub
		return null;
	}

}