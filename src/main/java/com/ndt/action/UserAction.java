package com.ndt.action;

import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EvaluationEntity;
import com.ndt.entity.OrderEntity;
import com.ndt.entity.UserEntity;
import com.ndt.service.CompanyService;
import com.ndt.service.OrderService;
import com.ndt.service.UserService;
import com.ndt.util.UtilTool;
import com.ndt.vo.DetailedOrder;
import com.ndt.vo.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Namespace("/user")
public class UserAction extends ActionSupport {

	private final UserService userService;
	private final CompanyService companyService;
	private final OrderService orderService;
	private UserEntity userEntity;
	private OrderEntity orderEntity;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String[] time;
	private File file;
	private String fileFileName;
	private String fileContentType;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

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

	@Action(value = "getAllCompanyAction",
			results = {@Result(name = "success", location = "/latestCompanyInformation.jsp")})
	public String getCompany() {
		List<CompanyEntity> list = companyService.listCompanyEntities();
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("companyList", list);
		logger.info("list size:" + list.size());
		return SUCCESS;
	}

	@Action(value = "getCompanyAction",
			results = {@Result(name = "success", location = "/user/showCompany.jsp")})
	public String getAllCompany() {
		List<CompanyEntity> list = companyService.listCompanyEntities();
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("companyList", list);
		logger.info("list size:" + list.size());
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
			results = {@Result(name = "success", type = "redirect", location = "showOrder")})
	public String addOrder() {
		logger.info(orderEntity.toString());
		UserEntity user = (UserEntity) ActionContext.getContext().getSession().get("user");
		int companyId = Integer.parseInt(ActionContext.getContext().getSession().get("companyId").toString());
		logger.debug(String.valueOf(user.getUserid()));
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
			logger.debug("request get page:" + Integer.parseInt(request.getParameter("page")));
		}
		if (type.equals("user")) {
			UserEntity user = (UserEntity) session.get("user");
			logger.debug("page:" + page);
			pageBean = orderService.queryOrderByPageForUser(user.getUserid(), page, 5);
		}
		logger.info(String.valueOf(Objects.requireNonNull(pageBean).getTotalPages()));
		logger.info(String.valueOf(Objects.requireNonNull(pageBean).getData().size()));
		request.setAttribute("res", pageBean);
		return SUCCESS;
	}

	@Action(value = "detailedOrderCreator", results = {@Result(name = "success", location = "/user/showOrder.jsp")})
	public String detailedOrderCreator() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("orderid"));
		OrderEntity orderEntity = orderService.queryOrderById(id);
		CompanyEntity companyEntity = companyService.findCompanyEntity(orderEntity.getCompanyid());
		EvaluationEntity evaluationEntity = userService.queryEvaluation(orderEntity.getOrderid());
		DetailedOrder detailedOrder = UtilTool.createDetailedOrder(orderEntity, companyEntity, evaluationEntity);
		ActionContext.getContext().getSession().put("b", detailedOrder);
		return SUCCESS;
	}

	@Action(value = "editInfo", results = {@Result(name = "success", location = "/user/welcome.jsp")})
	public String editPersonalInfo() {
		UserEntity user = (UserEntity) ActionContext.getContext().getSession().get("user");
		if (userEntity.getSecret().equals("")) {
			userEntity.setSecret(user.getSecret());
		}
		if (file == null) {
			userEntity.setImg(user.getImg());
		}
		String root = ServletActionContext.getServletContext().getRealPath("/uploads");
		HttpServletRequest request = ServletActionContext.getRequest();
		if (file != null) {
			logger.debug("start save pic");
			if (fileFileName != null && fileFileName.length() != 0) {
				int tempInt = new Random(99999).nextInt();
				Date dateNew = new Date();
				SimpleDateFormat simpleDateFormatNew = new SimpleDateFormat("yyyyMMddhhmmss");
				int last = fileFileName.lastIndexOf(".");
				String head = fileFileName.substring(0, last);
				String type = fileFileName.substring(last);
				fileFileName = simpleDateFormatNew.format(dateNew) + tempInt + type;
				System.out.println("新的文件名称是：" + fileFileName);

				//创建父文件夹
				if (file != null) {
					File saveFile = new File(new File(root), fileFileName);
					if (!saveFile.getParentFile().exists()) {     //如果files文件夹不存在
						saveFile.getParentFile().mkdirs();      //则创建新的多级文件夹
					}
					try {
						FileUtils.copyFile(file, saveFile);     //保存文件
						userEntity.setImg(fileFileName);
						logger.debug("after save:" + userEntity.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		user = userService.updateUser(user, userEntity);
		logger.debug("after:" + userEntity.toString());
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().put("user", user);
		return SUCCESS;
	}

	@Action(value = "receiveOrder", results = {@Result(location = "/user/showOrder", type = "redirect")})
	public String receiveOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		OrderEntity orderEntity = orderService.queryOrderById(orderid);
		orderEntity.setStatus("已完成");
		orderService.updateOrder(orderEntity);
		return SUCCESS;
	}

	@Action(value = "userExit", results = {@Result(location = "/index.jsp",type = "redirect")})
	public String userExit() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("user");
		session.remove("type");
		return SUCCESS;
	}
}
