package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.SessionVote;
import tn.esprit.spring.repository.ISessionVoteRepository;
import tn.esprit.spring.service.interfaceS.ISessionVoteService;

@Service
public class SessionVoteServiceImpl implements ISessionVoteService{
	@Autowired
	ISessionVoteRepository iSessionVoteRepository;

	@Override
	public int addSessionVote(SessionVote sessionVote) {
		iSessionVoteRepository.save(sessionVote);
		return sessionVote.getId();
	}

	@Override
	public void updateSessionVote(String winner, Date dateStart, Date dateEnd, int sessionVoteId) {
		iSessionVoteRepository.updateSessionVoteJPQL(winner, dateStart, dateEnd, sessionVoteId);
		
	}

	@Override
	public List<SessionVote> getAllSessionVote() {
		return (List<SessionVote>) iSessionVoteRepository.findAll();
	}

	@Override
	public void deleteSessionVoteById(int sessionVoteId) {
		SessionVote sessionVote = iSessionVoteRepository.findById(sessionVoteId).get();
		iSessionVoteRepository.delete(sessionVote);
	}

	@Override
	public SessionVote getSessionVoteById(int sessionVoteId) {
		return iSessionVoteRepository.findById(sessionVoteId).get();
	}
}
