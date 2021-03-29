package tn.esprit.spring.entity;

public class Statistique {
	
	String description;
	int count ;
	float pourcentage;

	public float getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(float pourcentage) {
		this.pourcentage = pourcentage;
	}
	public Statistique() {
	
	}
	public Statistique(String description, int count) {
		super();
		this.description = description;
		this.count = count;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
