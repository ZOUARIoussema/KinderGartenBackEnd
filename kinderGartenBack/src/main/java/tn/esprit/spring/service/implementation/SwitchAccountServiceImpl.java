package tn.esprit.spring.service.implementation;


import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.SwitchAccount;
import tn.esprit.spring.entity.enumeration.Role;
import tn.esprit.spring.entity.enumeration.RoleSwitch;
import tn.esprit.spring.entity.enumeration.StateUser;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.ISwitchAccountRepository;
import tn.esprit.spring.service.interfaceS.ISwitchAccountService;
@Service
public class SwitchAccountServiceImpl implements ISwitchAccountService {

	@Autowired
	ISwitchAccountRepository switchRepo;
	@Autowired
	IKinderGartenRepository iKinderGartenRepository;
	
	@Override
	public void RequestForSwitchingAccount(SwitchAccount sw) 
	{
		if (sw.getRoleswitch().equals(RoleSwitch.futureParent) || sw.getState().equals(StateUser.watting))
			
		{
			sw.getVisitor().setRole(Role.ROLE_futurParent);
			sw.getVisitor().setStateUser(StateUser.active);
			sw.setDateC(new Date());
		}
		
		if (sw.getRoleswitch().equals(RoleSwitch.adminGarten))
		{
			sw.getVisitor().equals(Role.ROLE_adminGarten);
			sw.getVisitor().setStateUser(StateUser.active);
			sw.setDateC(new Date());
		}
		
	}

	@Override
	public int addSwitchAccount(SwitchAccount switchaccount) 
	{
		
	switchRepo.save(switchaccount);
		
	return switchaccount.getId();
			
	}

	@Override
	public List<KinderGarten> getKinderGartenByAdress(String adress) {

		return iKinderGartenRepository.findByAdress(adress);
	}


	@Override
	public List<KinderGarten> getAllKinderGarden() {
		// TODO Auto-generated method stub
		return iKinderGartenRepository.findAll();
	}


}
