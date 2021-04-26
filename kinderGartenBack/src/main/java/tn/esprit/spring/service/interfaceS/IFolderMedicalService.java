package tn.esprit.spring.service.interfaceS;



import java.util.List;

import tn.esprit.spring.entity.FolderMedical;

public interface IFolderMedicalService {
	
	public void add(FolderMedical f, int id);
	public void delete(int id);
	public void update(FolderMedical f,int id);
	public FolderMedical getFolderByChild(int id);
	public void alertVaccineChildToDo();
	public FolderMedical getFolderById(int id);
	public List<FolderMedical> getAllFolder();
	public void addFolderVaccine(int idF,int idV);
	public void deleteFolderVaccine(int idF,int idV);
	
	
	

}
