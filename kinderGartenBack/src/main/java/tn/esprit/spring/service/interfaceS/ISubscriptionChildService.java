package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.SubscriptionChild;

public interface ISubscriptionChildService {
	
	
	public void addSubscriptionChild(SubscriptionChild s);
	public List<SubscriptionChild> getAllSubscriptionByChild(int id);
	public void update(SubscriptionChild s);
	public void delete(int id);
	
	

}
