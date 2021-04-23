package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Spent;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ISpentRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.ISpentService;

@Service
public class SpentServiceImpl implements ISpentService {
	
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private ISpentRepository spentR;
	@Autowired
	private IUserRepository userR;

	@Override
	public void add(Spent s) {
		s.setDateC(new Date());
		log.info("add spent "+" description "+s.getDescription()+" total "+s.getTotal()+" type "+s.getType());
		spentR.save(s);

	}

	@Override
	public void delete(int id) {

		Spent s = spentR.findById(id).orElse(null);

		if (s != null) {

			spentR.delete(s);
		}

	}

	@Override
	public void update(Spent s) {

		spentR.save(s);

	}

	@Override
	public List<Spent> getAllByAgentCashier(int id) {
		
		User agentCashier =userR.findById(id).orElse(null);
		
		if(agentCashier!=null) {
			
			return agentCashier.getLisSpents();
		}
		return null;
		

	}

	@Override
	public List<Spent> getAll() {
		return (List<Spent>) spentR.findAll();
	}

	@Override
	public List<Spent> findByDate(Date d) {
		 return spentR.findByDateC(d);
	}

	@Override
	public Spent findById(int id) {
		return spentR.findById(id).orElse(null);
	}

}
