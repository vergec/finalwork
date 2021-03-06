package com.ndt.service.impl;

import com.ndt.dao.EvaluationDAO;
import com.ndt.dao.OrderDAO;
import com.ndt.entity.EvaluationEntity;
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

	private final EvaluationDAO evaluationDAO;
	private final OrderDAO orderDAO;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public OrderServiceImpl(EvaluationDAO evaluationDAO, OrderDAO orderDAO) {
		this.evaluationDAO = evaluationDAO;
		this.orderDAO = orderDAO;
	}

	@Override
	public void updateOrder(OrderEntity orderEntity) {
		orderDAO.updateOrder(orderEntity);
	}

	@Override
	public OrderEntity addOrder(OrderEntity orderEntity, UserEntity userEntity, int companyId, String[] time) {
		orderEntity.setTime(new Timestamp(new Date().getTime()));
		orderEntity.setUserid(userEntity.getUserid());
		orderEntity.setCompanyid(companyId);
		orderEntity.setStatus("等待收件");
		logger.info(time[0]+" "+time[1]);
		orderEntity.setAvailabletime(Timestamp.valueOf(time[0].replace("T"," ")+":00"));
		orderEntity.setAvailabletime1(Timestamp.valueOf(time[1].replace("T"," ")+":00"));
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



//	用户查看订单分页方法
	@Override
	public PageBean queryOrderByPageForUser(int userId, int currentPage, int pageSize) {
		return orderDAO.queryOrderByPageForUser(userId,currentPage,pageSize);
	}

//	用户添加评价使用
	@Override
	public void addUserEvaluation(OrderEntity orderEntity, EvaluationEntity evaluationEntity, List<String> fileName) {
		evaluationEntity.setUserid(orderEntity.getUserid());
		evaluationEntity.setCompanyid(orderEntity.getCompanyid());
		evaluationEntity.setOrderid(orderEntity.getOrderid());
		evaluationEntity.setTime(new Timestamp(new Date().getTime()));
		evaluationEntity.setPhoto1(fileName.get(0));
		if (fileName.size()>=2)
			evaluationEntity.setPhoto2(fileName.get(1));
		if (fileName.size()>=3)
			evaluationEntity.setPhoto3(fileName.get(2));
		evaluationDAO.insertEvaluation(evaluationEntity);
	}

	@Override
	public List<OrderEntity> queryAllOrdersForCom(int companyId){
		return orderDAO.queryOrdersForCom(companyId);
	}
}
