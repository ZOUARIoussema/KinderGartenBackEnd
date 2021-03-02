package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.PayementSubscription;
import tn.esprit.spring.entity.SubscriptionChild;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IPayementSubscriptionRepository;
import tn.esprit.spring.repository.ISubscriptionChildRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.IPayementSubscriptionService;

@Service
public class PayementSubscriptionServiceImpl implements IPayementSubscriptionService {

	@Autowired
	private IPayementSubscriptionRepository payementSR;

	@Autowired
	private IUserRepository userR;

	@Autowired
	private ISubscriptionChildRepository subR;

	@Override
	public void add(PayementSubscription p) {

		p.setDateC(new Date());

		payementSR.save(p);

	}

	@Override
	public void update(PayementSubscription p) {
		payementSR.save(p);

	}

	@Override
	public List<PayementSubscription> getAllByUser(int id) {

		User u = userR.findById(id).orElse(null);

		if (u != null) {

			return u.getLisPayementSubscriptions();
		}

		return null;

	}

	@Override
	public List<PayementSubscription> getAllBySubscriptionChild(int id) {

		SubscriptionChild s = subR.findById(id).orElse(null);
		if(s != null) {
			
			return s.getListPayementSubscriptions();
			
		}
		return null;

	}

}
