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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Publication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date date;
	private String description;
	private int numberLike;
	private int numberDislike;
	private String attachment;

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@ManyToOne
	//@JsonIgnore
	private User parent;
	@JsonIgnore
	@OneToMany(mappedBy = "publication")
	private List<Comment> listComments = new ArrayList<Comment>();

	@OneToMany(mappedBy = "publication")
	@JsonIgnore
	private List<Reaction> lisReactions = new ArrayList<Reaction>();

	public List<Comment> getListComments() {
		return listComments;
	}

	public void setListComments(List<Comment> listComments) {
		this.listComments = listComments;
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
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberLike() {
		return numberLike;
	}

	public void setNumberLike(int numberLike) {
		this.numberLike = numberLike;
	}

	public int getNumberDislike() {
		return numberDislike;
	}

	public void setNumberDislike(int numberDislike) {
		this.numberDislike = numberDislike;
	}

	public User getParent() {
		return parent;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}
	 public void incriment() {
         this.numberLike++;
     }
	 public void incrimentDislike() {
         this.numberDislike++;
     }

}
