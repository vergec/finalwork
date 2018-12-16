package com.ndt.dao;

import com.ndt.vo.PageBean;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AGenericHibernateDao<T extends Serializable, ID extends Serializable> implements IBaseDAO<T, ID> {

	private Class<T> persistentClass;
	@Autowired
	SessionFactory sessionFactory;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public AGenericHibernateDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T create(T entity) throws RuntimeException{
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		trans = session.beginTransaction();
		session.save(entity);
		trans.commit();
		session.close();
		return entity;
	}

	public T findById(ID id) throws RuntimeException{
		Session session = sessionFactory.openSession();
		return session.get(this.persistentClass, id);
	}

	@Override
	public T findByHql(String strHQL) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(strHQL);
		List list = query.list();
		if(list.size()>0){
			return (T)list.get(0);
		} else {
			return null;
		}
	}

	public void delete(T entity) throws RuntimeException{
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		trans = session.beginTransaction();
		session.delete(entity);
		trans.commit();
		session.close();
	}


	public void update(T entity) throws RuntimeException{
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		trans = session.beginTransaction();
		session.update(entity);
		trans.commit();
		session.close();
	}


	public List<T> findAll() {
		return findByCriteria();
	}

	private Query getQueryWithParams(Session session, String strHQL){
		Query query = session.createQuery(strHQL);
		return query;
	}

	public List<T> findByHQL(String strHQL, Object[] params) {
		Session session = sessionFactory.openSession();
		Query query = getQueryWithParams(session,strHQL);
		session.close();
		return query.list();
	}

	public List<T> findByHQL(String strHQL) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(strHQL);
		session.close();
		return query.list();
	}
	public PageBean findByPage(String strHQL, int currentPage, int pageSize) {
		logger.info("当前页："+currentPage);
		// 步骤1：创建一个PageBean对象
		PageBean pageBean = new PageBean();
		// 步骤2：获取一个数据库链接session
		Session session = sessionFactory.openSession();
		// 步骤3：执行HQL语句完成查询动获取本页内的固定条数的数据
		// 步骤4：设置查询条件-参数条件
		Query query = getQueryWithParams(session,strHQL);
		// 步骤5：设置查询条件-每页的启始记录下标 (当前也是-1)*每页个数
		query.setFirstResult((currentPage - 1) * pageSize);
		// 步骤6：设置查询条件-控制查询记录的个数
		query.setMaxResults(pageSize);
		// 步骤7：获取数据集合并且赋值给pageBean对象的data属性
		pageBean.setData(query.list());
		logger.info(query.list().toString());
		// 步骤8：将输入的HQL语句动态查分成符合返回记录个数的HQL语句
		strHQL = "select count(*) " + strHQL.substring(strHQL.toLowerCase().indexOf("from"));
		// 步骤9：执行HQL语句完成查询动获取本页内的固定条数的数据
		// 步骤10：设置查询条件-参数条件
		query=getQueryWithParams(session,strHQL);
		// 步骤11：获取查询结果并且赋值给pageBean对象的totalRows
		pageBean.setTotalRows(Integer.parseInt(query.uniqueResult().toString()));
//		pageBean.setTotalPages((int)Math.floor(Double.valueOf(query.uniqueResult().toString())/pageSize));
		// 关闭数据库连接
		session.close();
		// 步骤12：为剩余的pageBean属性赋值
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		return pageBean;
	}

	// 内部方法Criteria接口查询
	private List<T> findByCriteria() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(this.persistentClass);
		session.close();
		return criteria.list();
	}

	@Override
	public T getTotalCount(Class<T> entityClass) {
		//TODO
		return null;
	}

	@Override
	public int getPageCount(String hql, Object[] params) {
		//TODO
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List list = query.list();
		return (int)Math.floor(list.size()/(double)params[0]);
	}
}
