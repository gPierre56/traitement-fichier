package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.exceptions.TechnicalException;
import fr.diginamic.model.Categorie;
import fr.diginamic.utils.ConnectionManager;

public class CategorieDao implements ICategorieDao {

	@Override
	public void saveNew(Categorie c) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("INSERT into categorie values (?,?)");
			statement.setInt(1, c.getId());
			statement.setString(2, c.getNomCategorie());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException("Ajout de la catégorie impossible", e);
		}

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			throw new TechnicalException("Fermeture de la connexion impossible", e);
		}

	}

	@Override
	public List<Categorie> findAll() {
		List<Categorie> listeCategories = new ArrayList<Categorie>();
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("select * from categorie");
			ResultSet curseur = statement.executeQuery();
			while (curseur.next()) {
				int idCategorie = curseur.getInt("idcategorie");
				String nom = curseur.getString("nomcategorie");
				Categorie categorie = new Categorie(idCategorie, nom);
				listeCategories.add(categorie);

			}

		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de la liste des catégories", e);
		}

		try {
			con.close();
		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la fermeture de la base", e);
		}
		return listeCategories;
	}

	@Override
	public Categorie findOne(int id) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("select * from categorie where idproduit = ?");
			statement.setInt(1, id);
			ResultSet curseur = statement.executeQuery();

			if (curseur.next()) {
				int idcategorie = curseur.getInt("idcategorie");
				String nom = curseur.getString("nomcategorie");
				Categorie categorie = new Categorie(idcategorie, nom);
				return categorie;
			} else {

				return null;
			}
		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de la catégorie", e);
		}
	}

	@Override
	public boolean exists(int id) {
		Connection con = ConnectionManager.getInstance();
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from categorie where idcategorie = ?");

			statement.setInt(1, id);
			ResultSet curseur = statement.executeQuery();
			if (curseur.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new TechnicalException("Vérification de l'existence de la catégorie impossible", e);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id, Categorie o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Categorie findByName(String name) {
		Connection con = ConnectionManager.getInstance();
		ResultSet curseur = null;
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select * from categorie where nomcategorie = ?");
			statement.setString(1, name);
			curseur = statement.executeQuery();

			if (curseur.next()) {
				int idcategorie = curseur.getInt("idcategorie");
				String nom = curseur.getString("nomcategorie");
				Categorie categorie = new Categorie(idcategorie, nom);

				return categorie;
			}
			return null;
		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de la catégorie", e);
		} finally {
			try {
				if (curseur != null) {
					curseur.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				throw new TechnicalException("Erreur lors de la récupération de la catégorie", e);
			}
		}
	}

	@Override
	public boolean nameExists(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

}
