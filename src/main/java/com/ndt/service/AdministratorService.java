package com.ndt.service;

import com.ndt.dao.AdministratorDAO;
import com.ndt.entity.AdministratorEntity;

import javax.annotation.Resource;
import java.util.List;

public class AdministratorService {
	@Resource(name = "administratorDAO")
	private AdministratorDAO administratorDAO;

	public AdministratorDAO getAdministratorDAO() {
		return administratorDAO;
	}

	public void setAdministratorDAO(AdministratorDAO administratorDAO) {
		this.administratorDAO = administratorDAO;
	}

	public boolean login(AdministratorEntity administratorEntity){
		String hql = "from AdministratorEntity as admin where loginname = ?";
		Object[] l = {administratorEntity.getLoginname()};
		List<AdministratorEntity> list = administratorDAO.findByHQL(hql,l);
		for(Object a:list){
			AdministratorEntity b = (AdministratorEntity) a;
			if(b.getSecret().equals(administratorEntity.getSecret())){
				return true;
			}
		}
		return false;
	}
}
