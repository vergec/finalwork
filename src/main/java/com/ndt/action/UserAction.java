package com.ndt.action;

import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EvaluationEntity;
import com.ndt.entity.OrderEntity;
import com.ndt.entity.UserEntity;
import com.ndt.service.CompanyService;
import com.ndt.service.OrderService;
import com.ndt.service.UserService;
import com.ndt.vo.DetailedOrder;
import com.ndt.vo.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@Namespace("/user")
public class UserAction extends ActionSupport {

	private final UserService userService;
	private final CompanyService companyService;
	private final OrderService orderService;
	private OrderEntity orderEntity;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String[] time;

	public String[] getTime() {
		return time;
	}

	public void setTime(String[] time) {
		this.time = time;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	@Autowired
	public UserAction(UserService userService, CompanyService companyService, OrderService orderService) {
		this.userService = userService;
		this.companyService = companyService;
		this.orderService = orderService;
	}

	@Action(value = "getCompanyAction",
			results = {@Result(name = "success", location = "/user/showCompany.jsp")})
	public String getAllCompany() {
		List<CompanyEntity> list = companyService.listCompanyEntities();
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("companyList", list);
		return SUCCESS;
	}

	@Action(value = "getAllCompanyAction",
			results = {@Result(name = "success", location = "/latestCompanyInformation.jsp")})
	public String getCompany() {
		List<CompanyEntity> list = companyService.listCompanyEntities();
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("companyList", list);
		logger.info("list size:"+list.size());
		return SUCCESS;
	}

	@Action(value = "adminGetAllCompanyAction",
			results = {@Result(name = "success", location = "/admin/showCompany.jsp")})
	public String getCompanies() {
		List<CompanyEntity> list = companyService.listCompanyEntities();
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("companyList", list);
		logger.info("list size:"+list.size());
		return SUCCESS;
	}

	@Action(value = "setCompanyIdToSession",
			results = {@Result(name = "success", location = "/user/addOrder.jsp")})
	public String setCompanyIdToSession() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String companyId = request.getParameter("companyId");
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("companyId", companyId);
		return SUCCESS;
	}

	@Action(value = "addOrder",
			results = {@Result(name = "success",type = "redirect",location = "showOrder")})
	public String addOrder() {
		logger.info(orderEntity.toString());
		UserEntity user = (UserEntity) ActionContext.getContext().getSession().get("user");
		int companyId = Integer.parseInt(ActionContext.getContext().getSession().get("companyId").toString());
		orderService.addOrder(orderEntity, user, companyId, time);
		logger.info(orderEntity.toString());
		return SUCCESS;
	}

	@Action(value = "showOrder",
			results = {@Result(name = "success", location = "/user/briefOrder.jsp")})
	public String showOrder() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String type = (String) session.get("type");
		PageBean pageBean = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = 1;
		if (request.getParameter("page") == null) {
			request.setAttribute("page", 1);
			logger.debug("set page");
		} else {
			page = Integer.parseInt(request.getParameter("page"));
			request.setAttribute("page", page);
			logger.debug("request get page:"+Integer.parseInt(request.getParameter("page")));
		}
		if (type.equals("user")) {
			UserEntity user = (UserEntity) session.get("user");
			logger.debug("page:"+page);
			pageBean = orderService.queryOrderByPageForUser(user.getUserid(), page, 5);
		}
		logger.info(String.valueOf(Objects.requireNonNull(pageBean).getTotalPages()));
		logger.info(String.valueOf(Objects.requireNonNull(pageBean).getData().size()));
		request.setAttribute("res", pageBean);
		return SUCCESS;
	}

	@Action(value = "detailedOrderCreator",results = {@Result(name = "success", location = "/user/showOrder.jsp")})
	public String detailedOrderCreator() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("orderid"));
		OrderEntity orderEntity = orderService.queryOrderById(id);
		CompanyEntity companyEntity = companyService.findCompanyEntity(orderEntity.getCompanyid());
		EvaluationEntity evaluationEntity = userService.queryEvaluation(orderEntity.getOrderid());
		DetailedOrder detailedOrder = new DetailedOrder();
		detailedOrder.setOrderid(String.valueOf(orderEntity.getOrderid()));
		detailedOrder.setDeparture(orderEntity.getDeparture());
		detailedOrder.setDestination(orderEntity.getDestination());
		detailedOrder.setTime(orderEntity.getTime().toString());
		detailedOrder.setItemsize(String.valueOf(orderEntity.getItemsize()));
		detailedOrder.setAmount(String.valueOf(orderEntity.getItemamount()));
		detailedOrder.setAvailabletime(orderEntity.getAvailabletime() + "~" + orderEntity.getAvailabletime1());
		detailedOrder.setAvailabletimestart(orderEntity.getAvailabletime().toString().replace(" ","T"));
		detailedOrder.setAvailabletimeend(orderEntity.getAvailabletime1().toString().replace(" ","T"));
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
			if (!evaluationEntity.getPhoto1().equals("")||evaluationEntity.getPhoto1()!=null){
				detailedOrder.setPic(evaluationEntity.getPhoto1());
			}
			logger.info("评价内容：" + evaluationEntity.getContent());
			detailedOrder.setEvaluation(evaluationEntity.getContent());
		}
		ActionContext.getContext().getSession().put("b", detailedOrder);
		return SUCCESS;
	}
}
