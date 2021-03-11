package tn.esprit.spring.service.interfaceS;

import java.util.List;

public interface IStatisticsService {

	public List<?> listChildByKinderGarten();

	public int NbrCommentsByUser(int userid);

	public int NbrLikeByUser(int userid);

	public int nbrPublicationByUser(int userid);

	public int nbrParticpEventByUser(int userid);

	public List<?> BestUser();

	public int nbrChildByKinderGarten(int kgid);

	public int NbrChildSubscribed2021(int jardinid);
}
