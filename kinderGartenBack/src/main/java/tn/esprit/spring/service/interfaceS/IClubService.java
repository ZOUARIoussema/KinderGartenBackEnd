package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Club;


public interface IClubService {
	
	public int addClub(Club club);
	public void updateClub(String description,int clubId);
	public List<Club> getAllclub();
	public void deleteClubById(int clubId);
	public Club getClubById(int clubId);
	public void affecterClubAkinderGarten(int clubId, int kinderId);
	public void affecterCategoryAClub(int clubId, int categoryId);
}
