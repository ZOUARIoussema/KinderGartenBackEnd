package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Vote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private User voter;
	@ManyToOne
	private User votedFor;
	@Temporal(TemporalType.DATE)
	private Date dateVote;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getVoter() {
		return voter;
	}

	public void setVoter(User voter) {
		this.voter = voter;
	}

	public User getVotedFor() {
		return votedFor;
	}

	public void setVotedFor(User votedFor) {
		this.votedFor = votedFor;
	}

	public Date getDateVote() {
		return dateVote;
	}

	public void setDateVote(Date dateVote) {
		this.dateVote = dateVote;
	}

	public Vote(int id, User voter, User votedFor ,Date dateVote) {
		super();
		this.id = id;
		this.voter = voter;
		this.votedFor = votedFor;
		this.dateVote = dateVote;
		}


}
