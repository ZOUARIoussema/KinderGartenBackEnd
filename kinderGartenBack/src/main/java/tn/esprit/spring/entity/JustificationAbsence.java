package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class JustificationAbsence implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String Description;
	
	
	
	
	@ManyToOne
	private User parent;
	
	
	
	
	
	
	
	
	
	
	
	
	public User getParent() {
		return parent;
	}
	public void setParent(User parent) {
		this.parent = parent;
	}
	  
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
	

}
