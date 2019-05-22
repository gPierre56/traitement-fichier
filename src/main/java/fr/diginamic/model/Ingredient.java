package fr.diginamic.model;

public class Ingredient {

	/** idIngredient : int */
	private int idIngredient;
	/** nomIngredient : String */
	private String nomIngredient;

	/**
	 * Constructor
	 * 
	 * @param idIngredient
	 * @param nomIngredient
	 */
	public Ingredient(int idIngredient, String nomIngredient) {
		super();
		this.idIngredient = idIngredient;
		this.nomIngredient = nomIngredient;
	}

	public Ingredient(String nomIngredient) {
		super();
		this.nomIngredient = nomIngredient;
	}

	@Override
	public String toString() {
		return "Ingredient [idIngredient=" + idIngredient + ", nomIngredient=" + nomIngredient + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idIngredient;
		result = prime * result + ((nomIngredient == null) ? 0 : nomIngredient.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (idIngredient != other.idIngredient)
			return false;
		if (nomIngredient == null) {
			if (other.nomIngredient != null)
				return false;
		} else if (!nomIngredient.equals(other.nomIngredient))
			return false;
		return true;
	}

	/**
	 * Getter
	 * 
	 * @return the idIngredient
	 */
	public int getIdIngredient() {
		return idIngredient;
	}

	/**
	 * Setter
	 * 
	 * @param idIngredient the idIngredient to set
	 */
	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}

	/**
	 * Getter
	 * 
	 * @return the nomIngredient
	 */
	public String getNomIngredient() {
		return nomIngredient;
	}

	/**
	 * Setter
	 * 
	 * @param nomIngredient the nomIngredient to set
	 */
	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

}
