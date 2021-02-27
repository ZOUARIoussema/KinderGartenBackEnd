package tn.esprit.spring.service.implementation;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.enumeration.StateClaim;
import tn.esprit.spring.repository.IClaimRepository;
import tn.esprit.spring.service.interfaceS.IClaimService;
@Service
public class ClaimServiceImpl implements IClaimService {
	
	@Autowired
	IClaimRepository claimsRepo;

	@Override
	public List<Claim> getAllClaims() {
		
	List<Claim> claims = (List<Claim>) claimsRepo.findAll();
	
	return claims;
		
	}

	@Override
	public void ChangeStateClaim(Claim c) 
	{
		if (c.getType().equals(StateClaim.InProgress))
			
		{
			c.setType(StateClaim.closing.toString());
		}
		
	}

	@Override
	public Claim SearchClaimByType(String Type) {
		
		return claimsRepo.searchClaimByType(Type);
	}

	@Override
	public Claim SearchClaimByParent(User u) {
		
		return claimsRepo.findById(u.getId()).get();
		
	}

}
