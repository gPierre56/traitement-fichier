package fr.diginamic.model;

public class Marque {

	/** idmarque : identifiant unique de la marque int */
	private int idmarque;
	/** nomMarque : nom de la marque String */
	private String nomMarque;

	/**
	 * Constructor
	 * 
	 * @param idmarque  : identifiant unique de la marque
	 * @param nomMarque : nom de la marque
	 */
	public Marque(int idmarque, String nomMarque) {
		super();
		this.idmarque = idmarque;
		this.nomMarque = nomMarque;
	}

	public Marque(String nomMarque) {
		super();
		this.nomMarque = nomMarque;
	}

	@Override
	public String toString() {
		return "Marque [idmarque=" + idmarque + ", nomMarque=" + nomMarque + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idmarque;
		result = prime * result + ((nomMarque == null) ? 0 : nomMarque.hashCode());
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
		Marque other = (Marque) obj;
		if (idmarque != other.idmarque)
			return false;
		if (nomMarque == null) {
			if (other.nomMarque != null)
				return false;
		} else if (!nomMarque.equals(other.nomMarque))
			return false;
		return true;
	}

	/**
	 * Getter
	 * 
	 * @return the idmarque
	 */
	public int getIdmarque() {
		return idmarque;
	}

	/**
	 * Setter
	 * 
	 * @param idmarque the idmarque to set
	 */
	public void setIdmarque(int idmarque) {
		this.idmarque = idmarque;
	}

	/**
	 * Getter
	 * 
	 * @return the nomMarque
	 */
	public String getNomMarque() {
		return nomMarque;
	}

	/**
	 * Setter
	 * 
	 * @param nomMarque the nomMarque to set
	 */
	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

}
