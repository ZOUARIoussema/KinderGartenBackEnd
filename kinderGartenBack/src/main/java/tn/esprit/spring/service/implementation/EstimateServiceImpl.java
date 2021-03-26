package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Club;
import tn.esprit.spring.entity.Estimate;
import tn.esprit.spring.entity.PKEstimate;
import tn.esprit.spring.repository.IEstimateRepository;
import tn.esprit.spring.service.interfaceS.IEstimateService;

@Service
public class EstimateServiceImpl implements IEstimateService{
	@Autowired
	IEstimateRepository iEstimateRepository;

	@Override
	public void addEstimate(int providerId,int kinderId,String item,int qte,double total ) {
		PKEstimate pk= new  PKEstimate();
		Estimate e= new Estimate();
		pk.setDateC(new Date());
		pk.setIdKinder(kinderId);
		pk.setIdUser(providerId);
		e.setItem(item);
		e.setQte(qte);
		e.setTotal(total);
		e.setPkEstimate(pk);
		iEstimateRepository.save(e);
		
	}

	/*@Override
	public void updateEstimate(Estimate estimate) {
		iEstimateRepository.save(estimate);
	}
*/
	@Override
	public List<Estimate> getAllEstimate() {
		return (List<Estimate>) iEstimateRepository.findAll();

	}

	@Override
	public List<Estimate> getEstimateByKinderAndProvider(int kinderId, int ProviderId) {
		return iEstimateRepository.getEstimateByKinderAndProviderJPQL(kinderId, ProviderId);
	}

}
