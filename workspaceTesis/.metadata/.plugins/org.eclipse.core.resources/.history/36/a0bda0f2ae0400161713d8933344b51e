package ec.gob.magap.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import ec.gob.magap.common.util.MagapLogger;
import ec.gob.magap.common.util.SearchResultDTO;
import ec.gob.magap.exception.MagapException;

@Transactional
public class GenericDAOImpl extends HibernateDaoSupport implements GenericDAO {

	public void save(Object entity) throws MagapException {
		try {
			getHibernateTemplate().save(entity);
		} catch (Exception e) {
			MagapLogger.log.error("save ", e);
			throw new MagapException(e);
		}
	}

	public void delete(Object entity) throws MagapException {
		try {
			getHibernateTemplate().delete(entity);
		} catch (DataAccessResourceFailureException e) {
			MagapLogger.log.error("delete ", e);
			throw new MagapException(e);
		}
	}

	public void update(Object entity) throws MagapException {
		try {
			getHibernateTemplate().update(entity);
		} catch (DataAccessResourceFailureException e) {
			MagapLogger.log.error("update ", e);
			throw new MagapException(e);
		}
	}

	public void saveOrUpdate(Object entity) throws MagapException {
		try {
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (DataAccessResourceFailureException e) {
			MagapLogger.log.error("saveOrUpdate ", e);
			throw new MagapException(e);
		}
	}

	public List<?> findObjects(Object entity) throws MagapException {
		try {
			return getHibernateTemplate().findByExample(entity);
		} catch (DataAccessResourceFailureException e) {
			MagapLogger.log.error("findObjects ", e);
			throw new MagapException(e);
		}

	}

	public List<?> findAll(Object entity) throws MagapException {
		try {
			return getHibernateTemplate().loadAll(entity.getClass());
		} catch (DataAccessResourceFailureException e) {
			MagapLogger.log.error("findAll ", e);
			throw new MagapException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	public Object findUnique(Object entity) throws MagapException {
		Object entityResult = null;
		List resultado = new ArrayList();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(entity
					.getClass());
			criteria.add(Restrictions.naturalId().set(
					entity.getClass().getDeclaredField("id").getName()
							.toString(), 5L));
			resultado = getHibernateTemplate().findByCriteria(criteria);
			if (resultado != null && !resultado.isEmpty()) {
				entityResult = resultado.iterator().next();
			}
		} catch (DataAccessResourceFailureException e) {
			MagapLogger.log.error("findUnique ", e);
			throw new MagapException(e);
		} catch (NoSuchFieldException e) {
			throw new MagapException(e);
		} catch (SecurityException e) {
			throw new MagapException(e);
		}
		return entityResult;
	}

	public List<?> findOrderBy(Object entity, String paramOrderBy)
			throws MagapException {
		try {
			return getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(entity.getClass()).addOrder(
							Order.asc(paramOrderBy)));
		} catch (DataAccessResourceFailureException e) {
			MagapLogger.log.error("findAllOrderBy ", e);
			throw new MagapException(e);
		}
	}

	public Object findUnique(DetachedCriteria detachedCriteria)
			throws MagapException {
		Object entity = null;
		try {
			List<?> resultado = getHibernateTemplate().findByCriteria(
					detachedCriteria);
			if (resultado == null || resultado.isEmpty()) {
				return entity;
			} else {
				return resultado.iterator().next();
			}
		} catch (DataAccessResourceFailureException e) {
			MagapLogger.log.error("findUnique ", e);
			throw new MagapException(e);
		}
	}

	public List<?> findCriteria(DetachedCriteria detachedCriteria)
			throws MagapException {
		try {
			return getHibernateTemplate().findByCriteria(detachedCriteria);
		} catch (DataAccessResourceFailureException e) {
			MagapLogger.log.error("findCriteria ", e);
			throw new MagapException(e);
		}
	}

	public void saveOrUpdateAll(List<?> entity) throws MagapException {
		try {
			getHibernateTemplate().saveOrUpdateAll(entity);
		} catch (DataAccessResourceFailureException e) {
			MagapLogger.log.error("saveOrUpdateAll ", e);
			throw new MagapException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public SearchResultDTO<?> findObjectsPaged(DetachedCriteria entity,
			DetachedCriteria criteriaCount, Integer firstResult,
			Integer maxResults, Boolean countAgain) throws MagapException {
		try {
			SearchResultDTO<Object> results = new SearchResultDTO<Object>();
			if (countAgain) {
				criteriaCount.setProjection(Projections.rowCount());
				List<Long> countResults = getHibernateTemplate()
						.findByCriteria(criteriaCount);
				if (countResults != null) {
					results.setCountResults(countResults.iterator().next());
					criteriaCount = null;
				}
			}
			results.setResults(getHibernateTemplate().findByCriteria(entity,
					firstResult, maxResults));
			return results;
		} catch (Exception e) {
			MagapLogger.log.error("Error findObjectsPaged ", e);
			throw new MagapException(e);
		}
	}

	public Object findObject(Object entity) throws MagapException {
		List<?> resultado = null;
		try {
			resultado = getHibernateTemplate().findByExample(entity);
			if (resultado == null || resultado.isEmpty()) {
				return resultado;
			} else {
				return resultado.iterator().next();
			}
		} catch (Exception e) {
			MagapLogger.log.error("Error save ", e);
			throw new MagapException(e);
		}
	}
}
