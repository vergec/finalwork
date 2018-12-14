package com.ndt.dao.impl;

import com.ndt.dao.AGenericHibernateDao;
import com.ndt.dao.EvaluationDAO;
import com.ndt.entity.EvaluationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EvaluationDAOImpl extends AGenericHibernateDao<EvaluationEntity, Integer> implements EvaluationDAO {
	@Override
	public List<EvaluationEntity> getAllEvaluation() {
		return findAll();
	}

	@Override
	public List<EvaluationEntity> getCompanyEvaluation(int id) {
		return findByHQL("from EvaluationEntity where companyid = '"+id+"'");
	}

	@Override
	public List<EvaluationEntity> getUserEvaluation(int id) {
		return findByHQL("from EvaluationEntity where userid = '"+id+"'");	}

	@Override
	public EvaluationEntity getOrderEvaluation(int orderId) {
		return findByHql("from EvaluationEntity where orderid ='"+orderId+"'");
	}

	@Override
	public void deleteEvaluation(EvaluationEntity evaluationEntity) {
		delete(evaluationEntity);
	}

	@Override
	public EvaluationEntity insertEvaluation(EvaluationEntity evaluationEntity) {
		return create(evaluationEntity);
	}
}
