package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.enumeration.Role;
import tn.esprit.spring.service.interfaceS.IUserService;

@SpringBootApplication
public class KinderGartenBackApplication implements CommandLineRunner {

	@Autowired
	IUserService users;

	public static void main(String[] args) {
		SpringApplication.run(KinderGartenBackApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// initialize
		users.initialize();

	}

}
