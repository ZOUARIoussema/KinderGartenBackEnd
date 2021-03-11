package tn.esprit.spring.service.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.IStatisticsRepository;
import tn.esprit.spring.service.interfaceS.IStatisticsService;


@Service
public class StatisticsServiceImpl implements IStatisticsService {

	@Autowired
    private IStatisticsRepository StatisticRepository;
	

	@Override
	public List<?> listChildByKinderGarten() {
		
		return StatisticRepository.listChildByKinderGarten();
	}

	@Override
	public int NbrCommentsByUser(int userid) {
		return StatisticRepository.NbrCommentsByUser(userid);
	}

	@Override
	public int NbrLikeByUser(int userid) {
		
		return StatisticRepository.NbrLikeByUser(userid);
	}

	@Override
	public int nbrPublicationByUser(int userid) {
		return StatisticRepository.nbrPublicationByUser(userid);
	}

	@Override
	public int nbrParticpEventByUser(int userid)
	{
	//	return StatisticRepository.nbrParticpEventByUser(userid);
		return 0;
	}

	@Override
	public List<?> BestUser() {
		return StatisticRepository.BestUser();
	}

	@Override
	public int nbrChildByKinderGarten(int kgid) {
		return StatisticRepository.nbrChildByKinderGarten(kgid);
	}

	@Override
	public int NbrChildSubscribed2021(int jardinid) {
		return 0;
	//	return StatisticRepository.NbrChildSubscribed2021(jardinid);
	}
	
	
}
