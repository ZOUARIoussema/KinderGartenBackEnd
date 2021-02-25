package tn.esprit.spring.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.enumeration.Role;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userR;

	@Override
	public void add(User u) {
		userR.save(u);

	}

	@Override
	public List<User> getAll() {

		return (List<User>) userR.findAll();
	}

	@Override
	public User findByEmail(String email) {

		return null;
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
			this.add(user4);

		}

	}

}
