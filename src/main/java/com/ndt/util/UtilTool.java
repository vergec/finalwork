package com.ndt.util;

import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EvaluationEntity;
import com.ndt.entity.OrderEntity;
import com.ndt.vo.DetailedOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilTool {
	private static Logger logger = LoggerFactory.getLogger(UtilTool.class);

	public static DetailedOrder createDetailedOrder(OrderEntity orderEntity, CompanyEntity companyEntity, EvaluationEntity evaluationEntity) {
		DetailedOrder detailedOrder = new DetailedOrder();
		detailedOrder.setOrderid(String.valueOf(orderEntity.getOrderid()));
		detailedOrder.setDeparture(orderEntity.getDeparture());
		detailedOrder.setDestination(orderEntity.getDestination());
		detailedOrder.setTime(orderEntity.getTime().toString());
		detailedOrder.setItemsize(String.valueOf(orderEntity.getItemsize()));
		detailedOrder.setAmount(String.valueOf(orderEntity.getItemamount()));
		detailedOrder.setAvailabletime(orderEntity.getAvailabletime() + "~" + orderEntity.getAvailabletime1());
		detailedOrder.setAvailabletimestart(orderEntity.getAvailabletime().toString().replace(" ", "T"));
		detailedOrder.setAvailabletimeend(orderEntity.getAvailabletime1().toString().replace(" ", "T"));
		detailedOrder.setStatus(orderEntity.getStatus());
		detailedOrder.setCompanyid(String.valueOf(companyEntity.getCompanyid()));
		detailedOrder.setCompanyname(companyEntity.getCompanyname());
		if (orderEntity.getStatus().equals("等待收件")) {
			detailedOrder.setDeliverytime("尚未收件");
			detailedOrder.setFinishtime("尚未发货");
			detailedOrder.setPrice("尚未收件");
		} else if (orderEntity.getStatus().equals("已发货")) {
			detailedOrder.setFinishtime("进行中");
			detailedOrder.setPrice(String.valueOf(orderEntity.getPrice()));
			detailedOrder.setDeliverytime(orderEntity.getDeliverytime().toString());
		} else {
			detailedOrder.setDeliverytime(orderEntity.getDeliverytime().toString());
			detailedOrder.setFinishtime(orderEntity.getFinishtime().toString());
			detailedOrder.setPrice(String.valueOf(orderEntity.getPrice()));
		}
		if (evaluationEntity != null) {
			if (!evaluationEntity.getPhoto1().equals("") || evaluationEntity.getPhoto1() != null) {
				detailedOrder.setPic(evaluationEntity.getPhoto1());
			}
			logger.info("评价内容：" + evaluationEntity.getContent());
			detailedOrder.setEvaluation(evaluationEntity.getContent());
		}
		return detailedOrder;
	}
}
