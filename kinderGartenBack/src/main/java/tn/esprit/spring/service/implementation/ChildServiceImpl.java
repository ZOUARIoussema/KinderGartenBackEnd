package tn.esprit.spring.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.SubscriptionChild;
import tn.esprit.spring.repository.IChildRepository;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.repository.ISubscriptionChildRepository;
import tn.esprit.spring.service.interfaceS.IChildService;
@Service
public class ChildServiceImpl implements IChildService {

	@Autowired
	IChildRepository childRepository;
	@Autowired
	ISubscriptionChildRepository subscriptionChildRepository;
	
	@Override
	public int addChild(Child child) {
		return childRepository.save(child).getId();
	}
	@Override
	public List<Child> getAllChild() {
		return (List<Child>) childRepository.findAll();
	}
	
		
	

	
}
