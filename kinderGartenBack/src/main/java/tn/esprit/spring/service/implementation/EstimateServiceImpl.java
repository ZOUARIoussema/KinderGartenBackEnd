package tn.esprit.spring.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Club;
import tn.esprit.spring.entity.Estimate;
import tn.esprit.spring.repository.IEstimateRepository;
import tn.esprit.spring.service.interfaceS.IEstimateService;

@Service
public class EstimateServiceImpl implements IEstimateService{
	@Autowired
	IEstimateRepository iEstimateRepository;

	@Override
	public Estimate addEstimate(Estimate estimate) {
		return iEstimateRepository.save(estimate);
		
	}

	@Override
	public void updateEstimate(String item, int qte, double total, Date dateC, int estimateId) {
	
	}

	@Override
	public List<Estimate> getAllEstimate() {
		return (List<Estimate>) iEstimateRepository.findAll();

	}

	@Override
	public void deleteEstimateById(int estimateId) {
		Estimate estimate = iEstimateRepository.findById(estimateId).get();
		iEstimateRepository.delete(estimate);
		
	}

	@Override
	public Estimate getEstimateById(int estimateId) {
		return iEstimateRepository.findById(estimateId).get();
	}
}
