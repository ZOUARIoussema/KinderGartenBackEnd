package tn.esprit.spring.service.interfaceS;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Event;


public interface IEventService {
	public int addEvent(Event event);
	public void updateEvent(String description,Date date,int eventId);
	public List<Event> getAllevent();
	public void deleteEventaById(int eventId);
	public Event getEventById(int eventId);
	public void affecterEventAkinderGarten(int eventId, int kinderId);
}
