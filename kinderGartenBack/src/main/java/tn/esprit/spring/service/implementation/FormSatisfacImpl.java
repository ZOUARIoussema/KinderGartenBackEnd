package tn.esprit.spring.service.implementation;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.formSatisfac;
import tn.esprit.spring.repository.IFormSatisfacRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.IFormSatisfacService;


@Service
public class FormSatisfacImpl implements IFormSatisfacService{
	
	@Autowired
	IFormSatisfacRepository formrepo;
	
	@Autowired
	IUserRepository userRepo;
	
	private static Logger log = LoggerFactory.getLogger(FormSatisfacImpl.class);

	@Override
	public void planifierFormulaireStatisfaction(int id) {
		
		
	formSatisfac fs = formrepo.findById(id).get();
	
	int year = fs.getDate_debut().getYear();
	int mois = fs.getDate_debut().getMonth();
	int day_of_month = fs.getDate_debut().getDate();
		
	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		
		@Override
		public void run() {
			
			log.info("Statisfaction Form is completed !");
			
		}
	};
	
	Calendar date = Calendar.getInstance();
	
	date.set(Calendar.YEAR,year);
	date.set(Calendar.MONTH,mois);
	date.set(Calendar.DAY_OF_MONTH,day_of_month);
	
	
	timer.scheduleAtFixedRate(task, date.getTime(),605_000_000);
	
	
	}
	
	
	
	public void addStatisfactionForm(formSatisfac fm)
	{
		formrepo.save(fm);
		
	}


	@Override
	public void saveNumberResponses(int nbre_reponses, int parent_id,int id_form) 
	{
		formSatisfac fs = formrepo.findById(id_form).get();
		User u = userRepo.findById(parent_id).get();
		
		fs.setParentStatisfac(u);
		fs.setNbr_reponses(nbre_reponses);
		
		formrepo.save(fs);

	}



	
	
	

}
			
			