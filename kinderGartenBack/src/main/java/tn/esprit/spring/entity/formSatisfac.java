package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class formSatisfac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date date_debut;
	
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	
	private Integer nbr_reponses;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JsonIgnore
	private User ParentStatisfac;

	

	public User getParentStatisfac() {
		return ParentStatisfac;
	}

	public void setParentStatisfac(User parentStatisfac) {
		ParentStatisfac = parentStatisfac;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Integer getNbr_reponses() {
		return nbr_reponses;
	}

	public void setNbr_reponses(Integer nbr_reponses) {
		this.nbr_reponses = nbr_reponses;
	}
	
	
	
}
