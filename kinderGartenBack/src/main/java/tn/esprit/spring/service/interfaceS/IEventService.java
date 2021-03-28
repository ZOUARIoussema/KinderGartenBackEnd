package tn.esprit.spring.service.interfaceS;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Estimate;
import tn.esprit.spring.entity.Event;


public interface IEventService {
	public int addEvent(Event event);
	public void updateEvent(String description, Date date,double price, int eventId);
	public List<Event> getAllevent();
	public void deleteEventaById(int eventId);
	public Event getEventById(int eventId);
	public void affecterEventACategory(int eventId, int categoryId) ;
	public List<Event> findAllEventByKinderGarten(int kinderId) ;
	public List<Event> getAllEventForToday();
	public List<Event> getEventForChild(int idChild);
	public void SendRequestItem(int id_event, int userId, int kindergartenId);
	public List<?> getEstimateByEvent(int idEvent);
}
