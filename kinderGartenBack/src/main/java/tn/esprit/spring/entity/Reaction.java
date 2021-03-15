package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.entity.enumeration.React;

@Entity
public class Reaction implements Serializable {

	private static final long serialVersionUID = 3876346912862238239L;

	@EmbeddedId
	private ReactionPK likePk;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private User user;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPublication", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private Publication publication;

	@Enumerated(EnumType.STRING)
	React React;

	@Column(name = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private ZonedDateTime date;

	public ReactionPK getLikePk() {
		return likePk;
	}

	public void setLikePk(ReactionPK likePk) {
		this.likePk = likePk;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public React getReact() {
		return React;
	}

	public void setReact(React react) {
		React = react;
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

}
