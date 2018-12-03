package com.ndt.dao;

import com.ndt.vo.PageBean;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AGenericHibernateDao<T extends Serializable, ID extends Serializable> implements IBaseDAO<T, ID> {
	private Class<T> persistentClass;
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public AGenericHibernateDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T create(T entity) {
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.save(entity);
			trans.commit();
			return entity;
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			if (trans != null)
				trans.rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public T findById(ID id) {
		Session session = sessionFactory.openSession();
		try {
			return session.get(this.persistentClass, id);
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public T findByHql(String strHQL) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(strHQL);
		List list = query.list();
		if(list.get(0)!=null){
			return (T)list.get(0);
		} else {
			return null;
		}
	}

	public void delete(ID id) {
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.delete(findById(id));
			trans.commit();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			if (trans != null)
				trans.rollback();
		} finally {
			session.close();
		}
	}


	public void update(T entity) {
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.update(entity);
			trans.commit();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			if (trans != null)
				trans.rollback();
		} finally {
			session.close();
		}

	}


	public List<T> findAll() {
		return findByCriteria();
	}

	private Query getQueryWithParams(Session session, String strHQL, Object[] params){
		Query query = session.createQuery(strHQL);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query;
	}

	public List<T> findByHQL(String strHQL, Object[] params) {
		Session session = sessionFactory.openSession();
		Query query = getQueryWithParams(session,strHQL,params);
		session.close();
		return query.list();
	}

	public List<T> findByHQL(String strHQL) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(strHQL);
		session.close();
		return query.list();
	}
	public PageBean findByPage(String strHQL, int currentPage, int pageSize, Object[] params) {
		// 步骤1：创建一个PageBean对象
		PageBean pageBean = new PageBean();
		// 步骤2：获取一个数据库链接session
		Session session = sessionFactory.openSession();
		// 步骤3：执行HQL语句完成查询动获取本页内的固定条数的数据
		// 步骤4：设置查询条件-参数条件
		Query query = getQueryWithParams(session,strHQL,params);
		// 步骤5：设置查询条件-每页的启始记录下标 (当前也是-1)*每页个数
		query.setFirstResult((currentPage - 1) * pageSize);
		// 步骤6：设置查询条件-控制查询记录的个数
		query.setMaxResults(pageSize);
		// 步骤7：获取数据集合并且赋值给pageBean对象的data属性
		pageBean.setData(query.list());
		// 步骤8：将输入的HQL语句动态查分成符合返回记录个数的HQL语句
		strHQL = "select count(*) " + strHQL.substring(strHQL.toLowerCase().indexOf("from"));
		// 步骤9：执行HQL语句完成查询动获取本页内的固定条数的数据
		// 步骤10：设置查询条件-参数条件
		query=getQueryWithParams(session,strHQL,params);
		// 步骤11：获取查询结果并且赋值给pageBean对象的totalRows
		pageBean.setTotalRows(Integer.parseInt(query.uniqueResult().toString()));
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
	public T getPageCount(String hql, Object[] params) {
		//TODO
		return null;
	}
}
