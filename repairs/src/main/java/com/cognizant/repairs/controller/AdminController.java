package com.cognizant.repairs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.repairs.exception.NoRequestException;
import com.cognizant.repairs.model.Repairman;
import com.cognizant.repairs.model.Request;
import com.cognizant.repairs.service.RepairsService;

@Controller
public class AdminController {
	
	@Autowired
	RepairsService service;
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String showAdminPage(ModelMap model) {
		return "adminhome";
	}
	
	@RequestMapping(value="/admin-userrequests", method=RequestMethod.GET)
	public String showUserRequests(ModelMap model) {
		List<Request> userrequests;
		try {
			userrequests = service.getUserRequests();
		} catch (NoRequestException e) {
			return "adminnorequests";
		}
		model.put("userrequests", userrequests);
		return "adminuserrequests";
	}
	
	@RequestMapping(value="/admin-deleterequest", method=RequestMethod.GET)
	public String deleteRequest(@RequestParam String requestid) {
		service.deleteRequest(Integer.parseInt(requestid));
		return "redirect:/admin-userrequests";
	}
	
	@RequestMapping(value="/admin-repairmenlist", method=RequestMethod.GET)
	public String showRepairmenListPage(ModelMap model) {
		List<Repairman> allrepairmen = service.getRepairmenList();
		model.put("allrepairmen", allrepairmen);
		return "adminrepairmen";
	}
	
	@RequestMapping(value="/admin-editrepairman", method=RequestMethod.GET)
	public String showEditRepairmanPage(ModelMap model, @RequestParam String id) {
		Repairman repairman =  service.retrieveRepairman(Integer.parseInt(id));
		model.put("repairman", repairman);
		return "editrepairman";
	}
	
	@RequestMapping(value="/admin-editrepairman", method=RequestMethod.POST)
	public String editRepairman(Repairman repairman) {
		service.editRepairman(repairman);
		return "redirect:/admin-repairmenlist";
	}
	
	@RequestMapping(value="/admin-addrepairman", method=RequestMethod.GET)
	public String showAddRepairmanPage(ModelMap model) {
		Repairman repairman = new Repairman();
		model.put("repairman", repairman);
		return "addrepairman";
	}
	
	@RequestMapping(value="/admin-addrepairman", method=RequestMethod.POST)
	public String addRepairman(Repairman repairman) {
		service.addRepairman(repairman);
		return "redirect:/admin-repairmenlist";
	}
	
	@RequestMapping(value="/admin-deleterepairman", method=RequestMethod.GET)
	public String deleteRepairman(@RequestParam String id) {
		service.removeRepairman(Integer.parseInt(id));
		return "redirect:/admin-repairmenlist";
	}

}
