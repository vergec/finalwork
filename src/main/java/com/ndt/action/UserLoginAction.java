package com.ndt.action;

import com.ndt.entity.UserEntity;
import com.ndt.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@ParentPackage("struts-default")
@Namespace("/user")
public class UserLoginAction extends ActionSupport {

	private final UserServiceImpl userService;
	private UserEntity userEntity;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Autowired
	public UserLoginAction(UserServiceImpl userService) {
		this.userService = userService;
	}

	@Override
	public void validate() {
		UserEntity temp = userService.getUserByName(userEntity);
		if (temp.getSecret().equals(userEntity.getSecret())) {
			userEntity = temp;
			System.out.println("set userEntity");
		} else {
			addFieldError("userEntity.secret", "密码错误，请重新输入");
			System.out.println("add password error");
		}
		if (!userService.isNameExist(userEntity)) {
			addFieldError("userEntity.loginname", "用户名不存在");
			System.out.println("add username error");
		}
	}

	@Action(value = "userLoginAction",
			results = {@Result(name = "userLoginSuccess", location = "/user/user.jsp",type = "redirect"),
					@Result(name = "input", location = "/user/user_login.jsp",type = "redirect")})
	public String login() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		userEntity = userService.getUserByName(userEntity);
		logger.debug(userEntity.toString());
		session.put("user", userEntity);
		session.put("type", "user");
		System.out.println("success");
		return "userLoginSuccess";
	}



}
