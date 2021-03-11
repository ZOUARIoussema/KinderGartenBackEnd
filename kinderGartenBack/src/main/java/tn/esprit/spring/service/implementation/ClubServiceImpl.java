package tn.esprit.spring.service.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Club;
import tn.esprit.spring.entity.Extra;
import tn.esprit.spring.entity.KinderGarten;
import tn.esprit.spring.repository.ICategoryRepository;
import tn.esprit.spring.repository.IClubRepository;
import tn.esprit.spring.repository.IKinderGartenRepository;
import tn.esprit.spring.service.interfaceS.IClubService;
@Service
public class ClubServiceImpl implements IClubService {
	@Autowired
	IKinderGartenRepository kinderRepo;
	@Autowired
	IClubRepository iClubRepository;
	@Autowired
	ICategoryRepository iCategoryRepository;
	
	@Override
	public int addClub(Club club) {
		iClubRepository.save(club);
		return club.getId();
	}

	@Override
	public void updateClub(String description, int clubId) {
		iClubRepository.updateClubJPQL(description, clubId);
		
	}

	@Override
	public List<Club> getAllclub() {
		return (List<Club>) iClubRepository.findAll();
	}

	@Override
	public void deleteClubById(int clubId) {
		Club club = iClubRepository.findById(clubId).get();
		iClubRepository.delete(club);
	}

	@Override
	public Club getClubById(int clubId) {
		return iClubRepository.findById(clubId).get();

	}

	@Override
	public void affecterClubAkinderGarten(int clubId, int kinderId) {
		KinderGarten kinderManagedEntity = kinderRepo.findById(kinderId).get();
		Club clubManagedEntity = iClubRepository.findById(clubId).get();
		
//		clubManagedEntity.setKinderGarten(kinderManagedEntity);
//		iClubRepository.save(clubManagedEntity);
		
	}

	@Override
	public void affecterCategoryAClub(int clubId, int categoryId) {
		Category categoryManagedEntity = iCategoryRepository.findById(categoryId).get();
		Club clubManagedEntity = iClubRepository.findById(clubId).get();

		clubManagedEntity.setCategory(categoryManagedEntity);;
		iClubRepository.save(clubManagedEntity);
		
		
	}

}
