package tn.esprit.spring.service.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IFormSatisfacRepository;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.IStatisticsRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.IStatisticsService;


@Service
public class StatisticsServiceImpl implements IStatisticsService {

	@Autowired
    private IStatisticsRepository StatisticRepository;
	
	@Autowired
    private IKinderGartenRepository kinderrepo;
	
	@Autowired 
	private IUserRepository userrepo;
	
	@Autowired 
	private IFormSatisfacRepository formstatisrepo;
	
	@Override
	public List<?> listChildByKinderGarten() {
		
		return StatisticRepository.listChildByKinderGarten();
	}


	@Override
	public List<?> NbrLikeByUser() {
		
		return StatisticRepository.NbrLikeByUser();
	}

	
	@Override
	public List<?> numberParticipEventKinderGaten()
	{
	return StatisticRepository.numberParticipEventKinderGaten();
		
	}

	@Override
	public List<?> nbrPublicationByUser() {
		return StatisticRepository.nbrPublicationByUser();
	}

	@Override
	public List<?> NbrChildSubscribed(int year) {
		
		return StatisticRepository.NbrChildSubscribed(year);
	}


	@Override
	public List<?> NbrCommentsByUser() 
	{
		return StatisticRepository.NbrCommentsByUser();
		
		}


	@Override
	public void UpdateScoreEvaluation(int idkg) {
		
		
		KinderGarten kg = kinderrepo.findById(idkg).get();
		
		List<User> users = (List<User>) userrepo.findAll();
		
		
			for (User u : users)
			{
				if ( idkg == u.getKinderGartenInscription().getId())
				{
					kg.setScoreEval((float) ( 0.1 * (StatisticRepository.countNbrLikes(u.getId())) + 
							0.2 * (StatisticRepository.countNbrCommentaires(u.getId()))
							+ 0.4 * (StatisticRepository.countNbrPublications(u.getId())) 
							+ 0.3 * (formstatisrepo.getNombreReponsesUser(u.getId()))
							));
					
					kinderrepo.save(kg);
				}
			}
		
		
	}


	

	
	
	
}