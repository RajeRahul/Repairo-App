package com.cognizant.repairs.model;

public class Repairman {

	private int id;
	private String first_name;
	private String last_name;
	private String occupation;
	private String location;
	private int base_price;
	private String skills;
	private float rating;

	public Repairman() {
		super();
	}

	public Repairman(int id, String first_name, String last_name, String occupation, String location, int base_price,
			String skills, float rating) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.occupation = occupation;
		this.location = location;
		this.base_price = base_price;
		this.skills = skills;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getBase_price() {
		return base_price;
	}

	public void setBase_price(int base_price) {
		this.base_price = base_price;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Repairman [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", occupation="
				+ occupation + ", location=" + location + ", base_price=" + base_price + ", skills=" + skills
				+ ", rating=" + rating + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + base_price;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + Float.floatToIntBits(rating);
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
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
		Repairman other = (Repairman) obj;
		if (base_price != other.base_price)
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id != other.id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		return true;
	}

}
