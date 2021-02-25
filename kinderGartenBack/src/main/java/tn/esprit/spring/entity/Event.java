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
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	
	@ManyToOne
	private KinderGarten kinderGarten;
	
	
	
	
	
	
	
	
	
	public KinderGarten getKinderGarten() {
		return kinderGarten;
	}
	public void setKinderGarten(KinderGarten kinderGarten) {
		this.kinderGarten = kinderGarten;
	}
	 
	
	 
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	
	

}
