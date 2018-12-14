package com.ndt.service.impl;

import com.ndt.dao.OrderDAO;
import com.ndt.entity.OrderEntity;
import com.ndt.entity.UserEntity;
import com.ndt.service.OrderService;
import com.ndt.vo.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderDAO orderDAO;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public OrderServiceImpl(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public void updateOrder(OrderEntity orderEntity) {
		orderDAO.updateOrder(orderEntity);
	}

	@Override
	public OrderEntity addOrder(OrderEntity orderEntity, UserEntity userEntity, int companyId) {
		orderEntity.setTime(new Timestamp(new Date().getTime()));
		orderEntity.setUserid(userEntity.getUserid());
		orderEntity.setCompanyid(companyId);
		orderEntity.setStatus("等待收件");
		orderEntity.setAvailabletime(Timestamp.valueOf(orderEntity.getAvailabletime().toString().replace("T"," ")));
		orderEntity.setAvailabletime1(Timestamp.valueOf(orderEntity.getAvailabletime1().toString().replace("T"," ")));
		logger.info(orderEntity.toString());
		return orderDAO.addOrder(orderEntity);
	}

	@Override
	public void deleteOrder(OrderEntity orderEntity) {
		orderDAO.deleteOrder(orderEntity);
	}

	@Override
	public OrderEntity queryOrderByHql(String hql) {
		return orderDAO.queryOrderByHql(hql);
	}

	@Override
	public OrderEntity queryOrderById(int id) {
		return orderDAO.queryOrderById(id);
	}

	@Override
	public List<OrderEntity> queryAllOrders() {
		return orderDAO.queryAllOrders();
	}

	@Override
	public List<OrderEntity> queryOrdersByHql(String hql) {
		return orderDAO.queryOrdersByHql(hql);
	}

	@Override
	public PageBean queryOrderByPageForUser(int userId, int currentPage, int pageSize) {
		return orderDAO.queryOrderByPageForUser(userId,currentPage,pageSize);
	}


}
