package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.entity.enumeration.Role;
import tn.esprit.spring.entity.enumeration.StateUser;

@Entity
public class User implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lasName;
	private String address;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Enumerated(EnumType.STRING)
	private StateUser stateUser;
	private int tel	;
	@Temporal(TemporalType.DATE)
	private Date dateC;
	private int scoreDelegate;
	private String email;
	
	private String password;
	
	
	
	@OneToMany(mappedBy = "parent")
	private List<Claim>listClaims = new ArrayList<Claim>();
	
	@OneToMany(mappedBy = "parent")
	private List<Notice>listNotices = new ArrayList<Notice>();
	
	@OneToMany(mappedBy = "parent")
	private List<JustificationAbsence>listJustificationAdsences = new ArrayList<JustificationAbsence>();
	
	@OneToMany(mappedBy = "parent")
	private List<Publication>listPublications = new ArrayList<Publication>();
	
	@OneToMany(mappedBy = "parent")
	private List<Comment>lisCommentst = new ArrayList<Comment>();
	
	
	@OneToMany(mappedBy = "parent")
	private List<Child>listChilds = new ArrayList<Child>();
	
	@OneToOne(mappedBy = "visitor")
	private SwitchAccount switchAccount;
	
	
	@ManyToOne 
	private KinderGarten kinderGartenInscription;
	
	@OneToOne(mappedBy = "responsible")
	private KinderGarten kinderGartenResponsible;
	
	
	@OneToOne(mappedBy = "delegate")
	private KinderGarten kinderGartenDelegate;
	
	 
	@OneToMany(mappedBy = "doctor")
	private List<Consultation>listConsultations = new ArrayList<Consultation>();
	
	
	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	private List<MedicalVisitKinderGarten>listMedicalVisitKinderGartens = new ArrayList<MedicalVisitKinderGarten>();
	
	
	
	
	
	
	
	
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Consultation> getListConsultations() {
		return listConsultations;
	}
	public void setListConsultations(List<Consultation> listConsultations) {
		this.listConsultations = listConsultations;
	}
	public List<MedicalVisitKinderGarten> getListMedicalVisitKinderGartens() {
		return listMedicalVisitKinderGartens;
	}
	public void setListMedicalVisitKinderGartens(List<MedicalVisitKinderGarten> listMedicalVisitKinderGartens) {
		this.listMedicalVisitKinderGartens = listMedicalVisitKinderGartens;
	}
	public KinderGarten getKinderGartenDelegate() {
		return kinderGartenDelegate;
	}
	public void setKinderGartenDelegate(KinderGarten kinderGartenDelegate) {
		this.kinderGartenDelegate = kinderGartenDelegate;
	}
	public KinderGarten getKinderGartenInscription() {
		return kinderGartenInscription;
	}
	public void setKinderGartenInscription(KinderGarten kinderGartenInscription) {
		this.kinderGartenInscription = kinderGartenInscription;
	}
	public KinderGarten getKinderGartenResponsible() {
		return kinderGartenResponsible;
	}
	public void setKinderGartenResponsible(KinderGarten kinderGartenResponsible) {
		this.kinderGartenResponsible = kinderGartenResponsible;
	}
	public SwitchAccount getSwitchAccount() {
		return switchAccount;
	}
	public void setSwitchAccount(SwitchAccount switchAccount) {
		this.switchAccount = switchAccount;
	}
	public List<Child> getListChilds() {
		return listChilds;
	}
	public void setListChilds(List<Child> listChilds) {
		this.listChilds = listChilds;
	}
	public List<Publication> getListPublications() {
		return listPublications;
	}
	public void setListPublications(List<Publication> listPublications) {
		this.listPublications = listPublications;
	}
	public List<Comment> getLisCommentst() {
		return lisCommentst;
	}
	public void setLisCommentst(List<Comment> lisCommentst) {
		this.lisCommentst = lisCommentst;
	}
	public List<Claim> getListClaims() {
		return listClaims;
	}
	public void setListClaims(List<Claim> listClaims) {
		this.listClaims = listClaims;
	}
	public List<Notice> getListNotices() {
		return listNotices;
	}
	public void setListNotices(List<Notice> listNotices) {
		this.listNotices = listNotices;
	}
	public List<JustificationAbsence> getListJustificationAdsences() {
		return listJustificationAdsences;
	}
	public void setListJustificationAdsences(List<JustificationAbsence> listJustificationAdsences) {
		this.listJustificationAdsences = listJustificationAdsences;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasName() {
		return lasName;
	}
	public void setLasName(String lasName) {
		this.lasName = lasName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public Date getDateC() {
		return dateC;
	}
	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}
	public int getScoreDelegate() {
		return scoreDelegate;
	}
	public void setScoreDelegate(int scoreDelegate) {
		this.scoreDelegate = scoreDelegate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public StateUser getStateUser() {
		return stateUser;
	}
	public void setStateUser(StateUser stateUser) {
		this.stateUser = stateUser;
	}
	
	
	
	
	

}
