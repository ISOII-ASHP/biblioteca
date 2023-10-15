package es.uclm.library.business.persistence;

public abstract class EntityDAO<E> {

	public abstract E select(String aId);

	public abstract int insert(E aEntity);

	public abstract int update(E aEntity);

	public abstract int delete(E aEntity);
}