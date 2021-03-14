package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class ChildVaccine implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int age;

	private String description;
	
	@ManyToMany(mappedBy = "lisChildVaccines")
	private List<FolderMedical>lisFolderMedicals = new ArrayList<FolderMedical>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	
	
	
	
	

}
