package fr.diginamic.service;

public class ParseService {

	public static float tryToParse(String chaine) {
		if (!chaine.isEmpty()) {
			float resultat = Float.parseFloat(chaine);
			return resultat;
		}
		return 0;
	}

	public static boolean parseBoolean(String chaine) {

		if (chaine != "" & Integer.parseInt(chaine) == 1) {
			return true;
		}

		return false;
	}

}
