package tn.esprit.spring.utils;

import java.util.List;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.IUserRepository;

public class kinderGartenAlgorithm {
	IKinderGartenRepository iKinderGartenRepository;
	IUserRepository iUserRepository;
	

	public double distance(double lat1, double lon1) {
		//public double distance(double lat1, double lon1, double lat2, double lon2) {

        // haversine great circle distance approximation, returns meters
	       double    lat2= 36.74451754057056;
	       double lon2=10.074587446289062;
        double theta = lon2 - lon2;
      //  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
         //       + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
          //      * Math.cos(deg2rad(theta));
     //   dist = Math.acos(dist);
     //   dist = rad2deg(dist);
     //   dist = dist * 60; // 60 nautical miles per degree of seperation
     //   dist = dist * 1852; // 1852 meters per nautical mile
        
     //   System.out.print("distance"+dist);
        return (theta);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
          }
    private void Nearsetpoint(int userId) {

    	}
    	
    
	

}
