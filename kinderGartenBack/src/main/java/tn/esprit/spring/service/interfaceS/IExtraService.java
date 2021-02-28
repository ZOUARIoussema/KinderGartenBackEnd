package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Extra;

public interface IExtraService {
	public int addExtra(Extra extra);
	public void updateExtra(String description,double price,int ExtraId);
	public List<Extra> getAllextra();
	public void deleteExtraById(int extraId);
	public Extra getExtraById(int extraId);
	public void affecterExtraAkinderGarten(int extraId, int kinderId);
}
