package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Club;


public interface IClubService {
	
	public void addClub(Club club, int id);
	public void updateClub(String description,int clubId);
	public List<Club> getAllclub();
	public void deleteClubById(int clubId);
	public Club getClubById(int clubId);
	public void affecterClubACategory(int clubId, int categoryId);
}
