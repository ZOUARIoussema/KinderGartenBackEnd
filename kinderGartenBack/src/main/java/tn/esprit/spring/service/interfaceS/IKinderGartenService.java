package tn.esprit.spring.service.interfaceS;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.entity.User;


public interface IKinderGartenService {

	public int addKindergarten(KinderGarten kendergarten);
	public void updateKindergarten(String name,String adress,String email,int tel,String logo,int kinderId);
	public List<KinderGarten> getAllkinder();
	public void deleteKindergartenById(int kenderId);
	public KinderGarten getKindergartenById(int kinderId);
	public User delegatorsElection(int kindergartenId);
	public List<User> listDelegators(int kindergartenId);
	public void recupComptes(int idUser, int kinderId);
	public void BannedUser(int id,int kinderId);
	
	public void assignLogo(int id , MultipartFile file);
}

