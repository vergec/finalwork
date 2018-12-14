package com.ndt.service;

import com.ndt.entity.OrderEntity;
import com.ndt.entity.UserEntity;
import com.ndt.vo.PageBean;

import java.util.List;

public interface OrderService {
	void updateOrder(OrderEntity orderEntity);

	OrderEntity addOrder(OrderEntity orderEntity, UserEntity userEntity, int companyId);

	void deleteOrder(OrderEntity orderEntity);

	OrderEntity queryOrderByHql(String hql);

	OrderEntity queryOrderById(int id);

	List<OrderEntity> queryAllOrders();

	List<OrderEntity> queryOrdersByHql(String hql);

	PageBean queryOrderByPageForUser(int userId, int currentPage, int pageSize);


}
