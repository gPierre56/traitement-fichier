package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.exceptions.TechnicalException;
import fr.diginamic.model.Categorie;
import fr.diginamic.model.Marque;
import fr.diginamic.model.Produit;
import fr.diginamic.utils.ConnectionManager;

public class ProduitDao implements IProduitDao {

	@Override
	public void saveNew(Produit p) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement(
					"INSERT into produit values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, p.getIdProduit());
			statement.setString(2, p.getNomProduit());
			statement.setString(3, p.getGradeNutrition());
			statement.setInt(4, p.getMarqueProduit().getIdmarque());
			statement.setInt(5, p.getCategorieProduit().getId());
			statement.setFloat(6, p.getEnergie100g());
			statement.setFloat(7, p.getGraisse100g());
			statement.setFloat(8, p.getSucres100g());
			statement.setFloat(9, p.getFibres100g());
			statement.setFloat(10, p.getProteines100g());
			statement.setFloat(11, p.getSel100g());
			statement.setFloat(12, p.getVitA100g());
			statement.setFloat(13, p.getVitD100g());
			statement.setFloat(14, p.getVitE100g());
			statement.setFloat(15, p.getVitK100g());
			statement.setFloat(16, p.getVitC100g());
			statement.setFloat(17, p.getVitB1100g());
			statement.setFloat(18, p.getVitB2100g());
			statement.setFloat(19, p.getVitPP100g());
			statement.setFloat(20, p.getVitB6100g());
			statement.setFloat(21, p.getVitB9100g());
			statement.setFloat(22, p.getVitB12100g());
			statement.setFloat(23, p.getCalcium100g());
			statement.setFloat(24, p.getMagnesium100g());
			statement.setFloat(25, p.getIron100g());
			statement.setFloat(26, p.getFer100g());
			statement.setFloat(27, p.getBetaCarotene100g());
			statement.setBoolean(28, p.isPresenceHuilePalme());
			statement.setObject(29, p.getAllergenes());
			statement.setObject(30, p.getAdditifs());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException("Ajout du produit impossible", e);
		}

	}

	@Override
	public List<Produit> findAll() {
		List<Produit> listeProduits = new ArrayList<Produit>();
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement(
					"select * from produit, categorie, marque where produit.idmarque = marque.idmarque and where produit.idcategorie = categorie.idcategorie");
			ResultSet curseur = statement.executeQuery();
			while (curseur.next()) {
				int idProduit = curseur.getInt("idproduit");
				String nom = curseur.getString("nomproduit");
				String grade = curseur.getString("grade_nutrition");
				int idMarque = curseur.getInt("idmarque");
				String nomMarque = curseur.getString("nomMarque");
				int idCategorie = curseur.getInt("idcategorie");
				String nomCategorie = curseur.getString("nomMarque");
				float energie_100g = curseur.getFloat("energie_100g");
				float graisse_100g = curseur.getFloat("graisse_100g");
				float sucres_100g = curseur.getFloat("sucres_100g");
				float fibres_100g = curseur.getFloat("fibres_100g");
				float proteines_100g = curseur.getFloat("proteines_100g");
				float sel_100g = curseur.getFloat("sel_100g");
				float vitA_100g = curseur.getFloat("vitA_100g");
				float vitD_100g = curseur.getFloat("vitD_100g");
				float vitE_100g = curseur.getFloat("vitE_100g");
				float vitK_100g = curseur.getFloat("vitK_100g");
				float vitC_100g = curseur.getFloat("vitC_100g");
				float vitB1_100g = curseur.getFloat("vitB1_100g");
				float vitB2_100g = curseur.getFloat("vitB2_100g");
				float vitPP_100g = curseur.getFloat("vitPP_100g");
				float vitB6_100g = curseur.getFloat("vitB6_100g");
				float vitB9_100g = curseur.getFloat("vitB9_100g");
				float vitB12_100g = curseur.getFloat("vitB12_100g");
				float calcium_100g = curseur.getFloat("calcium_100g");
				float magnesium_100g = curseur.getFloat("magnesium_100g");
				float iron_100g = curseur.getFloat("iron_100g");
				float fer_100g = curseur.getFloat("fer_100g");
				float betaCarotene_100g = curseur.getFloat("betaCarotene_100g");
				boolean presenceHuilePalme = curseur.getBoolean("presenceHuilePalme");
				String allergenes = curseur.getString("allergenes");
				String additifs = curseur.getString("additifs");

				listeProduits.add(new Produit(idProduit, nom, grade, new Categorie(idCategorie, nomCategorie),
						new Marque(idMarque, nomMarque), energie_100g, graisse_100g, sucres_100g, fibres_100g,
						proteines_100g, sel_100g, vitA_100g, vitD_100g, vitE_100g, vitK_100g, vitC_100g, vitB1_100g,
						vitB2_100g, vitPP_100g, vitB6_100g, vitB9_100g, vitB12_100g, calcium_100g, magnesium_100g,
						iron_100g, fer_100g, betaCarotene_100g, presenceHuilePalme, allergenes, additifs));

			}

		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de la liste des Produits", e);
		}
		return listeProduits;
	}

	@Override
	public boolean exists(int id) {
		Connection con = ConnectionManager.getInstance();

		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from produit where idproduit = ?");

			statement.setInt(1, id);
			ResultSet curseur = statement.executeQuery();
			if (curseur.next()) {
				return true;
			} else {

				return false;
			}
		} catch (SQLException e) {
			throw new TechnicalException("Vérification de l'existence du produit impossible", e);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id, Produit o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Produit findOne(int id) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("select * from produit where idproduit = ?");
			statement.setInt(1, id);
			ResultSet curseur = statement.executeQuery();

			if (curseur.next()) {
				int idProduit = curseur.getInt("idproduit");
				String nom = curseur.getString("nomproduit");
				String grade = curseur.getString("grade_nutrition");
				int idMarque = curseur.getInt("idmarque");
				String nomMarque = curseur.getString("nomMarque");
				int idCategorie = curseur.getInt("idcategorie");
				String nomCategorie = curseur.getString("nomMarque");
				float energie_100g = curseur.getFloat("energie_100g");
				float graisse_100g = curseur.getFloat("graisse_100g");
				float sucres_100g = curseur.getFloat("sucres_100g");
				float fibres_100g = curseur.getFloat("fibres_100g");
				float proteines_100g = curseur.getFloat("proteines_100g");
				float sel_100g = curseur.getFloat("sel_100g");
				float vitA_100g = curseur.getFloat("vitA_100g");
				float vitD_100g = curseur.getFloat("vitD_100g");
				float vitE_100g = curseur.getFloat("vitE_100g");
				float vitK_100g = curseur.getFloat("vitK_100g");
				float vitC_100g = curseur.getFloat("vitC_100g");
				float vitB1_100g = curseur.getFloat("vitB1_100g");
				float vitB2_100g = curseur.getFloat("vitB2_100g");
				float vitPP_100g = curseur.getFloat("vitPP_100g");
				float vitB6_100g = curseur.getFloat("vitB6_100g");
				float vitB9_100g = curseur.getFloat("vitB9_100g");
				float vitB12_100g = curseur.getFloat("vitB12_100g");
				float calcium_100g = curseur.getFloat("calcium_100g");
				float magnesium_100g = curseur.getFloat("magnesium_100g");
				float iron_100g = curseur.getFloat("iron_100g");
				float fer_100g = curseur.getFloat("fer_100g");
				float betaCarotene_100g = curseur.getFloat("betaCarotene_100g");
				boolean presenceHuilePalme = curseur.getBoolean("presenceHuilePalme");
				String allergenes = curseur.getString("allergenes");
				String additifs = curseur.getString("additifs");
				Produit produit = new Produit(idProduit, nom, grade, new Categorie(idCategorie, nomCategorie),
						new Marque(idMarque, nomMarque), energie_100g, graisse_100g, sucres_100g, fibres_100g,
						proteines_100g, sel_100g, vitA_100g, vitD_100g, vitE_100g, vitK_100g, vitC_100g, vitB1_100g,
						vitB2_100g, vitPP_100g, vitB6_100g, vitB9_100g, vitB12_100g, calcium_100g, magnesium_100g,
						iron_100g, fer_100g, betaCarotene_100g, presenceHuilePalme, allergenes, additifs);

				return produit;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de la marque", e);
		}
	}

	@Override
	public Produit findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean nameExists(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

}
