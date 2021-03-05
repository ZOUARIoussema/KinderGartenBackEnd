package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;

public interface IPublicationService {
		public void addPublication(Publication publication); 
		public void deletePublication (int publicationId);
		public void updateDescriptionByPublicationId(Publication p );
		public List<Publication> getAllPublication();

		
}
