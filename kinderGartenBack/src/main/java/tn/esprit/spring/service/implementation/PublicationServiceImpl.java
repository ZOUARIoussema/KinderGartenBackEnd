package tn.esprit.spring.service.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.repository.ICommentRepository;
import tn.esprit.spring.repository.IPublicationRepository;
import tn.esprit.spring.service.interfaceS.IPublicationService;
@Service
public class PublicationServiceImpl implements IPublicationService {
	
	@Autowired
	IPublicationRepository publicationRepository;
	
	

	@Override
	public int addPublication(Publication publication) {
		publicationRepository.save(publication);
		return publication.getId();
		
	}

	@Override
	public void deletePublication(int publicationId) {
		publicationRepository.deleteById(publicationId);
		
	}
	

	@Override
	public void updateDescriptionByPublicationId(String description, int publicationId) {
		Publication publication = publicationRepository.findById(publicationId).get();
		publication.setDescription(description);
		publicationRepository.save(publication);
	}

	@Override
	public List<Publication> getAllPublication() {
		return (List<Publication>) publicationRepository.findAll();
	}

}
