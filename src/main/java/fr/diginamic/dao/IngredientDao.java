package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.exceptions.TechnicalException;
import fr.diginamic.model.Ingredient;
import fr.diginamic.utils.ConnectionManager;

public class IngredientDao implements IIngredientDao {

	@Override
	public void saveNew(Ingredient i) {

		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("INSERT into ingredient values (?,?)");
			statement.setInt(1, i.getIdIngredient());
			statement.setString(2, i.getNomIngredient());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException("Ajout de l'ingrédient impossible", e);
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
	public List<Ingredient> findAll() {
		List<Ingredient> listeIngredients = new ArrayList<Ingredient>();
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("select * from ingredient");
			ResultSet curseur = statement.executeQuery();
			while (curseur.next()) {
				int idIngredient = curseur.getInt("idingredient");
				String nom = curseur.getString("nomingredient");
				Ingredient ingredient = new Ingredient(idIngredient, nom);
				listeIngredients.add(ingredient);

			}

		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de la liste des ingrédients", e);
		}

		try {
			con.close();
		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la fermeture de la base", e);
		}
		return listeIngredients;
	}

	@Override
	public Ingredient findOne(int id) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("select * from ingredient where idingredient = ?");
			statement.setInt(1, id);
			ResultSet curseur = statement.executeQuery();

			if (curseur.next()) {
				int idIngredient = curseur.getInt("idingredient");
				String nom = curseur.getString("nomingredient");
				Ingredient ingredient = new Ingredient(idIngredient, nom);
				if (con != null) {
					con.close();
				}
				return ingredient;
			} else {
				if (con != null) {
					con.close();
				}
				return null;
			}
		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de l'ingrédient", e);
		}
	}

	@Override
	public boolean exists(int id) {
		Connection con = ConnectionManager.getInstance();

		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from ingredient where idingredient = ?");

			statement.setInt(1, id);
			ResultSet curseur = statement.executeQuery();
			if (curseur.next()) {
				con.close();
				return true;
			} else {
				con.close();
				return false;
			}
		} catch (SQLException e) {
			throw new TechnicalException("Vérification de l'existence de la marque impossible", e);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id, Ingredient o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ingredient findByName(String name) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("select * from ingredient where nomingredient = ?");
			statement.setString(1, name);
			ResultSet curseur = statement.executeQuery();

			if (curseur.next()) {
				int idIngredient = curseur.getInt("idingredient");
				String nom = curseur.getString("nomingredient");
				Ingredient ingredient = new Ingredient(idIngredient, nom);
				if (con != null) {
					con.close();
				}
				return ingredient;
			} else {
				if (con != null) {
					con.close();
				}
				return null;
			}
		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de l'ingrédient", e);
		}
	}

	@Override
	public boolean nameExists(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

}
