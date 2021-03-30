package tn.esprit.spring.service.interfaceS;

import java.util.List;

public interface IStatisticsService {

	public List<?> listChildByKinderGarten();

	//public int NbrCommentsByUser(int userid);

	public List<?> NbrLikeByUser();

	public List<?> nbrPublicationByUser();

	public List<?> numberParticipEventKinderGaten();


	public int NbrChildSubscribed2021(int jardinid);
}
