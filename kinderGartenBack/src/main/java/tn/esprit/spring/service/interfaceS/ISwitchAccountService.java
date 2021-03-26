package tn.esprit.spring.service.interfaceS;


import java.util.List;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.SwitchAccount;
import tn.esprit.spring.entity.User;

public interface ISwitchAccountService {


	public void RequestForSwitchingAccount(SwitchAccount sw);
	
	public int addSwitchAccount(SwitchAccount switchaccount);
	
	public List<KinderGarten> getKinderGartenByAdress(String adress);
//method call of get all kindergarden
	public List<KinderGarten> getAllKinderGarden();
	//method call of nearpoint
	public List<KinderGarten> Nearpoint(double lat1, double lon1);
	//methode caal of getreactparent

	public List<Integer> getNumbereventbycategry(int kindergartenId);
	

}
