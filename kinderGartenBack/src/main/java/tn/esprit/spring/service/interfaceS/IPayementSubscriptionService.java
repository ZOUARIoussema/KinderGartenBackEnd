package tn.esprit.spring.service.interfaceS;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.PayementSubscription;

public interface IPayementSubscriptionService {

	public void add(PayementSubscription p);

	public void update(PayementSubscription p);

	public List<PayementSubscription> getAllByUser(int id);

	public List<PayementSubscription> getAllBySubscriptionChild(int id);

    public void addPayementEnLigne(PayementSubscription p);
    
    public List<PayementSubscription> getAll();
    
    public List<PayementSubscription> findByDate(Date d);
    
    public void alertPayement();
    
    public PayementSubscription getById(int id);

}
