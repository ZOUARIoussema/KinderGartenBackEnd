package tn.esprit.spring.service.implementation;


import java.util.Date;
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
	public void addPublication(Publication publication) {
		publication.setDate(new Date());
		publicationRepository.save(publication);	
		
	}

	@Override
	public void deletePublication(int publicationId) {
		publicationRepository.deleteById(publicationId);
		
	}
	

	@Override
	public void updateDescriptionByPublicationId(Publication p ) {
		
		publicationRepository.save(p);
	}

	@Override
	public List<Publication> getAllPublication() {
		return (List<Publication>) publicationRepository.findAll();
	}

}
