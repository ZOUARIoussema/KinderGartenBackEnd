package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ChildVaccine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int monthNumber;

	private String description;

	@JsonIgnore
	@ManyToMany(mappedBy = "lisChildVaccines")
	private List<FolderMedical> lisFolderMedicals = new ArrayList<FolderMedical>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonthNumber() {
		return monthNumber;
	}

	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FolderMedical> getLisFolderMedicals() {
		return lisFolderMedicals;
	}

	public void setLisFolderMedicals(List<FolderMedical> lisFolderMedicals) {
		this.lisFolderMedicals = lisFolderMedicals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChildVaccine other = (ChildVaccine) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	

}
