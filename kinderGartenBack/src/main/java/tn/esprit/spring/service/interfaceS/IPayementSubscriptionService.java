package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.PayementSubscription;

public interface IPayementSubscriptionService {

	public void add(PayementSubscription p);

	public void update(PayementSubscription p);

	public List<PayementSubscription> getAllByUser(int id);

	public List<PayementSubscription> getAllBySubscriptionChild(int id);

    public void addPayementEnLigne(PayementSubscription p);

}
