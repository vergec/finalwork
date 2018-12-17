package com.ndt.service.impl;

import com.ndt.dao.AdministratorDAO;
import com.ndt.entity.AdministratorEntity;
import com.ndt.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	private AdministratorDAO administratorDAO;

	public AdministratorDAO getAdministratorDAO() {
		return administratorDAO;
	}

	public void setAdministratorDAO(AdministratorDAO administratorDAO) {
		this.administratorDAO = administratorDAO;
	}

	@Override
	public boolean login(AdministratorEntity administratorEntity) {
		return administratorDAO.login(administratorEntity);
	}
}
