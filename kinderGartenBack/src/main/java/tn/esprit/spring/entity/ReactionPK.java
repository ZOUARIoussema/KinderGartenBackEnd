package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReactionPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idUser;

	private long idPublication;

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public long getIdPublication() {
		return idPublication;
	}

	public void setIdPublication(long idPublication) {
		this.idPublication = idPublication;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPublication ^ (idPublication >>> 32));
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReactionPK other = (ReactionPK) obj;
		if (idPublication != other.idPublication)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

}
