package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class KinderGarten implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String adress;

	private String email;

	private int tel;

	private int scoreEval;

	private String logo;

	@OneToMany(mappedBy = "kinderGartenInscription")
	private List<User> listParent = new ArrayList<User>();

	@OneToMany(mappedBy = "kinderGarten")
	private List<Club> listClub = new ArrayList<Club>();

	@OneToMany(mappedBy = "kinderGarten")
	private List<Event> listEvent = new ArrayList<Event>();

	@OneToMany(mappedBy = "kinderGarten")
	private List<Activity> listActivity = new ArrayList<Activity>();

	@OneToMany(mappedBy = "kinderGarten")
	private List<Extra> listExtra = new ArrayList<Extra>();

	@OneToMany(mappedBy = "kinderGarten")
	private List<CategorySubscription> listCategoryS = new ArrayList<CategorySubscription>();

	@OneToMany(mappedBy = "kinderGarten")
	private List<Meeting> listMeeting = new ArrayList<Meeting>();

	public List<Event> getListEvent() {
		return listEvent;
	}

	public void setListEvent(List<Event> listEvent) {
		this.listEvent = listEvent;
	}

	public List<Activity> getListActivity() {
		return listActivity;
	}

	public void setListActivity(List<Activity> listActivity) {
		this.listActivity = listActivity;
	}

	public List<Extra> getListExtra() {
		return listExtra;
	}

	public void setListExtra(List<Extra> listExtra) {
		this.listExtra = listExtra;
	}

	public List<CategorySubscription> getListCategoryS() {
		return listCategoryS;
	}

	public void setListCategoryS(List<CategorySubscription> listCategoryS) {
		this.listCategoryS = listCategoryS;
	}

	public List<Meeting> getListMeeting() {
		return listMeeting;
	}

	public void setListMeeting(List<Meeting> listMeeting) {
		this.listMeeting = listMeeting;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<User> getListParent() {
		return listParent;
	}

	public void setListParent(List<User> listParent) {
		this.listParent = listParent;
	}

	public List<Club> getListClub() {
		return listClub;
	}

	public void setListClub(List<Club> listClub) {
		this.listClub = listClub;
	}

	public User getResponsible() {
		return responsible;
	}

	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}

	public User getDelegate() {
		return delegate;
	}

	public void setDelegate(User delegate) {
		this.delegate = delegate;
	}

	@OneToOne
	private User responsible;

	@OneToOne
	private User delegate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getScoreEval() {
		return scoreEval;
	}

	public void setScoreEval(int scoreEval) {
		this.scoreEval = scoreEval;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
