package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.KinderGarten;


public interface IKinderGartenService {
	

	public List<KinderGarten> getAllKinderGartens();


	public int addKindergarten(KinderGarten kendergarten);
	public void updateKindergarten(String name,String adress,String email,int tel,String logo,int kinderId);
	public List<KinderGarten> getAllkinder();
	public void deleteKindergartenById(int kenderId);
	public KinderGarten getKindergartenById(int kinderId);
	public void affecterKinderAResponsible(int kinderId, int ReponsibleId);
}

