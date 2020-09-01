package com.cognizant.repairs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cognizant.repairs.connection.ConnectionHandler;
import com.cognizant.repairs.dao.RepairsDao;
import com.cognizant.repairs.exception.NoRequestException;
import com.cognizant.repairs.model.Repairman;
import com.cognizant.repairs.model.Request;

@Component
public class RepairsService implements RepairsDao {
	
	public List<String> getOccupationList() {
		List<String> occupationlist = new ArrayList<>();
		occupationlist.addAll(Arrays.asList("Mechanic","Electrician","Carpenter","Plumber","Painter"));
		return occupationlist;
	}
	
	public List<String> getLocationList() {
		List<String> locationlist = new ArrayList<>();
		locationlist.addAll(Arrays.asList("Bavdhan","Kothrud","Warje","Camp","Aundh","Hinjawadi","Deccan",
				"Shivaji-Nagar","Koregaon-Park","Vadgaon","Ambegaon","Dhanukar","Hadapsar","Dhayari",
				"Sadashiv-Peth","Narayan-Peth"));
		return locationlist;
	}
	
	public List<Repairman> getRepairmenResultSetList(PreparedStatement pr) {
		List<Repairman> resultsetlist = new ArrayList<>();
		try {
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String occupation = rs.getString("occupation");
				String location = rs.getString("location");
				int base_price = rs.getInt("base_price");
				String skills = rs.getString("skills");
				Float rating = rs.getFloat("rating");
				Repairman repairman = new Repairman(id, first_name, last_name, occupation, location, base_price, skills, rating);
				resultsetlist.add(repairman);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultsetlist;
	}
	
	public List<Request> getRequestResultSetList(PreparedStatement pr) {
		List<Request> requestsetlist = new ArrayList<>();
		try {
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				int requestId = rs.getInt("requestId");
				int repairmanId = rs.getInt("repairmanId");
				String user_first_name = rs.getString("user_first_name");
				String user_last_name = rs.getString("user_last_name");
				String user_email = rs.getString("user_email");
				String user_phone = rs.getString("user_phone");
				String user_address = rs.getString("user_address");
				String user_problem = rs.getString("user_problem");
				Request userrequests = new Request(requestId, repairmanId, user_first_name, user_last_name, user_email, user_phone, user_address, user_problem);
				requestsetlist.add(userrequests);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return requestsetlist;
	}
	
	public Repairman retrieveRepairman(int repairmanId) {
		Connection con = null;
		PreparedStatement pr = null;
		int id = 0;
		String first_name = "";
		String last_name = "";
		String occupation = "";
		String location = "";
		int base_price = 0;
		String skills = "";
		Float rating = (float) 0;
		String query = "select * from repairemen where id = ?;";
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			pr.setInt(1, repairmanId);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
				first_name = rs.getString("first_name");
				last_name = rs.getString("last_name");
				occupation = rs.getString("occupation");
				location = rs.getString("location");
				base_price = rs.getInt("base_price");
				skills = rs.getString("skills");
				rating = rs.getFloat("rating");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Repairman repairman = new Repairman(id, first_name, last_name, occupation, location, base_price, skills, rating);
		return repairman;
		
	}

	@Override
	public List<Repairman> getRepairmenList() {
		Connection con = null;
		PreparedStatement pr = null;
		List<Repairman> repair_list = new ArrayList<>();
		String query = "select * from repairemen;";
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			repair_list = getRepairmenResultSetList(pr);
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return repair_list;
	}

	@Override
	public List<Repairman> getTopTwentyRepairmen() {
		Connection con = null;
		PreparedStatement pr = null;
		List<Repairman> repair_list = new ArrayList<>();
		String query = "select * from repairemen order by rating desc limit 20;";
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			repair_list = getRepairmenResultSetList(pr);
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return repair_list;
	}

	@Override
	public List<Repairman> getResults(Map<String,String> params) {
		Connection con = null;
		PreparedStatement pr = null;
		List<Repairman> repair_list = new ArrayList<>();
		StringBuilder builder1 = new StringBuilder();
		StringBuilder builder2 = new StringBuilder();
		List<String> paramlist = new ArrayList<>();
		List<String> occupationparams = new ArrayList<>();
		List<String> locationparams = new ArrayList<>();
		List<String> occupationlist = getOccupationList();
		List<String> locationlist = getLocationList();
		
		for (String keys : params.keySet()) {
		   paramlist.add(keys);
		}
		
		for (String i : paramlist) {
			for (String j : occupationlist) {
				if(i.equalsIgnoreCase(j)) {
					occupationparams.add(i);
				}
			}
		}
		
		for (String i : paramlist) {
			for (String j : locationlist) {
				if(i.equalsIgnoreCase(j)) {
					locationparams.add(i);
				}
			}
		}
		
		for( int i = 0 ; i < occupationparams.size(); i++ ) {
            builder1.append("?,");
        }
        for( int i = 0 ; i < locationparams.size(); i++ ) {
            builder2.append(locationparams.get(i)+"|");
        }
        
        String query = "select * from repairemen where occupation in (" 
                + builder1.deleteCharAt( builder1.length() -1 ).toString() + ") and location regexp ? ;";
		
        occupationparams.add(builder2.deleteCharAt( builder2.length() -1 ).toString());
        
        try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			int index = 1;
			for(String i : occupationparams) {
				pr.setString(index++, i);
			}
			repair_list = getRepairmenResultSetList(pr);
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        
		return repair_list;
	}

	@Override
	public List<Repairman> getRepairmanById(int Repairmanid) {
		Connection con = null;
		PreparedStatement pr = null;
		List<Repairman> repair_list = new ArrayList<>();
		String query = "select * from repairemen where id = ?;";
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			pr.setInt(1, Repairmanid);
			repair_list = getRepairmenResultSetList(pr);
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return repair_list;
	}

	@Override
	public List<Repairman> getRepairmenByOccupation(String occupationParam) {
		Connection con = null;
		PreparedStatement pr = null;
		List<Repairman> repair_list = new ArrayList<>();
		String query = "select * from repairemen where occupation = ?;";
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1,occupationParam);
			repair_list = getRepairmenResultSetList(pr);
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return repair_list;
	}

	@Override
	public void addRequest(Map<String, String> params) {
		Connection con  = null;
		PreparedStatement pr = null;
		List<String> requestparams = new ArrayList<>();
		
		String query = "insert into servicerequests(user_first_name, user_last_name, user_email, user_phone, user_address, user_problem, repairmanId) values (?,?,?,?,?,?,?);";
		
		for (Map.Entry<String, String> entry : params.entrySet()) {
			requestparams.add(entry.getValue());
		}
		
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			
			int index = 1;
			for(int i = 0; i < 6; i++) {
				pr.setString(index++, requestparams.get(i));
			}
			pr.setInt(7, Integer.parseInt(requestparams.get(6)));
			
			int rowsAffected = pr.executeUpdate();
			System.out.println(rowsAffected +"records inserted");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Request> getUserRequests() throws NoRequestException {
		Connection con = null;
		PreparedStatement pr = null;
		List<Request> userRequests = new ArrayList<>();
		String query = "select * from servicerequests;";
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			userRequests = getRequestResultSetList(pr);
			con.close();
			
			if(userRequests.isEmpty() || userRequests.size() == 0) {
				throw new NoRequestException("No user requests");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return userRequests;
	}

	@Override
	public void deleteRequest(int id) {
		Connection con = null;
		PreparedStatement pr = null;
		String query = "delete from servicerequests where requestId = ?";
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			pr.setInt(1, id);
			pr.execute();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editRepairman(Repairman repairman) {
		Connection con = null;
		PreparedStatement pr = null;
		String query = "update repairemen set first_name=?, last_name=?, occupation=?, location=?, base_price=?, skills=?, rating=? where id=?;";
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1, repairman.getFirst_name());
			pr.setString(2, repairman.getLast_name());
			pr.setString(3, repairman.getOccupation());
			pr.setString(4, repairman.getLocation());
			pr.setInt(5, repairman.getBase_price());
			pr.setString(6, repairman.getSkills());
			pr.setFloat(7, repairman.getRating());
			pr.setInt(8, repairman.getId());
			int rowsAffected = pr.executeUpdate();
			System.out.println(rowsAffected+"records edited");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeRepairman(int id) {
		Connection con = null;
		PreparedStatement pr = null;
		String query = "delete from repairemen where id = ?";
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			pr.setInt(1, id);
			pr.execute();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addRepairman(Repairman repairman) {
		Connection con = null;
		PreparedStatement pr = null;
		String query = "insert into repairemen(first_name, last_name, occupation, location, base_price, skills, rating) values (?,?,?,?,?,?,?);";
		try {
			con = ConnectionHandler.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1, repairman.getFirst_name());
			pr.setString(2, repairman.getLast_name());
			pr.setString(3, repairman.getOccupation());
			pr.setString(4, repairman.getLocation());
			pr.setInt(5, repairman.getBase_price());
			pr.setString(6, repairman.getSkills());
			pr.setFloat(7, repairman.getRating());
			int rowsAffected = pr.executeUpdate();
			System.out.println(rowsAffected+" records inserted.");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
