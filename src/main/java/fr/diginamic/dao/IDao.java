package fr.diginamic.dao;

import java.util.List;

public interface IDao<T> {

	public void saveNew(T o);

	public List<T> findAll();

	public T findOne(int id);

	public boolean exists(int id);

	public void delete(int id);

	public void update(int id, T o);

}
