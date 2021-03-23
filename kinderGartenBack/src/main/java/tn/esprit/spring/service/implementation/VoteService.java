package tn.esprit.spring.service.implementation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.SessionVote;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Vote;
import tn.esprit.spring.entity.VoteForm;
import tn.esprit.spring.repository.ISessionVoteRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.repository.IVoteRepository;
import tn.esprit.spring.service.interfaceS.IVoteService;

@Service
public class VoteService implements IVoteService {
	@Autowired
	IVoteRepository iVoteRepository;
	@Autowired
	IUserRepository iUserRepository;
	@Autowired
	ISessionVoteRepository iSessionVoteRepository;

	public int addVote(int kindergartenId, VoteForm voteform, int idsession) {
		Date date = new Date();
		SessionVote s = iSessionVoteRepository.findById(idsession).orElse(null);
		User voter = iUserRepository.findById(voteform.getVoter()).orElse(null);
		User votedFor = iUserRepository.findById(voteform.getVotedFor()).orElse(null);
		if (voter.getKinderGartenInscription().getId() == votedFor.getKinderGartenInscription().getId()) {
			if (voter.getKinderGartenInscription().getId() == kindergartenId) {
				User u = iUserRepository.findById(voteform.getVotedFor()).orElse(null);

				Vote vote = new Vote(0, voter, votedFor, date);
				if (vote.getDateVote().before(s.getDateEnd()) && vote.getDateVote().after(s.getDateStart())) {

					int id = iVoteRepository.save(vote).getId();
					vote.setSessionVote(s);
					u.IncrementScoreDelegate();
					iUserRepository.save(u);

				return id;
				}else{
					System.out.println("session has been terminated");
				}

			}
		}
		return 0;

	}
}
