package tn.esprit.spring.service.interfaceS;

import java.util.List;
import java.util.Set;

import tn.esprit.spring.entity.CategorySubscription;
import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.SubscriptionChild;

public interface ISubscriptionChildService {
	
	
	public SubscriptionChild addSubscriptionChild(SubscriptionChild s);
	public List<SubscriptionChild> getAllSubscriptionByChild(int id);
	public void update(SubscriptionChild s);
	public void delete(int id);
	public SubscriptionChild getById(int id);
	public void updateTotalWithParticipateEvent(Child c);
	public List<SubscriptionChild> getAll();
	
	

}
