package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Child implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	@Temporal(TemporalType.DATE)
	private Date dateOfbith;

	private String sex;

	private int age;

	private String picture;

	@ManyToOne
	@JsonIgnore
	private User parent;

	@OneToMany(mappedBy = "child")
	@JsonIgnore
	private List<SubscriptionChild> lisSubscriptionChilds = new ArrayList<SubscriptionChild>();

	@OneToOne(mappedBy = "child")
	@JsonIgnore
	private FolderMedical folderMedical;
	
	
	
	
	
	
	
	
	
	
	
	

	public FolderMedical getFolderMedical() {
		return folderMedical;
	}

	public void setFolderMedical(FolderMedical folderMedical) {
		this.folderMedical = folderMedical;
	}

	public User getParent() {
		return parent;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}

	public List<SubscriptionChild> getLisSubscriptionChilds() {
		return lisSubscriptionChilds;
	}

	public void setLisSubscriptionChilds(List<SubscriptionChild> lisSubscriptionChilds) {
		this.lisSubscriptionChilds = lisSubscriptionChilds;
	}

	 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfbith() {
		return dateOfbith;
	}

	public void setDateOfbith(Date dateOfbith) {
		this.dateOfbith = dateOfbith;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
