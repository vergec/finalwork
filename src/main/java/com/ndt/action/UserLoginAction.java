package com.ndt.action;

import com.ndt.entity.UserEntity;
import com.ndt.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@ParentPackage("struts-default")
@Namespace("/user")
public class UserLoginAction extends ActionSupport {

	private final UserServiceImpl userServiceImpl;
	private UserEntity userEntity;

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Autowired
	public UserLoginAction(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Override
	public void validate() {
		UserEntity temp = userServiceImpl.getUserByName(userEntity);
 		if (temp.getSecret().equals(userEntity.getSecret())) {
			userEntity = temp;
			System.out.println("set userEntity");
		} else {
			addFieldError("userEntity.secret", "密码错误，请重新输入");
			System.out.println("add password error");
		}
		if (!userServiceImpl.isNameExist(userEntity)) {
			addFieldError("userEntity.loginname", "用户名不存在");
			System.out.println("add username error");
		}
	}

	@Action(value = "userLoginAction",
			results = {@Result(name = "userLoginSuccess", location = "/user/user.jsp"),
					@Result(name = "input", location = "/user/user_login.jsp")})
	public String login() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("user", userEntity);
		session.put("type", "user");
		System.out.println("success");
		return "userLoginSuccess";
	}



}
