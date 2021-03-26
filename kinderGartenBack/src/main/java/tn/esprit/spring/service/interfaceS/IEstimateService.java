package tn.esprit.spring.service.interfaceS;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Estimate;


public interface IEstimateService {

	public void addEstimate(int providerId,int kinderId,String item,int qte,double total ) ;
	//public void updateEstimate(Estimate estimate);
	public List<Estimate> getAllEstimate();
	//public void deleteEstimateById(int estimateId);
	public List<Estimate> getEstimateByKinderAndProvider(int kinderId,int ProviderId);
	
	
	
}
