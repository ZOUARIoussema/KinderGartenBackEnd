package tn.esprit.spring.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.Reaction;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IReactionRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.IReactionService;
@Service
public class ReactionServiceImpl implements IReactionService {

	@Autowired
	IReactionRepository iReactionRepository;
	
	@Autowired
	IUserRepository userRepository;
	
	private static final Logger L =(Logger) LogManager.getLogger(ReactionServiceImpl.class);

	
	
	@Override
	public String updateReaction(Long idUser, Long idComment, Reaction react) {
		Reaction rp=new Reaction();
		rp = iReactionRepository.reactionExist(idUser, idComment);
		if(rp==null){
			iReactionRepository.save(react);
			return "save with success";
		}else if (rp.getReact() != react.getReact()){
			rp.setReact(react.getReact());
			iReactionRepository.save(rp);
		}
		return "update with success";
	}

	@Override
	public List<Reaction> retrieveAllLike() {
		List<Reaction> likes = (List<Reaction>)iReactionRepository.findAll();
		for (Reaction like : likes){
			L.info("user +++ : " + like);
		}
		return likes;
	}

	@Override
	public String addReaction(Reaction r) {
		List<Reaction> rct = new ArrayList<Reaction>();
		rct= (List<Reaction>) iReactionRepository.findAll();
		for (Reaction rp : rct){
			if(r.getPublication().getId() == rp.getPublication().getId() && (r.getUser().equals(rp.getUser()))){
				return "user a déja aimé cette pub";
			}
			else {
				User userManagedEntity = userRepository.findById((int) 1).get();
				Publication publication = new Publication();
				publication.setParent(userManagedEntity);
				iReactionRepository.save(r);
				
			}
		}
		return "reaction saved";
	}

}
