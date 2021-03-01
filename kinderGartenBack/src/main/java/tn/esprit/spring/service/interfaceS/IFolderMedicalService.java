package tn.esprit.spring.service.interfaceS;



import tn.esprit.spring.entity.FolderMedical;

public interface IFolderMedicalService {
	
	public void add(FolderMedical f);
	public void delete(int id);
	public void update(FolderMedical f);
	public FolderMedical getFolderByChild(int id);
	

}
