package tn.esprit.spring.service.interfaceS;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Event;


public interface IEventService {
	public void addEvent(Event event, int id);
	public void updateEvent(String object,String description, Date date,double price, int eventId);
	public List<Event> getAllevent();
	public void deleteEventaById(int eventId);
	public Event getEventById(int eventId);
	public void affecterEventACategory(int eventId, int categoryId) ;
	public List<Event> getAllEventForToday();
	public List<Event> getEventForChild(int idChild);
	public void SendSmstoProvider(int id_event, int userId, int kindergartenId);
	public void SendRequestItem(int id_event, int userId, int kindergartenId);
	public List<?> getEstimateByEvent(int idEvent);
	public List<Event> getAllEventbyprice(int price);
}
