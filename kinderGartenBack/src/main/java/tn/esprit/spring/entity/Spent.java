package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.esprit.spring.entity.enumeration.TypeSepent;
@Entity
public class Spent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String description;
	private double total ;
	@Enumerated(EnumType.STRING)
	private TypeSepent type;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateC;
	
	
	@ManyToOne
	private User agentCashier;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public TypeSepent getType() {
		return type;
	}


	public void setType(TypeSepent type) {
		this.type = type;
	}


	public User getAgentCashier() {
		return agentCashier;
	}


	public void setAgentCashier(User agentCashie) {
		this.agentCashier = agentCashie;
	}


	public Date getDateC() {
		return dateC;
	}


	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}
	
	
	
	
	
	
	

}
