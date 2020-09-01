package com.cognizant.repairs.model;

public class Request {
	private int requestId;
	private int repairmanId;
	private String user_first_name;
	private String user_last_name;
	private String user_email;
	private String user_phone;
	private String user_address;
	private String user_problem;

	public Request() {
		super();
	}

	public Request(int requestId, int repairmanId, String user_first_name, String user_last_name, String user_email,
			String user_phone, String user_address, String user_problem) {
		super();
		this.requestId = requestId;
		this.repairmanId = repairmanId;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_address = user_address;
		this.user_problem = user_problem;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getRepairmanId() {
		return repairmanId;
	}

	public void setRepairmanId(int repairmanId) {
		this.repairmanId = repairmanId;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_problem() {
		return user_problem;
	}

	public void setUser_problem(String user_problem) {
		this.user_problem = user_problem;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", repairmanId=" + repairmanId + ", user_first_name="
				+ user_first_name + ", user_last_name=" + user_last_name + ", user_email=" + user_email
				+ ", user_phone=" + user_phone + ", user_address=" + user_address + ", user_problem=" + user_problem
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + repairmanId;
		result = prime * result + requestId;
		result = prime * result + ((user_address == null) ? 0 : user_address.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_first_name == null) ? 0 : user_first_name.hashCode());
		result = prime * result + ((user_last_name == null) ? 0 : user_last_name.hashCode());
		result = prime * result + ((user_phone == null) ? 0 : user_phone.hashCode());
		result = prime * result + ((user_problem == null) ? 0 : user_problem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (repairmanId != other.repairmanId)
			return false;
		if (requestId != other.requestId)
			return false;
		if (user_address == null) {
			if (other.user_address != null)
				return false;
		} else if (!user_address.equals(other.user_address))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_first_name == null) {
			if (other.user_first_name != null)
				return false;
		} else if (!user_first_name.equals(other.user_first_name))
			return false;
		if (user_last_name == null) {
			if (other.user_last_name != null)
				return false;
		} else if (!user_last_name.equals(other.user_last_name))
			return false;
		if (user_phone == null) {
			if (other.user_phone != null)
				return false;
		} else if (!user_phone.equals(other.user_phone))
			return false;
		if (user_problem == null) {
			if (other.user_problem != null)
				return false;
		} else if (!user_problem.equals(other.user_problem))
			return false;
		return true;
	}

}
