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

import tn.esprit.spring.entity.enumeration.TypePayement;

@Entity
public class PayementSubscription implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date dateC;
	
	private double price;
	
	private TypePayement typePayement;
	
	private int checkNumber;
	@Temporal(TemporalType.DATE)
	private Date dateCheck;
	
	@ManyToOne
	private SubscriptionChild subscriptionChild;
	
	@ManyToOne
	private User user;
	
	
	
	
	
	

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public TypePayement getTypePayement() {
		return typePayement;
	}

	public void setTypePayement(TypePayement typePayement) {
		this.typePayement = typePayement;
	}

	public int getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Date getDateCheck() {
		return dateCheck;
	}

	public void setDateCheck(Date dateCheck) {
		this.dateCheck = dateCheck;
	}

	public SubscriptionChild getSubscriptionChild() {
		return subscriptionChild;
	}

	public void setSubscriptionChild(SubscriptionChild subscriptionChild) {
		this.subscriptionChild = subscriptionChild;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
