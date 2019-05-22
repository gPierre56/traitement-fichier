package fr.diginamic.service;

import java.util.HashSet;
import java.util.List;

import fr.diginamic.dao.CategorieDao;
import fr.diginamic.dao.IngredientDao;
import fr.diginamic.dao.MarqueDao;
import fr.diginamic.dao.ProduitDao;
import fr.diginamic.model.Categorie;
import fr.diginamic.model.Ingredient;
import fr.diginamic.model.Marque;
import fr.diginamic.model.Produit;

public class TraitementService {

	private CategorieDao categorieDao = new CategorieDao();
	private MarqueDao marqueDao = new MarqueDao();
	private IngredientDao ingredientDao = new IngredientDao();
	ProduitDao produitDao = new ProduitDao();

	public void traiterLignes(List<String> liste) {

		HashSet<Categorie> listeCategories = new HashSet<Categorie>();
		HashSet<Marque> listeMarques = new HashSet<Marque>();
		HashSet<Ingredient> listeIngredients = new HashSet<Ingredient>();
		HashSet<Produit> listeProduits = new HashSet<Produit>();

		for (int i = 1; i < liste.size(); i++) {
			String[] tableauFichier = liste.get(i).split("\\|");

			Categorie categorie = new Categorie(tableauFichier[0]);
			listeCategories.add(categorie);

			Marque marque = new Marque(tableauFichier[1]);
			listeMarques.add(marque);

			Categorie categorieFromBase = categorieDao.findByName(tableauFichier[1]);
			Marque marqueFromBase = marqueDao.findByName(tableauFichier[0]);
			Produit produit = new Produit(tableauFichier, categorieFromBase, marqueFromBase);
			listeProduits.add(produit);

			String[] tableauIngredients = tableauFichier[tableauFichier.length - 1].split(",");
			for (int j = 0; j < tableauIngredients.length; j++) {
				Ingredient ingredient = new Ingredient(tableauIngredients[j]);
				listeIngredients.add(ingredient);
			}

		}

//		for (Categorie categorie : listeCategories) {
//			categorieDao.saveNew(categorie);
//		}

//		for (Marque marque : listeMarques) {
//			marqueDao.saveNew(marque);
//		}

//		for (Ingredient ingredient : listeIngredients) {
//			ingredientDao.saveNew(ingredient);
//		}

		for (Produit produit : listeProduits) {
			produitDao.saveNew(produit);
		}

	}

}
