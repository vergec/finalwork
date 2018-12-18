package com.ndt.action;

import com.ndt.dao.EvaluationDAO;
import com.ndt.entity.AdministratorEntity;
import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EvaluationEntity;
import com.ndt.entity.UserEntity;
import com.ndt.service.AdministratorService;
import com.ndt.service.CompanyService;
import com.ndt.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

@Controller
@Namespace("/admin")
public class AdminAction {
    private final UserService userService;
    private final CompanyService companyService;
    private final AdministratorService administratorService;
    private final EvaluationDAO evaluationDAO;
    private EvaluationEntity evaluationEntity;
    private AdministratorEntity administratorEntity;
    private UserEntity userEntity;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public AdminAction(UserService userService, CompanyService companyService, AdministratorService administratorService, EvaluationDAO evaluationDAO) {
        this.userService = userService;
        this.companyService = companyService;
        this.administratorService=administratorService;
        this.evaluationDAO = evaluationDAO;
    }

    @Action(value = "adminLogin",
            results = {
                    @Result(name = "success", location = "/admin/admin.jsp"),
                    @Result(name = "error", location = "/admin/adminLogin.jsp")
            })
    public String adminLogin(){
        if(administratorService.login(administratorEntity)){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    @Action(value = "updateUserAction",
            results = {@Result(name = "success", type = "redirect", location = "getAllUserAction")})
    public String updateUserAction(){
        userService.updateUser(userEntity);
        return SUCCESS;
    }

    @Action(value = "deleteUserAction",
            results = {@Result(name = "success", type = "redirect", location = "getAllUserAction")})
    public String deleteUserAction(){
        userService.deleteUser(userService.getUserById(userEntity.getUserid()));
        return SUCCESS;
    }

    @Action(value = "deleteEvaluationAction",
            results = {@Result(name = "success", type = "redirect", location = "getAllEvaluationAction")})
    public String deleteEvaluation(){
        evaluationDAO.deleteEvaluation(evaluationEntity);
        return SUCCESS;
    }

    @Action(value = "getAllEvaluationAction",
            results = {@Result(name = "success", location = "/admin/showEvaluation.jsp")})
    public String getAllEvaluationAction(){
        List<EvaluationEntity> list = evaluationDAO.getAllEvaluation();
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("evaluationList", list);
        return SUCCESS;
    }

    @Action(value = "getAllUserAction",
            results = {@Result(name = "success", location = "/admin/showUser.jsp")})
    public String getAllUser(){
        List<UserEntity> list = userService.getAllUser();
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("userList", list);
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public AdministratorEntity getAdministratorEntity() {
        return administratorEntity;
    }

    public void setAdministratorEntity(AdministratorEntity administratorEntity) {
        this.administratorEntity = administratorEntity;
    }

    public EvaluationEntity getEvaluationEntity() {
        return evaluationEntity;
    }

    public void setEvaluationEntity(EvaluationEntity evaluationEntity) {
        this.evaluationEntity = evaluationEntity;
    }
}
