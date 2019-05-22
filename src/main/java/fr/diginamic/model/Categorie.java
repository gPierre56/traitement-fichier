package fr.diginamic.model;

/**
 * @author Guillaume Classe modèle pour la classe catégorie
 *
 */
public class Categorie {

	/** id : identifiant de la catégorie int */
	private int id;
	/** nomCategorie : nom de la catégorie String */
	private String nomCategorie;

	/**
	 * Constructor
	 * 
	 * @param id           identifiant de la catégorie
	 * @param nomCategorie nom de la catégorie
	 */
	public Categorie(int id, String nomCategorie) {
		super();
		this.id = id;
		this.nomCategorie = nomCategorie;
	}

	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nomCategorie=" + nomCategorie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nomCategorie == null) ? 0 : nomCategorie.hashCode());
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
		Categorie other = (Categorie) obj;
		if (id != other.id)
			return false;
		if (nomCategorie == null) {
			if (other.nomCategorie != null)
				return false;
		} else if (!nomCategorie.equals(other.nomCategorie))
			return false;
		return true;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the nomCategorie
	 */
	public String getNomCategorie() {
		return nomCategorie;
	}

	/**
	 * Setter
	 * 
	 * @param nomCategorie the nomCategorie to set
	 */
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

}
