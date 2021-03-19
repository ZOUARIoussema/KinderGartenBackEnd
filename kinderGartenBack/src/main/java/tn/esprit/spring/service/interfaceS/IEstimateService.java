package tn.esprit.spring.service.interfaceS;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Estimate;


public interface IEstimateService {

	public Estimate addEstimate(Estimate estimate);
	public void updateEstimate(String item,int qte,double total,Date dateC,int estimateId);
	public List<Estimate> getAllEstimate();
	public void deleteEstimateById(int estimateId);
	public Estimate getEstimateById(int estimateId);
	
	
	
}
