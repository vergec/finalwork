package com.ndt.action;

import com.ndt.entity.AdministratorEntity;
import com.ndt.service.AdministratorService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

//@Controller
//@Scope("prototype")
public class LoginAction extends ActionSupport {
	@Resource
	private AdministratorService administratorService;
	private AdministratorEntity administratorEntity;

	public AdministratorEntity getAdministratorEntity() {
		return administratorEntity;
	}

	public void setAdministratorEntity(AdministratorEntity administratorEntity) {
		this.administratorEntity = administratorEntity;
	}

	public AdministratorService getAdministratorService() {
		return administratorService;
	}

	public void setAdministratorService(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("executed");
		if(administratorService.login(administratorEntity)){
			Map session = ActionContext.getContext().getSession();
			session.put("admin",administratorEntity);
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
}
