package com.shiva.app.service;

import com.shiva.app.model.HospitalInfo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
public class HospitalService {

	public HospitalInfo updateDetail(HospitalInfo hospitalInfo,String name,String city){
		hospitalInfo.setName(name);
		hospitalInfo.setCity(city);
		return hospitalInfo;
	}

}
