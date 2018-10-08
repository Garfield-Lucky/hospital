package org.wu.work.repository;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

@SuppressWarnings("restriction")
public class RepositorySupport<T> implements BaseRepository<T> {
	private SessionFactory sessionFactory;
	private Class<T> domainClass;
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public RepositorySupport() {
		domainClass = (Class<T>) ((ParameterizedType) getClass() // Class字节码
				.getGenericSuperclass()) // 因为对于T.class我们无法获取，但是这个方法就能获取到父类的参数类型，返回值为ParameterizedType
				.getActualTypeArguments()[0]; // 数组里第一个就是子类继承父类时所用类型
		System.out.println(domainClass);
	}

	@SuppressWarnings("unchecked")
	public T findOne(Integer id) {
		return (T) getCurrentSession().get(getDomainClass(), id);
	}
	
	public Class<T> getDomainClass() {
		return domainClass;
	}
	
	public T findOne(DetachedCriteria detachedCriteria) {
		List<T> list = findAll(detachedCriteria);
		if(list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	

	public Integer count() {
		Criteria criteria = getCurrentSession().createCriteria(getDomainClass());
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
	
	public Integer count(DetachedCriteria detachedCriteria) {
		Criteria criteria = detachedCriteria.getExecutableCriteria(getCurrentSession());
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
	
	 
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Criteria criteria = getCurrentSession().createCriteria(getDomainClass());
		return criteria.list(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(int page, int fetchSize) {
		Criteria criteria = getCurrentSession().createCriteria(getDomainClass());
		criteria.addOrder(Order.asc("id"));
		criteria.setFirstResult(page);
        criteria.setMaxResults(fetchSize);
		return criteria.list();
	}


	@SuppressWarnings("unchecked")
	public List<T> findAll(DetachedCriteria detachedCriteria) {
		Criteria criteria = detachedCriteria.getExecutableCriteria(getCurrentSession());
		return criteria.list();
	}

	@SuppressWarnings({ "unchecked" })
	public List<T> findAll(DetachedCriteria detachedCriteria, int page, int pageSize) {
		Criteria criteria = detachedCriteria.getExecutableCriteria(getCurrentSession());
		criteria.setFirstResult(page);
        criteria.setMaxResults(pageSize);
        return criteria.list();
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<T> findAll(DetachedCriteria detachedCriteria, int page, int pageSize,int totalSize) {
		Criteria criteria = detachedCriteria.getExecutableCriteria(getCurrentSession());
		int fir = totalSize - (page+1)*pageSize;
		if((pageSize > totalSize && page == 0) || (fir < 0 && fir+pageSize >= 0)){
			fir = 0 ;
		}
		
		criteria.setFirstResult(fir);
        criteria.setMaxResults(pageSize);
        return criteria.list();
	}
 
	 
	@SuppressWarnings("unchecked")
	public T save(T entity) {
		if (getCurrentSession().contains(entity)) {
			System.out.println("=============");
			return (T) getCurrentSession().merge(entity);
		} else {
			System.out.println("-------------");
			getCurrentSession().saveOrUpdate(entity);
			getCurrentSession().flush();
		}
		return entity;
	}
	
	 
	public T delete(T entity) {
		getCurrentSession().delete(entity);
		return entity;
	}
	
	public List<T> deleteAll(List<T> list) {
		for (T t : list) {
			delete(t);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String,String>> executeSql(String sql, Object... params) {
		Query query = getCurrentSession().createSQLQuery(sql);
		int i = 0;
		for(Object param : params) {
			if(param instanceof Collection) {
				query.setParameterList("ids", (Collection<?>)param);
			} else {
				query.setParameter(i ++, param);
			}
		}
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String,String>> executeSql(String sql, String[] paramNames, Object... params) {
		Query query = getCurrentSession().createSQLQuery(sql);
		int i = 0;
		for(String paramName : paramNames) {
			if(params[i] instanceof Collection) {
				query.setParameterList("ids", (Collection<?>)params[i++]);
			} else {
				query.setParameter(paramName, params[i++]);
			}
		}
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 
		return query.list();
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String,String>> executeSqlPage(String sql, int page, int fetchSize, Object... params) {
		Query query = getCurrentSession().createSQLQuery(sql);
		int i = 0;
		for(Object param : params) {
			if(param instanceof Collection) {
				query.setParameterList("ids", (Collection<?>)param);
			} else {
				query.setParameter(i ++, param);
			}
		}
		query.setFirstResult(page);
		query.setMaxResults(fetchSize);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 
		return query.list();

	}

	@SuppressWarnings("unchecked")
	public List<Map<String,String>> executeSqlPage(String sql, int page, int fetchSize, String[] paramNames, Object... params) {
		Query query = getCurrentSession().createSQLQuery(sql);
		int i = 0;
		for(String paramName : paramNames) {
			if(params[i] instanceof Collection) {
				query.setParameterList("ids", (Collection<?>)params[i++]);
			} else {
				query.setParameter(paramName, params[i++]);
			}
		}
		query.setFirstResult(page);
		query.setMaxResults(fetchSize);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 
		return query.list();
	}
  
	public int executeUpdateSql(String sql, Object...params) {
		Query query = getCurrentSession().createSQLQuery(sql);
		int i = 0;
		for(Object param : params) {
			if(param instanceof Collection) {
				query.setParameterList("ids", (Collection<?>)param);
			} else {
				query.setParameter(i ++, param);
			}
		}
		return query.executeUpdate();
	}
	
	public int executeUpdateSql(String sql, String[] paramNames, Object...params) {
		Query query = getCurrentSession().createSQLQuery(sql);
		int i = 0;
		for(String paramName : paramNames) {
			if(params[i] instanceof Collection) {
				query.setParameterList("ids", (Collection<?>)params[i++]);
			} else {
				query.setParameter(paramName, params[i++]);
			}
		}
		return query.executeUpdate();
	}
}
