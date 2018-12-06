package com.ndt.action;

import com.ndt.entity.CarEntity;
import com.ndt.service.CompanyService;

import java.util.List;

public class CarAction {
    private List<CarEntity> carEntities;
    private CompanyService companyService;
    private CarEntity carEntity;
    public String list(){
        carEntities=companyService.listCarEntities();
        return "list";
    }

    public String delete(){
        companyService.deleteCar(carEntity.getCarid());
        return "delete";
    }

    public String update(){
        companyService.updateCar(carEntity);
        return "update";
    }

    public String add(){
        companyService.addCar(carEntity);
        return "add";
    }

    public List<CarEntity> getCarEntities() {
        return carEntities;
    }

    public void setCarEntities(List<CarEntity> carEntities) {
        this.carEntities = carEntities;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }
}
