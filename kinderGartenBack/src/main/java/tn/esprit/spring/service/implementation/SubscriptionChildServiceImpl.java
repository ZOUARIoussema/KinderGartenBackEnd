package tn.esprit.spring.service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.CategorySubscription;
import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.SubscriptionChild;
import tn.esprit.spring.repository.IChildRepository;
import tn.esprit.spring.repository.ISubscriptionChildRepository;
import tn.esprit.spring.service.interfaceS.ISubscriptionChildService;

@Service
public class SubscriptionChildServiceImpl implements ISubscriptionChildService {

	@Autowired
	private ISubscriptionChildRepository rep;

	@Autowired
	private IChildRepository repChild;

	@Override
	public void addSubscriptionChild(SubscriptionChild s) {

		s.setDateC(new Date());
		rep.save(s);

	}

	@Override
	public List<SubscriptionChild> getAllSubscriptionByChild(int id) {

		List<SubscriptionChild> list = new ArrayList<SubscriptionChild>();

		Child c = repChild.findById(id).orElse(null);

		if (c != null) {
			list = c.getLisSubscriptionChilds();
		}

		return list;
	}

	@Override
	public void update(SubscriptionChild s) {
		rep.save(s);

	}

	@Override
	public void delete(int id) {

		SubscriptionChild s = rep.findById(id).orElse(null);

		if (s != null) {

			rep.delete(s);
		}

	}

	

}
