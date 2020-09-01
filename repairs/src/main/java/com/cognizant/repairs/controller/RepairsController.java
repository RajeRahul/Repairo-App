package com.cognizant.repairs.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.repairs.model.Repairman;
import com.cognizant.repairs.service.RepairsService;

@Controller
public class RepairsController {
	
	@Autowired
	RepairsService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		List<Repairman> repairlist = service.getTopTwentyRepairmen();
		model.put("repairlist", repairlist);
		return "home";
	}
	
	@RequestMapping(value="/searchrepairmen", method=RequestMethod.GET)
	public String showSearchPage(ModelMap model) {
		List<String> occupationlist = service.getOccupationList();
		List<String> locationlist = service.getLocationList();
		model.put("occupationlist",occupationlist);
		model.put("locationlist", locationlist);
		return "searchrepairmen";
	}
	
	@RequestMapping(value="/results", method=RequestMethod.GET)
	public String showResultPage(ModelMap model, @RequestParam Map<String,String> params) {
		List<Repairman> resultlist = service.getResults(params);
		model.put("resultlist", resultlist);
		return "result";
	}
	
	@RequestMapping(value="/servicerequest", method=RequestMethod.GET)
	public String showServicePage(ModelMap model, @RequestParam int id) {
		List<Repairman> repairman = service.getRepairmanById(id);
		model.put("repairman", repairman);
		return "servicerequest";
	}
	
	@RequestMapping(value="/repairamOccupation", method=RequestMethod.GET)
	public String showOccupationPage(ModelMap model, @RequestParam String occupationParam) {
		List<Repairman> repairman = service.getRepairmenByOccupation(occupationParam);
		model.put("occupationParam", occupationParam);
		model.put("repairman", repairman);
		return "occupation";
	}
	
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public String showSuccessPage(ModelMap model, @RequestParam Map<String,String> params) {
		service.addRequest(params);
		return "success";
	}
	
}
