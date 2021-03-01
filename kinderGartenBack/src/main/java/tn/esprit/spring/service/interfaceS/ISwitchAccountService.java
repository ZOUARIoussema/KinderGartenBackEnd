package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.SwitchAccount;

public interface ISwitchAccountService {


	public void RequestForSwitchingAccount(SwitchAccount sw);
	
	public int addSwitchAccount(SwitchAccount switchaccount);
	public List<KinderGarten> getKinderGarten(String adress);
	
}
