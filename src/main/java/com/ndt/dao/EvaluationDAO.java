package com.ndt.dao;

import com.ndt.entity.EvaluationEntity;

import java.util.List;

public interface EvaluationDAO extends IBaseDAO<EvaluationEntity, Integer> {

	List<EvaluationEntity> getAllEvaluation();

	List<EvaluationEntity> getCompanyEvaluation(int id);

	List<EvaluationEntity> getUserEvaluation(int id);

	EvaluationEntity getOrderEvaluation(int orderId);

	void deleteEvaluation(EvaluationEntity evaluationEntity);

	EvaluationEntity insertEvaluation(EvaluationEntity evaluationEntity);
}
