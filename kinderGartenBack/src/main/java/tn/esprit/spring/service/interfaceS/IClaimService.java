package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.User;

public interface IClaimService {
	
	public List<Claim> getAllClaims();
	public void ChangeStateClaim (Claim c);
	public Claim SearchClaimByType(String Type);
	public Claim SearchClaimByParent(User u);

	
	
	
}
