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
	public int NbrChildSubscribed2021(int jardinid) {
		// TODO Auto-generated method stub
		return 0;
	}


	

	
	
	
}
