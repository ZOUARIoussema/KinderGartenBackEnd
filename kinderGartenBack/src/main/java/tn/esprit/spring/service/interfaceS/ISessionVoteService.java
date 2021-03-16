package tn.esprit.spring.service.interfaceS;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.SessionVote;
import tn.esprit.spring.entity.User;

public interface ISessionVoteService {
	public int addSessionVote(SessionVote sessionVote);
	public void updateSessionVote(String winner,Date dateStart,Date dateEnd,int sessionVoteId);
	public List<SessionVote> getAllSessionVote();
	public void deleteSessionVoteById(int sessionVoteId);
	public SessionVote getSessionVoteById(int sessionVoteId);
	public User delegatorsWinner(int kindergartenId,int sessionVoteId);
}
