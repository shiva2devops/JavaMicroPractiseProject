package com.shiva.app.controller;

import com.shiva.app.exception.HostpitalCityNotFoundException;
import com.shiva.app.exception.HostpitalNameNotFoundException;
import com.shiva.app.model.HospitalInfo;
import com.shiva.app.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HospController {

    @Autowired
    HospitalService hospitalService;

    @PostMapping("/hospital/save")
    public HospitalInfo saveHospital(@RequestBody HospitalInfo hospitalInfo){
        if (hospitalInfo.getName() == null){
            throw new HostpitalNameNotFoundException("Hospital name is null");
        }
        if (hospitalInfo.getId() == null){
            throw new HostpitalNameNotFoundException("Hospital Id is null");
        }
        return hospitalInfo;
    }

    @PostMapping("/hospital/update")
    public HospitalInfo updateHospital(@RequestBody HospitalInfo hospitalInfo){
        if (hospitalInfo.getCity() == null){
            throw new HostpitalCityNotFoundException("Hospital city is null");
        }

        return hospitalInfo;
    }

}
