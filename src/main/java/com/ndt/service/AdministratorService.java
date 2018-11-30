package com.ndt.service;

import com.ndt.dao.AdministratorDAO;
import com.ndt.entity.AdministratorEntity;

public class AdministratorService {
	private AdministratorDAO administratorDAO;

	public AdministratorDAO getAdministratorDAO() {
		return administratorDAO;
	}

	public void setAdministratorDAO(AdministratorDAO administratorDAO) {
		this.administratorDAO = administratorDAO;
	}

	public boolean login(AdministratorEntity admin){
		return administratorDAO.login(admin);
	}
}
