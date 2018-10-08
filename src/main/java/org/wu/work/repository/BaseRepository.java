package org.wu.work.repository;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;


public interface BaseRepository<T> {
	
	public T findOne(Integer id);
	
	public T findOne(DetachedCriteria detachedCriteria);
	
	public Integer count();
	
	public Integer count(DetachedCriteria detachedCriteria);
	
	public List<T> findAll();
	
	public List<T> findAll(int page, int fetchSize);
	
	public List<T> findAll(DetachedCriteria criteria);
	
	public List<T> findAll(DetachedCriteria detachedCriteria, int page, int pageSize);
	
	public List<T> findAll(DetachedCriteria detachedCriteria, int page, int pageSize,int totalSize);
	
	public T save(T entry); 
	
	public T delete(T entity);

	public List<T> deleteAll(List<T> list);
	
	public List<Map<String,String>> executeSql(String hql, Object... params);
	
	public List<Map<String,String>> executeSql(String sql, String[] paramNames, Object... params);
	
	public List<Map<String,String>> executeSqlPage(String hql, int page, int fetchSize, Object... params);

	public List<Map<String,String>> executeSqlPage(String hql, int page, int fetchSize,String[] paramNames, Object...params);

    public int executeUpdateSql(String hql, Object... params);
	
	public int executeUpdateSql(String hql, String[] paramNames, Object...params);
}
