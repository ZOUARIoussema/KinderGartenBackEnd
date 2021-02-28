package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;

public interface IPublicationService {
		public int addPublication(Publication publication); 
		public void deletePublication (int publicationId);
		public void updateDescriptionByPublicationId(String description , int publicationId);
		public List<Publication> getAllPublication();

		
}
