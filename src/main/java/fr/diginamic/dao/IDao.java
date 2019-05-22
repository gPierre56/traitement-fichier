package fr.diginamic.dao;

import java.util.List;

public interface IDao<T> {

	public void saveNew(T o);

	public List<T> findAll();

	public T findOne(int id);

	public T findByName(String name);

	public boolean exists(int id);

	public boolean nameExists(String nom);

	public void delete(int id);

	public void update(int id, T o);

}
