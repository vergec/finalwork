package com.ndt.action;

import com.ndt.entity.*;
import com.ndt.service.CompanyService;
import com.ndt.service.OrderService;
import com.ndt.util.UtilTool;
import com.ndt.vo.AcceptOrderParam;
import com.ndt.vo.DetailedOrder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Namespace("/")
public class CompanyOrderAction extends ActionSupport {

	private final OrderService orderService;
	private final CompanyService companyService;
	private AcceptOrderParam acceptOrderParam;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public CompanyOrderAction(CompanyService companyService, OrderService orderService) {
		this.companyService = companyService;
		this.orderService = orderService;
	}

	public AcceptOrderParam getAcceptOrderParam() {
		return acceptOrderParam;
	}

	public void setAcceptOrderParam(AcceptOrderParam acceptOrderParam) {
		this.acceptOrderParam = acceptOrderParam;
	}

	@Action(value = "listOrderAction", results = {@Result(location = "/company/showOrder.jsp")})
	public String listOrderAction() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String id = session.get("companyId").toString();
		logger.debug("companyid:"+id);
		int companyId = Integer.valueOf(id);
		List<OrderEntity> list = orderService.queryAllOrdersForCom(companyId);
		CompanyEntity companyEntity = companyService.findCompanyEntity(companyId);
		List<DetailedOrder> detailedOrderList = new ArrayList<>();
		for (OrderEntity a : list) {
			logger.debug(a.toString());
			EvaluationEntity evaluationEntity = companyService.queryEvaluation(a.getOrderid());
			DetailedOrder detailedOrder = UtilTool.createDetailedOrder(a, companyEntity, evaluationEntity);
			detailedOrderList.add(detailedOrder);
		}
		ServletActionContext.getRequest().setAttribute("page", 0);
		session.put("b", detailedOrderList);
		return SUCCESS;
	}

	@Action(value = "preAcceptOrder", results = {@Result(name = "success", location = "/company/acceptOrder.jsp")})
	public String preAcceptOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> session = ActionContext.getContext().getSession();
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		session.put("orderid", orderid);
		List<CarEntity> carEntityList = companyService.listCarEntities();
		List<EmployeeEntity> employeeEntityList = companyService.listEmployeeEntities();
		request.setAttribute("carEntityList", carEntityList);
		request.setAttribute("employeeEntityList", employeeEntityList);
		return SUCCESS;
	}

	@Action(value = "acceptOrder", results = {@Result(location = "/listOrderAction",type = "redirect")})
	public String acceptOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> session = ActionContext.getContext().getSession();
		int orderid = Integer.parseInt(session.get("orderid").toString());
		OrderEntity orderEntity = orderService.queryOrderById(orderid);
		orderEntity.setDeliverytime(new Timestamp(System.currentTimeMillis()));
		orderEntity.setStatus("已发货");
		orderEntity.setCarid(getAcceptOrderParam().getCarid());
		orderEntity.setPrice(getAcceptOrderParam().getPrice());
		orderService.updateOrder(orderEntity);
		return SUCCESS;
	}

	@Action(value = "finishDelivery",results = {@Result(location = "/listOrderAction",type = "redirect")})
	public String finishDelivery() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		OrderEntity orderEntity = orderService.queryOrderById(orderid);
		orderEntity.setFinishtime(new Timestamp(System.currentTimeMillis()));
		orderEntity.setStatus("已送达");
		orderService.updateOrder(orderEntity);
		return SUCCESS;
	}

	@Action(value = "showCompanyEvaluation",results = {@Result(location = "/company/showCompanyEvaluation.jsp")})
	public String showCompanyEvaluation() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		List<EvaluationEntity> evaluationEntityList = companyService.queryAllEvaluation(Integer.parseInt(session.get("companyId").toString()));
		session.put("evaluationEntityList",evaluationEntityList);
		return SUCCESS;
	}
}
