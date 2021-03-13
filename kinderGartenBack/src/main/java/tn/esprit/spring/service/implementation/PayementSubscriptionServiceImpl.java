package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Customer;

import tn.esprit.spring.controller.UserResourceImpl;
import tn.esprit.spring.entity.PayementSubscription;
import tn.esprit.spring.entity.SubscriptionChild;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.enumeration.TypePayement;
import tn.esprit.spring.repository.IPayementSubscriptionRepository;
import tn.esprit.spring.repository.ISubscriptionChildRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.IPayementSubscriptionService;

@Service
public class PayementSubscriptionServiceImpl implements IPayementSubscriptionService {

	private static Logger log = LoggerFactory.getLogger(PayementSubscriptionServiceImpl.class);

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
		this.accountingSubscription(p.getPrice(), p.getSubscriptionChild().getId());

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
		if (s != null) {

			return s.getListPayementSubscriptions();

		}
		return null;

	}

	// *

	public void accountingSubscription(double totalP, int idS) {

		SubscriptionChild s = subR.findById(idS).orElse(null);

		if (s != null) {

			s.setTotalPay(s.getTotalPay() + totalP);
			s.setRestPay(s.getTotal() - s.getTotalPay());

			subR.save(s);
		}

	}

	// *

	public boolean addPayementStripe(int price) {

		try {

			// String token="tok_1IRhQnJ3wGblCO7QAMYXEOfd";

			Stripe.apiKey = "sk_test_51IRgyaJ3wGblCO7QrvCjRizYM4jmNFAvsStxCKN9pjCdDfeCuybbC9FCBgEACCC4UiAKlk0a7hw6ei3FMVCbu1KH00mUcpCkti";
			// Customer c = Customer.retrieve("cus_J3oe4LEwWKxRbD");
			Map<String, Object> chargParam = new HashMap<String, Object>();
			chargParam.put("amount", price);
			chargParam.put("currency", "usd");
			chargParam.put("customer", "cus_J3oe4LEwWKxRbD");
			Charge.create(chargParam);

		} catch (Exception e) {

			log.error("Payement en ligne:", e.getMessage());
			return false;

		}
		return true;

	}

	@Override
	public void addPayementEnLigne(PayementSubscription p) {

		if (this.addPayementStripe((int) p.getPrice())) {

			p.setTypePayement(TypePayement.onLine);
			this.add(p);

		}

	}

	@Override
	public List<PayementSubscription> getAll() {
		return (List<PayementSubscription>) payementSR.findAll();
	}

	@Override
	public List<PayementSubscription> findByDate(Date d) {
		return payementSR.findByDateC(d);
	}

}
