package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Vote  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
@Column(unique=true)
	private int voter;
@Column(nullable=false)
	private int votedFor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVoter() {
		return voter;
	}
	public void setVoter(int voter) {
		this.voter = voter;
	}
	public int getVotedFor() {
		return votedFor;
	}
	public void setVotedFor(int votedFor) {
		this.votedFor = votedFor;
	}
	
}
