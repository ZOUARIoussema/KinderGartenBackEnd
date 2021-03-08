package tn.esprit.spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Vote;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.repository.IVoteRepository;
import tn.esprit.spring.service.interfaceS.IVoteService;


@Service
public class VoteService implements IVoteService{
	@Autowired
	IVoteRepository iVoteRepository;
	@Autowired
	IUserRepository iUserRepository;

	public int addVote(int kindergartenId,Vote vote){
		//User u =iUserRepository.findById(vote.getVotedFor()).orElse(null);
		User u =iUserRepository.Votes(kindergartenId);
		 u =iUserRepository.findById(vote.getVotedFor()).orElse(null);
		int id = iVoteRepository.save(vote).getId();
		u.IncrementScoreDelegate();
		iUserRepository.save(u);
		return id;
		
	}
	
	
}
