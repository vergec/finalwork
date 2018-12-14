package com.ndt.dao;

import com.ndt.vo.PageBean;
import java.io.Serializable;
import java.util.List;

public interface IBaseDAO<T extends Serializable, ID extends Serializable> {

    T create(final T entity);

    void delete(final T entity);

    void update(final T entity);

	T findById(final ID id);

	T findByHql(final String strHQL);

    List<T> findAll();

    List<T> findByHQL(final String strHQL, final Object[] params);

	List<T> findByHQL(final String strHQL);

    PageBean findByPage(final String strHQL, final int currentPage, final int pageSize);
	/**
	 * 获得总记录数
	 */
	T getTotalCount(Class<T> entityClass);

	int getPageCount(String hql,Object[] params);
}
