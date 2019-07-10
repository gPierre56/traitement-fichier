package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.exceptions.TechnicalException;
import fr.diginamic.model.Marque;
import fr.diginamic.utils.ConnectionManager;

public class MarqueDao implements IMarqueDao {

	@Override
	public void saveNew(Marque m) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("INSERT into marque values (?,?)");
			statement.setInt(1, m.getIdmarque());
			statement.setString(2, m.getNomMarque());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException("Ajout de la marque impossible", e);
		}

	}

	@Override
	public List<Marque> findAll() {
		List<Marque> listeMarques = new ArrayList<Marque>();
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("select * from marque");
			ResultSet curseur = statement.executeQuery();
			while (curseur.next()) {
				int idMarque = curseur.getInt("idmarque");
				String nom = curseur.getString("nommarque");
				Marque marque = new Marque(idMarque, nom);
				listeMarques.add(marque);

			}

		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de la liste des marques", e);
		}
		return listeMarques;
	}

	@Override
	public Marque findOne(int id) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("select * from marque where idMarque = ?");
			statement.setInt(1, id);
			ResultSet curseur = statement.executeQuery();

			if (curseur.next()) {
				int idMarque = curseur.getInt("idmarque");
				String nom = curseur.getString("nommarque");
				Marque marque = new Marque(idMarque, nom);
				return marque;
			} else {

				return null;
			}
		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de la marque", e);
		}

	}

	@Override
	public boolean exists(int id) {
		Connection con = ConnectionManager.getInstance();

		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from marque where idMarque = ?");

			statement.setInt(1, id);
			ResultSet curseur = statement.executeQuery();
			if (curseur.next()) {

				return true;
			} else {

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
	public void update(int id, Marque o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Marque findByName(String name) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("select * from marque where nommarque = ?");
			statement.setString(1, name);
			ResultSet curseur = statement.executeQuery();

			if (curseur.next()) {
				int idMarque = curseur.getInt("idmarque");
				String nom = curseur.getString("nommarque");
				Marque marque = new Marque(idMarque, nom);
				return marque;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new TechnicalException("Erreur lors de la récupération de la marque", e);
		}
	}

	@Override
	public boolean nameExists(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

}
