package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Spent;

public interface ISpentService {
	
	public void add(Spent s);
	public void delete(int id);
	public void update(Spent s);
	public List<Spent> getAllByAgentCashier(int id);

}
