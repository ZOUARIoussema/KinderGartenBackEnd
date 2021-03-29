package tn.esprit.spring.service.implementation;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.SwitchAccount;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.enumeration.Role;
import tn.esprit.spring.entity.enumeration.RoleSwitch;
import tn.esprit.spring.entity.enumeration.StateUser;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.IMyMessageRep;
import tn.esprit.spring.repository.ISwitchAccountRepository;
import tn.esprit.spring.service.interfaceS.ISwitchAccountService;
@Service
public class SwitchAccountServiceImpl implements ISwitchAccountService {

	@Autowired
	ISwitchAccountRepository switchRepo;

	@Autowired
	IMyMessageRep iMyMessageRep;
	@Autowired
	IKinderGartenRepository iKinderGartenRepository;
	
	@Override
	public void RequestForSwitchingAccount(SwitchAccount sw) 
	{
		if (sw.getRoleswitch().equals(RoleSwitch.futureParent) || sw.getState().equals(StateUser.waiting))
			
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
		return iKinderGartenRepository.findAll();
	}
	

	//This function converts decimal degrees to radians
	//Latitude and Longitude in the formula must be radians
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
//This function converts radians to decimal degrees
    //
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
          }


	// /calculating-distance-between-two-points-using-latitude-longitude Uses Haversine(
    //(determines the great-circle distance between two points on a sphere given their 
    //longitudes and latitudes) method as its base
	public double distance2(double lat1, double lon1, double    lat2, double lon2) {
	     /*  double    lat2= 36.74451754057056;
	       double lon2=10.074587446289062;*/
	 		double theta = lon1 - lon2;
	        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
	                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
	                * Math.cos(deg2rad(theta));
	        dist = Math.acos(dist);
	        dist = rad2deg(dist);
	        dist = dist * 60; // 60 nautical miles per degree of seperation
	        dist = dist * 1852; // 1852 meters per nautical mile
	        return (dist);
	 
	}
//function that calculating the nearest point between the list of all kindergarden
	//in the fisrt time we made a list of kindergarden that get all the kindergarden
	@Override
	public  List<KinderGarten> Nearpoint(double lat1, double lon1) {
		List<KinderGarten> kindergartens =getAllKinderGarden();
		List<KinderGarten> Nearpoints=new  ArrayList();
		
		for(int i=0;i<kindergartens.size();i++)
		{
			if(distance2(lat1, lon1,kindergartens.get(i).getLatitude(),kindergartens.get(i).getLongitude())<3000)
			{
				Nearpoints.add(kindergartens.get(i));
			}
			}
		return Nearpoints;
		
	}

	@Override
	public List<Message> getmail(int id) {
		
		return iMyMessageRep.getmail(id);
	}

	@Override
	public void SendMail(Message message) {
		  iMyMessageRep.save(message);
		
	}

}
  
	
	

