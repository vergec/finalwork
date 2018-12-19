package com.ndt.dao.impl;

import com.ndt.dao.AGenericHibernateDao;
import com.ndt.dao.OrderDAO;
import com.ndt.entity.OrderEntity;
import com.ndt.vo.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl extends AGenericHibernateDao<OrderEntity,Integer> implements OrderDAO {

	@Override
	public void updateOrder(OrderEntity orderEntity) {
		super.update(orderEntity);
	}

	@Override
	public OrderEntity addOrder(OrderEntity orderEntity) {
		return super.create(orderEntity);
	}

	@Override
	public void deleteOrder(OrderEntity orderEntity) {
		super.delete(orderEntity);
	}

	@Override
	public OrderEntity queryOrderByHql(String hql) {
		return super.findByHql(hql);
	}

	@Override
	public OrderEntity queryOrderById(int id) {
		return findById(id);
	}

	@Override
	public List<OrderEntity> queryAllOrders() {
		return super.findAll();
	}

	@Override
	public List<OrderEntity> queryOrdersForCom(int companyId) {
		return super.findByHQL("from OrderEntity where companyid = '"+companyId+"'");
	}

	@Override
	public List<OrderEntity> queryOrdersByHql(String hql) {
		return findByHQL(hql);
	}

	@Override
	public PageBean queryOrderByPageForUser(int userId, int currentPage, int pageSize) {
		return findByPage("from OrderEntity where userid='"+ userId +"' order by orderid",currentPage,pageSize);
	}

}
