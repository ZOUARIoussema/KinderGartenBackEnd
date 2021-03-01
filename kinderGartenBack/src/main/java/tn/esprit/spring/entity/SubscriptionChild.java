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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SubscriptionChild implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date dateC;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateStart;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateEnd;

	private double total;
	private double totalPay;
	private double restPay;

	@ManyToOne
	private CategorySubscription categorySubscription;

	@ManyToOne
	private Extra extra;

	@ManyToOne
	private Child child;

	@OneToMany(mappedBy = "subscriptionChild")
	private List<PayementSubscription> listPayementSubscriptions = new ArrayList<PayementSubscription>();

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public CategorySubscription getCategorySubscription() {
		return categorySubscription;
	}

	public void setCategorySubscription(CategorySubscription categorySubscription) {
		this.categorySubscription = categorySubscription;
	}

	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<PayementSubscription> getListPayementSubscriptions() {
		return listPayementSubscriptions;
	}

	public void setListPayementSubscriptions(List<PayementSubscription> listPayementSubscriptions) {
		this.listPayementSubscriptions = listPayementSubscriptions;
	}

	public Date getDateC() {
		return dateC;
	}

	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(double totalPay) {
		this.totalPay = totalPay;
	}

	public double getRestPay() {
		return restPay;
	}

	public void setRestPay(double restPay) {
		this.restPay = restPay;
	}

}
