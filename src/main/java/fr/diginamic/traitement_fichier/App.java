package fr.diginamic.traitement_fichier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exceptions.TechnicalException;
import fr.diginamic.utils.ConnectionManager;

public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		// configuration du driver
		try {
			Class.forName(ConnectionManager.getDriver());
		} catch (ClassNotFoundException e) {
			throw new TechnicalException("Driver introuvable", e);
		}

	}
}
