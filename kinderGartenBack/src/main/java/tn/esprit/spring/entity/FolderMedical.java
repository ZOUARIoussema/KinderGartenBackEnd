package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToMany(mappedBy = "folderMedical")
	@JsonIgnore
	private List<Consultation> lisConsultations = new ArrayList<Consultation>();

	@ManyToMany
	private List<ChildVaccine> lisChildVaccines = new ArrayList<ChildVaccine>();

	@Transient
	private List<ChildVaccine> listVaccinesToDo = new ArrayList<ChildVaccine>();

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

	public List<Consultation> getLisConsultations() {
		return lisConsultations;
	}

	public void setLisConsultations(List<Consultation> lisConsultations) {
		this.lisConsultations = lisConsultations;
	}

	public List<ChildVaccine> getLisChildVaccines() {
		return lisChildVaccines;
	}

	public void setLisChildVaccines(List<ChildVaccine> lisChildVaccines) {
		this.lisChildVaccines = lisChildVaccines;
	}

	public List<ChildVaccine> getListVaccinesToDo() {
		return listVaccinesToDo;
	}

	public void setListVaccinesToDo(List<ChildVaccine> listVaccinesToDo) {
		this.listVaccinesToDo = listVaccinesToDo;
	}

}
