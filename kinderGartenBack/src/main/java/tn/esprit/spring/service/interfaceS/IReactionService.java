package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Reaction;



public interface IReactionService {
	public String updateReaction(Long idUser,Long idComment,Reaction rp);
	public List<Reaction> retrieveAllLike();
	public String addReaction(Reaction r );

}
