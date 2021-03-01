package tn.esprit.spring.service.interfaceS;

import tn.esprit.spring.entity.SwitchAccount;

public interface ISwitchAccountService {


	public void RequestForSwitchingAccount(SwitchAccount sw);
	
	public int addSwitchAccount(SwitchAccount sw);
	
}
