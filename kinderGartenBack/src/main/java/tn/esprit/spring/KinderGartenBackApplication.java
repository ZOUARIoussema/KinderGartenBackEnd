package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.esprit.spring.service.interfaceS.IFolderMedicalService;
import tn.esprit.spring.service.interfaceS.IPayementSubscriptionService;
import tn.esprit.spring.service.interfaceS.IUserService;

@SpringBootApplication
public class KinderGartenBackApplication implements CommandLineRunner {

	@Autowired
	IUserService users;
	@Autowired
	IFolderMedicalService folderMedicalService;
	@Autowired
	IPayementSubscriptionService paSubscriptionService;

	public static void main(String[] args) {
		SpringApplication.run(KinderGartenBackApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// initialize
		users.initialize();
		//alert vaccine child to do
		// folderMedicalService.alertVaccineChildToDo();
		//alert payement subscription
		// paSubscriptionService.alertPayement();

	}

}
