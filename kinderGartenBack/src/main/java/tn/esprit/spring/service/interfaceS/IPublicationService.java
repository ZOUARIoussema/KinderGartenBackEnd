package tn.esprit.spring.service.interfaceS;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;

public interface IPublicationService {
		public void addPublication(Publication publication); 
		public void deletePublication (int publicationId);
		public void update(Publication publication );
		public void assignAttachementToPost(int id , MultipartFile file);
		public List<Publication> getAllPublication();
		public List<Publication> getPublicationDesc();
		public Publication getPublicationById(int id);

		
}
