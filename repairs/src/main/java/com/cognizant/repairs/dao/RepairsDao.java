package com.cognizant.repairs.dao;

import java.util.List;
import java.util.Map;

import com.cognizant.repairs.exception.NoRequestException;
import com.cognizant.repairs.model.Repairman;
import com.cognizant.repairs.model.Request;

public interface RepairsDao {
	
	List<Repairman> getRepairmenList();
	List<Repairman> getTopTwentyRepairmen();
	List<Repairman> getResults(Map<String,String> params);
	List<Repairman> getRepairmanById(int id);
	List<Repairman> getRepairmenByOccupation(String occupationParam);
	void addRequest(Map<String,String> params);
	List<Request> getUserRequests() throws NoRequestException;
	void deleteRequest(int id);
	void addRepairman(Repairman repairman);
	void editRepairman(Repairman repairman);
	void removeRepairman(int id);

}
