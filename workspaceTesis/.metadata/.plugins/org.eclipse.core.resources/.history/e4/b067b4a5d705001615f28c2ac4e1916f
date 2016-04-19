package ec.gob.magap.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import ec.gob.magap.common.util.SearchResultDTO;
import ec.gob.magap.exception.MagapException;

public interface GenericDAO {

	void save(Object entity) throws MagapException;

	void delete(Object entity) throws MagapException;

	void update(Object entity) throws MagapException;

	void saveOrUpdate(Object entity) throws MagapException;

	List<?> findObjects(Object entity) throws MagapException;

	List<?> findAll(Object entity) throws MagapException;

	List<?> findOrderBy(Object entity, String paramOrderBy)
			throws MagapException;

	Object findUnique(Object entity) throws MagapException;

	Object findUnique(DetachedCriteria detachedCriteria) throws MagapException;

	List<?> findCriteria(DetachedCriteria detachedCriteria)
			throws MagapException;

	void saveOrUpdateAll(List<?> entity) throws MagapException;

	SearchResultDTO<?> findObjectsPaged(DetachedCriteria entity,
			DetachedCriteria criteriaCount, Integer firstResult,
			Integer maxResults, Boolean countAgain) throws MagapException;

	Object findObject(Object entity) throws MagapException;
}
