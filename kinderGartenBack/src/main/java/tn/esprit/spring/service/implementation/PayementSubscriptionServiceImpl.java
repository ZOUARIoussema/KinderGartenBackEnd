package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Customer;

import tn.esprit.spring.config.mail.EmailRequestDTO;
import tn.esprit.spring.controller.UserResourceImpl;
import tn.esprit.spring.entity.PayementSubscription;
import tn.esprit.spring.entity.SubscriptionChild;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.enumeration.TypePayement;
import tn.esprit.spring.repository.IPayementSubscriptionRepository;
import tn.esprit.spring.repository.ISubscriptionChildRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.IMailService;
import tn.esprit.spring.service.interfaceS.IPayementSubscriptionService;

@EnableScheduling
@Service
public class PayementSubscriptionServiceImpl implements IPayementSubscriptionService {

	private static Logger log = LoggerFactory.getLogger(PayementSubscriptionServiceImpl.class);

	@Autowired
	private IPayementSubscriptionRepository payementSR;

	@Autowired
	private IUserRepository userR;

	@Autowired
	private ISubscriptionChildRepository subR;
	
	@Autowired
	private IMailService mailS;

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

		 
		return payementSR.findBySubscription(id);

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

	@Scheduled(cron="0 50 13 01 4 *", zone="Africa/Tunis")
	@Override
	public void alertPayement() {
		
		for(SubscriptionChild s :subR.findAll()) {
			
			if(s.getRestPay()!=0) {
				
				Map<String, String> model = new HashMap<>();
				model.put("name",s.getChild().getName());
				model.put("lien", "http://localhost:8081/accounting/detailSubscription/" + s.getId());

				EmailRequestDTO email = new EmailRequestDTO();

				// email.setTo("oussema.zouari@esprit.tn");
				email.setTo(s.getChild().getParent().getEmail());
				email.setSubject("Payement Subscription");

				mailS.sendMailWithFreeMarker(email, model, "alertPayementSubscription.ftl");
				
				
				
			}
			
		}
		
		
		
	}

	@Override
	public PayementSubscription getById(int id) {
		return payementSR.findById(id).orElse(null);
	}

}
