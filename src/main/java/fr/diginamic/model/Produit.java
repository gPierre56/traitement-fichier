package fr.diginamic.model;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.service.ParseService;

/**
 * @author Guillaume
 *
 */
public class Produit {

	/** idProduit : int */
	private int idProduit;
	/** nomProduit : String */
	private String nomProduit;
	/** gradeNutrition : String */
	private String gradeNutrition;
	/** categorieProduit : Categorie */
	private Categorie categorieProduit;
	/** marqueProduit : Marque */
	private Marque marqueProduit;
	/** energie100g : float */
	private float energie100g;
	/** graisse100g : float */
	private float graisse100g;
	/** sucres100g : float */
	private float sucres100g;
	/** fibres100g : float */
	private float fibres100g;
	/** proteines100g : float */
	private float proteines100g;
	/** sel100g : float */
	private float sel100g;
	/** vitA100g : float */
	private float vitA100g;
	/** vitD100g : float */
	private float vitD100g;
	/** vitE100g : float */
	private float vitE100g;
	/** vitK100g : float */
	private float vitK100g;
	/** vitC100g : float */
	private float vitC100g;
	/** vitB1100g : float */
	private float vitB1100g;
	/** vitB2100g : float */
	private float vitB2100g;
	/** vitPP100g : float */
	private float vitPP100g;
	/** vitB6100g : float */
	private float vitB6100g;
	/** vitB9100g : float */
	private float vitB9100g;
	/** vitB12100g : float */
	private float vitB12100g;
	/** calcium100g : float */
	private float calcium100g;
	/** magnesium100g : float */
	private float magnesium100g;
	/** iron100g : float */
	private float iron100g;
	/** fer100g : float */
	private float fer100g;
	/** betaCarotene100g : float */
	private float betaCarotene100g;
	/** presenceHuilePalme : boolean */
	private boolean presenceHuilePalme;
	/** allergenes : String */
	private String allergenes;
	/** additifs : String */
	private String additifs;

	/** listeIngredients : List<Ingredient> */
	private List<Ingredient> listeIngredients = new ArrayList<Ingredient>();

	public Produit(int idProduit, String nomProduit, String gradeNutrition, Categorie categorieProduit,
			Marque marqueProduit, float energie100g, float graisse100g, float sucres100g, float fibres100g,
			float proteines100g, float sel100g, float vitA100g, float vitD100g, float vitE100g, float vitK100g,
			float vitC100g, float vitB1100g, float vitB2100g, float vitPP100g, float vitB6100g, float vitB9100g,
			float vitB12100g, float calcium100g, float magnesium100g, float iron100g, float fer100g,
			float betaCarotene100g, boolean presenceHuilePalme, String allergenes, String additifs) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.gradeNutrition = gradeNutrition;
		this.categorieProduit = categorieProduit;
		this.marqueProduit = marqueProduit;
		this.energie100g = energie100g;
		this.graisse100g = graisse100g;
		this.sucres100g = sucres100g;
		this.fibres100g = fibres100g;
		this.proteines100g = proteines100g;
		this.sel100g = sel100g;
		this.vitA100g = vitA100g;
		this.vitD100g = vitD100g;
		this.vitE100g = vitE100g;
		this.vitK100g = vitK100g;
		this.vitC100g = vitC100g;
		this.vitB1100g = vitB1100g;
		this.vitB2100g = vitB2100g;
		this.vitPP100g = vitPP100g;
		this.vitB6100g = vitB6100g;
		this.vitB9100g = vitB9100g;
		this.vitB12100g = vitB12100g;
		this.calcium100g = calcium100g;
		this.magnesium100g = magnesium100g;
		this.iron100g = iron100g;
		this.fer100g = fer100g;
		this.betaCarotene100g = betaCarotene100g;
		this.presenceHuilePalme = presenceHuilePalme;
		this.allergenes = allergenes;
		this.additifs = additifs;
	}

	public Produit(String[] tableauFichier, Categorie categorie, Marque marque) {
		super();

		this.nomProduit = tableauFichier[2];
		this.gradeNutrition = tableauFichier[3];
		this.categorieProduit = categorie;
		this.marqueProduit = marque;
		this.energie100g = ParseService.tryToParse(tableauFichier[5]);
		this.graisse100g = ParseService.tryToParse(tableauFichier[6]);
		this.sucres100g = ParseService.tryToParse(tableauFichier[7]);
		this.fibres100g = ParseService.tryToParse(tableauFichier[8]);
		this.proteines100g = ParseService.tryToParse(tableauFichier[9]);
		this.sel100g = ParseService.tryToParse(tableauFichier[10]);
		this.vitA100g = ParseService.tryToParse(tableauFichier[11]);
		this.vitD100g = ParseService.tryToParse(tableauFichier[12]);
		this.vitE100g = ParseService.tryToParse(tableauFichier[13]);
		this.vitK100g = ParseService.tryToParse(tableauFichier[14]);
		this.vitC100g = ParseService.tryToParse(tableauFichier[15]);
		this.vitB1100g = ParseService.tryToParse(tableauFichier[16]);
		this.vitB2100g = ParseService.tryToParse(tableauFichier[17]);
		this.vitPP100g = ParseService.tryToParse(tableauFichier[18]);
		this.vitB6100g = ParseService.tryToParse(tableauFichier[19]);
		this.vitB9100g = ParseService.tryToParse(tableauFichier[20]);
		this.vitB12100g = ParseService.tryToParse(tableauFichier[21]);
		this.calcium100g = ParseService.tryToParse(tableauFichier[22]);
		this.magnesium100g = ParseService.tryToParse(tableauFichier[23]);
		this.iron100g = ParseService.tryToParse(tableauFichier[24]);
		this.fer100g = ParseService.tryToParse(tableauFichier[25]);
		this.betaCarotene100g = ParseService.tryToParse(tableauFichier[26]);
		this.presenceHuilePalme = ParseService.parseBoolean(tableauFichier[27]);
		this.allergenes = tableauFichier[28];
		this.additifs = tableauFichier[29];
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", gradeNutrition=" + gradeNutrition
				+ ", categorieProduit=" + categorieProduit + ", marqueProduit=" + marqueProduit + ", energie100g="
				+ energie100g + ", graisse100g=" + graisse100g + ", sucres100g=" + sucres100g + ", fibres100g="
				+ fibres100g + ", proteines100g=" + proteines100g + ", sel100g=" + sel100g + ", vitA100g=" + vitA100g
				+ ", vitD100g=" + vitD100g + ", vitE100g=" + vitE100g + ", vitK100g=" + vitK100g + ", vitC100g="
				+ vitC100g + ", vitB1100g=" + vitB1100g + ", vitB2100g=" + vitB2100g + ", vitPP100g=" + vitPP100g
				+ ", vitB6100g=" + vitB6100g + ", vitB9100g=" + vitB9100g + ", vitB12100g=" + vitB12100g
				+ ", calcium100g=" + calcium100g + ", magnesium100g=" + magnesium100g + ", iron100g=" + iron100g
				+ ", fer100g=" + fer100g + ", betaCarotene100g=" + betaCarotene100g + ", presenceHuilePalme="
				+ presenceHuilePalme + ", allergenes=" + allergenes + ", additifs=" + additifs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additifs == null) ? 0 : additifs.hashCode());
		result = prime * result + ((allergenes == null) ? 0 : allergenes.hashCode());
		result = prime * result + Float.floatToIntBits(betaCarotene100g);
		result = prime * result + Float.floatToIntBits(calcium100g);
		result = prime * result + ((categorieProduit == null) ? 0 : categorieProduit.hashCode());
		result = prime * result + Float.floatToIntBits(energie100g);
		result = prime * result + Float.floatToIntBits(fer100g);
		result = prime * result + Float.floatToIntBits(fibres100g);
		result = prime * result + ((gradeNutrition == null) ? 0 : gradeNutrition.hashCode());
		result = prime * result + Float.floatToIntBits(graisse100g);
		result = prime * result + idProduit;
		result = prime * result + Float.floatToIntBits(iron100g);
		result = prime * result + Float.floatToIntBits(magnesium100g);
		result = prime * result + ((marqueProduit == null) ? 0 : marqueProduit.hashCode());
		result = prime * result + ((nomProduit == null) ? 0 : nomProduit.hashCode());
		result = prime * result + (presenceHuilePalme ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(proteines100g);
		result = prime * result + Float.floatToIntBits(sel100g);
		result = prime * result + Float.floatToIntBits(sucres100g);
		result = prime * result + Float.floatToIntBits(vitA100g);
		result = prime * result + Float.floatToIntBits(vitB1100g);
		result = prime * result + Float.floatToIntBits(vitB12100g);
		result = prime * result + Float.floatToIntBits(vitB2100g);
		result = prime * result + Float.floatToIntBits(vitB6100g);
		result = prime * result + Float.floatToIntBits(vitB9100g);
		result = prime * result + Float.floatToIntBits(vitC100g);
		result = prime * result + Float.floatToIntBits(vitD100g);
		result = prime * result + Float.floatToIntBits(vitE100g);
		result = prime * result + Float.floatToIntBits(vitK100g);
		result = prime * result + Float.floatToIntBits(vitPP100g);
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
		Produit other = (Produit) obj;
		if (additifs == null) {
			if (other.additifs != null)
				return false;
		} else if (!additifs.equals(other.additifs))
			return false;
		if (allergenes == null) {
			if (other.allergenes != null)
				return false;
		} else if (!allergenes.equals(other.allergenes))
			return false;
		if (Float.floatToIntBits(betaCarotene100g) != Float.floatToIntBits(other.betaCarotene100g))
			return false;
		if (Float.floatToIntBits(calcium100g) != Float.floatToIntBits(other.calcium100g))
			return false;
		if (categorieProduit == null) {
			if (other.categorieProduit != null)
				return false;
		} else if (!categorieProduit.equals(other.categorieProduit))
			return false;
		if (Float.floatToIntBits(energie100g) != Float.floatToIntBits(other.energie100g))
			return false;
		if (Float.floatToIntBits(fer100g) != Float.floatToIntBits(other.fer100g))
			return false;
		if (Float.floatToIntBits(fibres100g) != Float.floatToIntBits(other.fibres100g))
			return false;
		if (gradeNutrition == null) {
			if (other.gradeNutrition != null)
				return false;
		} else if (!gradeNutrition.equals(other.gradeNutrition))
			return false;
		if (Float.floatToIntBits(graisse100g) != Float.floatToIntBits(other.graisse100g))
			return false;
		if (idProduit != other.idProduit)
			return false;
		if (Float.floatToIntBits(iron100g) != Float.floatToIntBits(other.iron100g))
			return false;
		if (Float.floatToIntBits(magnesium100g) != Float.floatToIntBits(other.magnesium100g))
			return false;
		if (marqueProduit == null) {
			if (other.marqueProduit != null)
				return false;
		} else if (!marqueProduit.equals(other.marqueProduit))
			return false;
		if (nomProduit == null) {
			if (other.nomProduit != null)
				return false;
		} else if (!nomProduit.equals(other.nomProduit))
			return false;
		if (presenceHuilePalme != other.presenceHuilePalme)
			return false;
		if (Float.floatToIntBits(proteines100g) != Float.floatToIntBits(other.proteines100g))
			return false;
		if (Float.floatToIntBits(sel100g) != Float.floatToIntBits(other.sel100g))
			return false;
		if (Float.floatToIntBits(sucres100g) != Float.floatToIntBits(other.sucres100g))
			return false;
		if (Float.floatToIntBits(vitA100g) != Float.floatToIntBits(other.vitA100g))
			return false;
		if (Float.floatToIntBits(vitB1100g) != Float.floatToIntBits(other.vitB1100g))
			return false;
		if (Float.floatToIntBits(vitB12100g) != Float.floatToIntBits(other.vitB12100g))
			return false;
		if (Float.floatToIntBits(vitB2100g) != Float.floatToIntBits(other.vitB2100g))
			return false;
		if (Float.floatToIntBits(vitB6100g) != Float.floatToIntBits(other.vitB6100g))
			return false;
		if (Float.floatToIntBits(vitB9100g) != Float.floatToIntBits(other.vitB9100g))
			return false;
		if (Float.floatToIntBits(vitC100g) != Float.floatToIntBits(other.vitC100g))
			return false;
		if (Float.floatToIntBits(vitD100g) != Float.floatToIntBits(other.vitD100g))
			return false;
		if (Float.floatToIntBits(vitE100g) != Float.floatToIntBits(other.vitE100g))
			return false;
		if (Float.floatToIntBits(vitK100g) != Float.floatToIntBits(other.vitK100g))
			return false;
		if (Float.floatToIntBits(vitPP100g) != Float.floatToIntBits(other.vitPP100g))
			return false;
		return true;
	}

	/**
	 * Getter
	 * 
	 * @return the idProduit
	 */
	public int getIdProduit() {
		return idProduit;
	}

	/**
	 * Setter
	 * 
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	/**
	 * Getter
	 * 
	 * @return the nomProduit
	 */
	public String getNomProduit() {
		return nomProduit;
	}

	/**
	 * Setter
	 * 
	 * @param nomProduit the nomProduit to set
	 */
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	/**
	 * Getter
	 * 
	 * @return the gradeNutrition
	 */
	public String getGradeNutrition() {
		return gradeNutrition;
	}

	/**
	 * Setter
	 * 
	 * @param gradeNutrition the gradeNutrition to set
	 */
	public void setGradeNutrition(String gradeNutrition) {
		this.gradeNutrition = gradeNutrition;
	}

	/**
	 * Getter
	 * 
	 * @return the categorieProduit
	 */
	public Categorie getCategorieProduit() {
		return categorieProduit;
	}

	/**
	 * Setter
	 * 
	 * @param categorieProduit the categorieProduit to set
	 */
	public void setCategorieProduit(Categorie categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	/**
	 * Getter
	 * 
	 * @return the marqueProduit
	 */
	public Marque getMarqueProduit() {
		return marqueProduit;
	}

	/**
	 * Setter
	 * 
	 * @param marqueProduit the marqueProduit to set
	 */
	public void setMarqueProduit(Marque marqueProduit) {
		this.marqueProduit = marqueProduit;
	}

	/**
	 * Getter
	 * 
	 * @return the energie100g
	 */
	public float getEnergie100g() {
		return energie100g;
	}

	/**
	 * Setter
	 * 
	 * @param energie100g the energie100g to set
	 */
	public void setEnergie100g(float energie100g) {
		this.energie100g = energie100g;
	}

	/**
	 * Getter
	 * 
	 * @return the graisse100g
	 */
	public float getGraisse100g() {
		return graisse100g;
	}

	/**
	 * Setter
	 * 
	 * @param graisse100g the graisse100g to set
	 */
	public void setGraisse100g(float graisse100g) {
		this.graisse100g = graisse100g;
	}

	/**
	 * Getter
	 * 
	 * @return the sucres100g
	 */
	public float getSucres100g() {
		return sucres100g;
	}

	/**
	 * Setter
	 * 
	 * @param sucres100g the sucres100g to set
	 */
	public void setSucres100g(float sucres100g) {
		this.sucres100g = sucres100g;
	}

	/**
	 * Getter
	 * 
	 * @return the fibres100g
	 */
	public float getFibres100g() {
		return fibres100g;
	}

	/**
	 * Setter
	 * 
	 * @param fibres100g the fibres100g to set
	 */
	public void setFibres100g(float fibres100g) {
		this.fibres100g = fibres100g;
	}

	/**
	 * Getter
	 * 
	 * @return the proteines100g
	 */
	public float getProteines100g() {
		return proteines100g;
	}

	/**
	 * Setter
	 * 
	 * @param proteines100g the proteines100g to set
	 */
	public void setProteines100g(float proteines100g) {
		this.proteines100g = proteines100g;
	}

	/**
	 * Getter
	 * 
	 * @return the sel100g
	 */
	public float getSel100g() {
		return sel100g;
	}

	/**
	 * Setter
	 * 
	 * @param sel100g the sel100g to set
	 */
	public void setSel100g(float sel100g) {
		this.sel100g = sel100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitA100g
	 */
	public float getVitA100g() {
		return vitA100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitA100g the vitA100g to set
	 */
	public void setVitA100g(float vitA100g) {
		this.vitA100g = vitA100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitD100g
	 */
	public float getVitD100g() {
		return vitD100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitD100g the vitD100g to set
	 */
	public void setVitD100g(float vitD100g) {
		this.vitD100g = vitD100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitE100g
	 */
	public float getVitE100g() {
		return vitE100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitE100g the vitE100g to set
	 */
	public void setVitE100g(float vitE100g) {
		this.vitE100g = vitE100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitK100g
	 */
	public float getVitK100g() {
		return vitK100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitK100g the vitK100g to set
	 */
	public void setVitK100g(float vitK100g) {
		this.vitK100g = vitK100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitC100g
	 */
	public float getVitC100g() {
		return vitC100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitC100g the vitC100g to set
	 */
	public void setVitC100g(float vitC100g) {
		this.vitC100g = vitC100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitB1100g
	 */
	public float getVitB1100g() {
		return vitB1100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitB1100g the vitB1100g to set
	 */
	public void setVitB1100g(float vitB1100g) {
		this.vitB1100g = vitB1100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitB2100g
	 */
	public float getVitB2100g() {
		return vitB2100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitB2100g the vitB2100g to set
	 */
	public void setVitB2100g(float vitB2100g) {
		this.vitB2100g = vitB2100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitPP100g
	 */
	public float getVitPP100g() {
		return vitPP100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitPP100g the vitPP100g to set
	 */
	public void setVitPP100g(float vitPP100g) {
		this.vitPP100g = vitPP100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitB6100g
	 */
	public float getVitB6100g() {
		return vitB6100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitB6100g the vitB6100g to set
	 */
	public void setVitB6100g(float vitB6100g) {
		this.vitB6100g = vitB6100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitB9100g
	 */
	public float getVitB9100g() {
		return vitB9100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitB9100g the vitB9100g to set
	 */
	public void setVitB9100g(float vitB9100g) {
		this.vitB9100g = vitB9100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitB12100g
	 */
	public float getVitB12100g() {
		return vitB12100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitB12100g the vitB12100g to set
	 */
	public void setVitB12100g(float vitB12100g) {
		this.vitB12100g = vitB12100g;
	}

	/**
	 * Getter
	 * 
	 * @return the calcium100g
	 */
	public float getCalcium100g() {
		return calcium100g;
	}

	/**
	 * Setter
	 * 
	 * @param calcium100g the calcium100g to set
	 */
	public void setCalcium100g(float calcium100g) {
		this.calcium100g = calcium100g;
	}

	/**
	 * Getter
	 * 
	 * @return the magnesium100g
	 */
	public float getMagnesium100g() {
		return magnesium100g;
	}

	/**
	 * Setter
	 * 
	 * @param magnesium100g the magnesium100g to set
	 */
	public void setMagnesium100g(float magnesium100g) {
		this.magnesium100g = magnesium100g;
	}

	/**
	 * Getter
	 * 
	 * @return the iron100g
	 */
	public float getIron100g() {
		return iron100g;
	}

	/**
	 * Setter
	 * 
	 * @param iron100g the iron100g to set
	 */
	public void setIron100g(float iron100g) {
		this.iron100g = iron100g;
	}

	/**
	 * Getter
	 * 
	 * @return the fer100g
	 */
	public float getFer100g() {
		return fer100g;
	}

	/**
	 * Setter
	 * 
	 * @param fer100g the fer100g to set
	 */
	public void setFer100g(float fer100g) {
		this.fer100g = fer100g;
	}

	/**
	 * Getter
	 * 
	 * @return the betaCarotene100g
	 */
	public float getBetaCarotene100g() {
		return betaCarotene100g;
	}

	/**
	 * Setter
	 * 
	 * @param betaCarotene100g the betaCarotene100g to set
	 */
	public void setBetaCarotene100g(float betaCarotene100g) {
		this.betaCarotene100g = betaCarotene100g;
	}

	/**
	 * Getter
	 * 
	 * @return the presenceHuilePalme
	 */
	public boolean isPresenceHuilePalme() {
		return presenceHuilePalme;
	}

	/**
	 * Setter
	 * 
	 * @param presenceHuilePalme the presenceHuilePalme to set
	 */
	public void setPresenceHuilePalme(boolean presenceHuilePalme) {
		this.presenceHuilePalme = presenceHuilePalme;
	}

	/**
	 * Getter
	 * 
	 * @return the allergenes
	 */
	public String getAllergenes() {
		return allergenes;
	}

	/**
	 * Setter
	 * 
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(String allergenes) {
		this.allergenes = allergenes;
	}

	/**
	 * Getter
	 * 
	 * @return the additifs
	 */
	public String getAdditifs() {
		return additifs;
	}

	/**
	 * Setter
	 * 
	 * @param additifs the additifs to set
	 */
	public void setAdditifs(String additifs) {
		this.additifs = additifs;
	}

}
