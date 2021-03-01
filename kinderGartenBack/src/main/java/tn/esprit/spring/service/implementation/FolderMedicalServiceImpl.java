package tn.esprit.spring.service.implementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.FolderMedical;
import tn.esprit.spring.repository.IChildRepository;
import tn.esprit.spring.repository.IFolderMedicalRepository;
import tn.esprit.spring.service.interfaceS.IFolderMedicalService;


@Service
public class FolderMedicalServiceImpl implements IFolderMedicalService {

	@Autowired
	IFolderMedicalRepository folderR;
	@Autowired
	IChildRepository childR;

	@Override
	public void add(FolderMedical f) {

		folderR.save(f);

	}

	@Override
	public void delete(int id) {

		FolderMedical f = folderR.findById(id).orElse(null);

		if (f != null) {

			folderR.delete(f);
		}

	}

	@Override
	public void update(FolderMedical f) {

		folderR.save(f);

	}

	@Override
	public FolderMedical getFolderByChild(int id) {
		 
		Child c = childR.findById(id).orElse(null);
		
		if(c != null) {
			
			return c.getFolderMedical();
		}
		
		return null;
		
	}

	
	 
}
