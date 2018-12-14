package com.ndt.dao;

import com.ndt.entity.OrderEntity;
import com.ndt.vo.PageBean;

import java.util.List;

public interface OrderDAO extends IBaseDAO<OrderEntity, Integer> {

	void updateOrder(OrderEntity orderEntity);

	OrderEntity addOrder(OrderEntity orderEntity);

	void deleteOrder(OrderEntity orderEntity);

	OrderEntity queryOrderByHql(String hql);

	OrderEntity queryOrderById(int id);

	List<OrderEntity> queryAllOrders();

	List<OrderEntity> queryOrdersByHql(String hql);

	PageBean queryOrderByPageForUser(int userId, int currentPage, int pageSize);
}
