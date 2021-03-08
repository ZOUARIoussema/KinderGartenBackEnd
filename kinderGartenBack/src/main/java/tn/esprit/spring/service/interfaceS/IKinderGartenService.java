package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.User;


public interface IKinderGartenService {

	public int addKindergarten(KinderGarten kendergarten);
	public void updateKindergarten(String name,String adress,String email,int tel,String logo,int kinderId);
	public List<KinderGarten> getAllkinder();
	public void deleteKindergartenById(int kenderId);
	public KinderGarten getKindergartenById(int kinderId);
	public void affecterKinderAResponsible(int kinderId, int ReponsibleId);
	public User delegatorsElection(int kindergartenId);
	public List<User> listDelegators(int kindergartenId);

}

