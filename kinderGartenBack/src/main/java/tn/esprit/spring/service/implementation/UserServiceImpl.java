package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.config.mail.MailConfig;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.enumeration.Role;
import tn.esprit.spring.entity.enumeration.StateUser;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	MailServiceImpl servicemail;

	@Autowired
	IUserRepository userR;

	@Autowired
	IKinderGartenRepository kinderRepo;
	
	@Autowired 
	ClaimServiceImpl claimserv;

	@Override
	public void add(User u) {
		u.setDateC(new Date());
		userR.save(u);

	}

	@Override
	public List<User> getAll() {

		return (List<User>) userR.findAll();
	}

	@Override
	public User findByEmail(String email) {

		return userR.findByEmail(email);
	}

	@Override
	public void initialize() {

		if (this.getAll().size() == 0) {

			User user1 = new User();
			user1.setEmail("testadmin@user.com");
			user1.setFirstName("Test User admin");
			user1.setTel(97874565);
			user1.setRole(Role.ROLE_admin);
			user1.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			this.add(user1);

			User user2 = new User();
			user2.setEmail("testadmingarten@user.com");
			user2.setFirstName("Test User admin garten");
			user2.setTel(97874565);
			user2.setRole(Role.ROLE_adminGarten);
			user2.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			this.add(user2);

			User user3 = new User();
			user3.setEmail("testagentcashier@user.com");
			user3.setFirstName("Test User agent cashier");
			user3.setTel(97874565);
			user3.setRole(Role.ROLE_agentCashier);
			user3.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			this.add(user3);

			User user4 = new User();
			user4.setEmail("testfutureparent@user.com");
			user4.setFirstName("Test User parent");
			user4.setTel(97874565);
			user4.setRole(Role.ROLE_futurParent);
			user4.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			this.add(user4);

			User user5 = new User();
			user5.setEmail("testdoctor@user.com");
			user5.setFirstName("Test User doctor");
			user5.setTel(97874565);
			user5.setRole(Role.ROLE_doctor);
			user5.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			this.add(user5);

			User user6 = new User();
			user6.setEmail("testvisitor@user.com");
			user6.setFirstName("Test User visitor");
			user6.setTel(97874565);
			user6.setRole(Role.ROLE_visitor);
			user6.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			this.add(user6);

			User user7 = new User();
			user7.setEmail("testparent@user.com");
			user7.setFirstName("Test User parent");
			user7.setTel(97874565);
			user7.setRole(Role.ROLE_parent);
			user7.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			this.add(user7);
			
			
			User user8 = new User();
			user8.setEmail("testprovider@user.com");
			user8.setFirstName("Test User provider");
			user8.setTel(97874565);
			user8.setRole(Role.ROLE_provider);
			user8.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			this.add(user8);

		}

	}

	@Override
	public void ChangeStateUser(User u) {

		if (u.getStateUser().equals(StateUser.watting))

		{
			u.setStateUser(StateUser.active);
		}

		if (u.getStateUser().equals(StateUser.active)) {
			u.setStateUser(StateUser.blocked);
		}

	}

	@Override
	public void delete(int id) {

		User u = userR.findById(id).get();

		if (u != null) {

			userR.delete(u);
		}

	}

	@Override
	public void update(User u) {

		String pwd = new BCryptPasswordEncoder().encode(u.getPassword());

		u.setPassword(pwd);

		userR.save(u);

	}

	@Override
	public void changePassWord(int id, String pwd) {

		User u = userR.findById(id).get();

		if (u != null) {

			u.setPassword(pwd);

			this.update(u);
		}

	}

	@Override
	public void confirmerInscriptionParMail(User u) {

		servicemail.sendSimpleMail(u.getEmail(), "Inscription confirmation",
				" Your account is active ! you can log on !");

	}


	@Override
	public void DesactivateAccountKinderGarten(int kg_id) {
		
		KinderGarten kg = kinderRepo.findById(kg_id).get();
		
		int ClaimsScoreEval = claimserv.countClaimsinKinderGarten(kg_id) + kg.getScoreEval();
		
		if (ClaimsScoreEval >= 50)
		{
			kg.getResponsible().setStateUser(StateUser.blocked);
		}
		
			
	}

}
