package tn.esprit.spring.service.implementation;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public List<Publication> getAllPublication() {
		return (List<Publication>) publicationRepository.findAll();
	}

	@Override
	public void update(Publication publication) {
		publicationRepository.save(publication);
		
	}

	@Override
	public void assignAttachementToPost(int id, MultipartFile file) {
		Publication p = publicationRepository.findById(id).orElse(null);
		if (p!=null){
			p.setAttachment(file.getOriginalFilename());
			this.update(p);
		}
		
	}

	@Override
	public List<Publication> getPublicationDesc() {
		return (List<Publication>)publicationRepository.getAllPublicationByNbrLike();
	}

	@Override
	public Publication getPublicationById(int id) {
		return publicationRepository.findById(id).orElse(null);
	}

	@Override
	public int addLike(int id) {
		Publication p= publicationRepository.findById(id).orElse(null);
		p.incriment();
		int idp = publicationRepository.save(p).getId();
		return idp;
		
	}

	@Override
	public int addDisLike(int id) {
		Publication p= publicationRepository.findById(id).orElse(null);
		p.incrimentDislike();
		int idp = publicationRepository.save(p).getId();
		return idp;
	}

	

}
