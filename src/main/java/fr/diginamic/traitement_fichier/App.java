package fr.diginamic.traitement_fichier;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exceptions.TechnicalException;
import fr.diginamic.service.TraitementService;
import fr.diginamic.utils.ConnectionManager;

public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		TraitementService traitementService = new TraitementService();

		// configuration du driver
		try {
			Class.forName(ConnectionManager.getDriver());
		} catch (ClassNotFoundException e) {
			throw new TechnicalException("Driver introuvable", e);
		}

		try {
			List<String> lines = FileUtils.readLines(new File("C:\\Users\\Guillaume\\Desktop\\openFoodFacts.csv"),
					"UTF-8");
			traitementService.traiterLignes(lines);

		} catch (IOException e) {
			throw new TechnicalException("Erreur dans la lecture du fichier", e);
		}

	}
}
