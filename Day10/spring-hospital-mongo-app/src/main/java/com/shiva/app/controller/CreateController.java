package com.shiva.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/hospital")
public class CreateController {
  @Autowired
  HospitalRepository hospitalRepo;

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public Hospital create(@RequestBody Hospital hospital) {
    hospital = hospitalRepo.save(hospital);
    return hospital;
  }

  @RequestMapping(value = "/read", method = RequestMethod.GET)
  public List<Hospital> readCustomer() {
    return hospitalRepo.findAll();
  }

  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public void modifyByID(@RequestParam String Id, @RequestParam String name) {
    Hospital hospital = hospitalRepo.findByName(name);
    hospital.setId(Id);
    hospitalRepo.save(hospital);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public void deleteByID(@RequestParam String name) {
    hospitalRepo.deleteByname(name);
  }

  @RequestMapping(value = "/findByid", method = RequestMethod.GET)
  public void findByID(@RequestParam String Id) {
    hospitalRepo.findById(Id);
  }

}
