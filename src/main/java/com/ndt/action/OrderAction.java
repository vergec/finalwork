package com.ndt.action;

import com.ndt.entity.EvaluationEntity;
import com.ndt.entity.OrderEntity;
import com.ndt.service.OrderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Controller
@Namespace("/")
public class OrderAction extends ActionSupport {

	private final OrderService orderService;
	private EvaluationEntity evaluationEntity;
	private OrderEntity orderEntity;
	private String[] time;
	private List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	public String[] getTime() {
		return time;
	}

	public void setTime(String[] time) {
		this.time = time;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public EvaluationEntity getEvaluationEntity() {
		return evaluationEntity;
	}

	public void setEvaluationEntity(EvaluationEntity evaluationEntity) {
		this.evaluationEntity = evaluationEntity;
	}

	@Autowired
	public OrderAction(OrderService orderService) {
		this.orderService = orderService;
	}

	@Action(value = "updateOrder",results = {@Result(location = "/user/showOrder",type = "redirect")})
	public String updateOrder(){
		OrderEntity order = orderService.queryOrderById(Integer.parseInt(ServletActionContext.getRequest().getParameter("orderid")));
		logger.debug(order.toString());
		logger.debug(time[0]+" "+time[1]);
		for(int i=0;i<2;i++){
			int last = time[i].lastIndexOf(":");
			int lastDot = time[i].lastIndexOf(".");
			if(lastDot != -1){
				time[i]=time[i].substring(0,last);
			}
		}
		logger.debug(time[0]+" "+time[1]);
		order.setItemamount(orderEntity.getItemamount());
		order.setItemsize(orderEntity.getItemsize());
		order.setAvailabletime(Timestamp.valueOf(time[0].replace("T"," ")+":00"));
		order.setAvailabletime1(Timestamp.valueOf(time[1].replace("T"," ")+":00"));
		logger.debug(order.toString());
		orderService.updateOrder(order);
		return SUCCESS;
	}

	//删除订单
	@Action(value = "deleteOrder",results = {@Result(location = "/user/showOrder", type = "redirect")})
	public String deleteOrder(){
		OrderEntity orderEntity = orderService.queryOrderById(Integer.parseInt(ServletActionContext.getRequest().getParameter("orderid")));
		orderService.deleteOrder(orderEntity);
		return SUCCESS;
	}

	//更新订单信息，设置为已评价，更新完跳转到获取订单列表Action
	@Action(value = "updateOrderStatusReviewed",results = {@Result(name = "success",location = "/user/showOrder",type = "redirect")})
	public String updateOrderStatusReviewed(){
		OrderEntity orderEntity = orderService.queryOrderById(Integer.parseInt(ServletActionContext.getRequest().getParameter("orderid")));
		orderEntity.setStatus("已评价");
		orderService.updateOrder(orderEntity);
		return SUCCESS;
	}

	//添加评价
	@Action(value = "addEvaluation",results = {@Result(name = "success", type = "chain",location = "updateOrderStatusReviewed"),@Result(name = "error", location = "/addEvaluation.jsp")})
	public String addEvaluation() {
		logger.info(ServletActionContext.getRequest().getParameter("orderid"));
		logger.info("filename:"+fileFileName);
		logger.info("fileContentType:"+fileContentType);
		OrderEntity orderEntity = orderService.queryOrderById(Integer.parseInt(ServletActionContext.getRequest().getParameter("orderid")));
		String root = ServletActionContext.getServletContext().getRealPath("/uploads");
		HttpServletRequest request = ServletActionContext.getRequest() ;
		if (file!=null){
			for(int i = 0; i < (file != null ? file.size() : 0); i ++){
				if(fileFileName!=null && fileFileName.get(i).length()!=0){
					Random random = new Random(99999);
					int tempInt = random.nextInt();
					Date datenew = new Date();
					SimpleDateFormat simpleDateFormatnew = new SimpleDateFormat("yyyyMMddhhmmss");
					int last = fileFileName.get(i).lastIndexOf(".");
					String head = fileFileName.get(i).substring(0,last);
					String type = fileFileName.get(i).substring(last);
					fileFileName.set(i,simpleDateFormatnew.format(datenew) + tempInt + type);
					System.out.println("新的文件名称是："+fileFileName);

					//创建父文件夹
					if(file!=null){
						File saveFile = new File(new File(root), fileFileName.get(i));
						if(!saveFile.getParentFile().exists()){     //如果files文件夹不存在
							saveFile.getParentFile().mkdirs();      //则创建新的多级文件夹
						}
						try {
							FileUtils.copyFile(file.get(i), saveFile);     //保存文件
							ActionContext.getContext().put("message", "上传成功！");

							String path = request.getContextPath();
							String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
							String picturePath = basePath +"uploadfiles"+"/"+fileFileName;
							evaluationEntity.setPhoto1(picturePath);
							//request.setAttribute("uploadsuccess", fileFileName);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		orderService.addUserEvaluation(orderEntity,evaluationEntity, fileFileName);
		return SUCCESS;
	}
}
