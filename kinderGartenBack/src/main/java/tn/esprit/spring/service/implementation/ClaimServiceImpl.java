package tn.esprit.spring.service.implementation;

 

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.enumeration.ClaimType;
import tn.esprit.spring.entity.enumeration.StateClaim;
import tn.esprit.spring.repository.IClaimRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.interfaceS.IClaimService;



@Service
public class ClaimServiceImpl implements IClaimService {
	
	@Autowired
	IClaimRepository claimsRepo;
	
	@Autowired
	IUserRepository userrepo;
	
	@Override
	public List<Claim> getAllClaims() {
		
	List<Claim> claims = (List<Claim>) claimsRepo.findAll();
	
	return claims;
		
	}

	@Override
	public String ChangeStateClaim(int claim) 
	{
		Claim c = claimsRepo.findById(claim).get();
		
	
		
		if (c.getState().equals(StateClaim.InProgress.toString()))
			
		{
			c.setState(StateClaim.closing.toString());
			claimsRepo.save(c);
			return "state claim " +claim+" is changed to closed !! " ;
	
		}
			
		else return "there is an error ";
	}

	@Override
	public List<Claim> SearchClaimByType(String Type) {
		
		return (List<Claim>) claimsRepo.searchClaimByType(Type);
	}
	
	

	@Override
	public List<Claim> SearchClaimByParent(String parentname) {
				
		List<Claim> listclaims = (List<Claim>) claimsRepo.findAll();
		
		return listclaims.stream().filter(c-> c.getParent().getFirstName().toLowerCase().contains(parentname)).collect(Collectors.toList());
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
	
	public List<String> getAllParents()
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
	public int addClaim(Claim c,int iduser) 
	{
		c.setCreation_date(new Date());
		c.setParent(userrepo.findById(iduser).get());
		c.setState(StateClaim.InProgress.toString());
		return claimsRepo.save(c).getId();

	}

	
	
}
