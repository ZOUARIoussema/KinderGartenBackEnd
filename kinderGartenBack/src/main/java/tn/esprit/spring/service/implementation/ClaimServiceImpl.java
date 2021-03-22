package tn.esprit.spring.service.implementation;

 
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.enumeration.ClaimType;
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

	@Override
	public int countClaimsinKinderGarten(int idkinder) {
		
		return claimsRepo.countNbrClaimsKindergarten(idkinder);
	}
	
	public Claim getClaimsById(int id)
	{
		return claimsRepo.findById(id).get();
	}
	
	
	public List<Claim> getClaimsByObject()
	{
		return claimsRepo.getClaimsByObject();
		 
	}
	
	public List<User> getAllParents()
	{
		return  claimsRepo.getAllParents();
	}

	@Override
	public List<Claim> getClaimsByEducation() 
	{
		List<Claim> listeClaims = (List<Claim>) claimsRepo.findAll();
		return listeClaims.stream().filter(a -> a.getType().equals(ClaimType.education.toString())).collect(Collectors.toList());	
	}
	
	@Override
	public List<Claim> getClaimsByCleanliness()
	{
		List<Claim> listeClaims = (List<Claim>) claimsRepo.findAll();
		return listeClaims.stream().filter(a -> a.getType().equals(ClaimType.cleanliness.toString())).collect(Collectors.toList());	
	}

	@Override
	public void deleteClaim(int id) {
		Claim c = claimsRepo.findById(id).get();
		claimsRepo.delete(c);
	}

	@Override
	public int addClaim(Claim c) {
		return claimsRepo.save(c).getId();
		
		
	}
}
