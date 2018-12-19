package com.ndt.action;

import com.ndt.entity.UserEntity;
import com.ndt.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.regex.Pattern;

@Controller
@ParentPackage("struts-default")
@Namespace("/user")
@Results({@Result(name="success",location = "/user/user_login.jsp"),
		@Result(name = "input",location = "/user/user_register.jsp")})
public class UserRegisterAction extends ActionSupport {

	private final UserServiceImpl userService;
	private UserEntity userEntity;
	private String rePassword;

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Autowired
	public UserRegisterAction(UserServiceImpl userService) {
		this.userService = userService;
	}

	@Override
	public void validate() {
		//验证密码和用户名格式
		String patten = "^[a-z0-9]{6,15}$";
		if (!Pattern.matches(patten, userEntity.getSecret())){
			addFieldError("userEntity.secret","密码必须由6-15位的字母和数字组成");
		}
		if (!Pattern.matches(patten, userEntity.getLoginname())){
			addFieldError("userEntity.loginname","用户名必须由6-15位的字母和数字组成");
		}
		//验证用户名重复
		UserEntity user = userService.getUserByName(userEntity);
		if(user!=null){
			addFieldError("userEntity.loginname","用户名已存在");
		}
//		//验证重复密码输入正确
//		if (userEntity.getSecret().equals(rePassword)){
//			addFieldError("rePassword","密码不一致");
//		}
		//验证邮件格式
		patten = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		if (!Pattern.matches(patten,userEntity.getEmail())){
			addFieldError("userEntity.email","邮件格式出错");
		}
		//验证电话格式
		patten = "^(13\\d|14[57]|15[012356789]|18[012356789])\\d{8}$";
		if (!Pattern.matches(patten,userEntity.getPhone())){
			addFieldError("userEntity.phone","电话格式出错");
		}
	}

	@Action("userRegisterAction")
	public String register() throws Exception {
		userEntity.setImg("default.png");
		userService.register(userEntity);
		return SUCCESS;
	}
}
