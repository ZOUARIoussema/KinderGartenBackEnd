package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FolderMedical implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateC;
	
	
	private String allergy;
	
	private String particularity;
	
	@OneToOne
	private Child child;
	
	
	
	
	
	
	
	
	

	 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateC() {
		return dateC;
	}

	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getParticularity() {
		return particularity;
	}

	public void setParticularity(String particularity) {
		this.particularity = particularity;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
	
	
	
	
	
	
	
 
	

}
