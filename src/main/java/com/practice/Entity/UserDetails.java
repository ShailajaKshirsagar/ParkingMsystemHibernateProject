package com.practice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//Entity class added
@Entity
@Table(name = "resident_parking")
public class UserDetails {
	
	@Id
	private int id;
	
	private int flat_no;
	
	private String name;
	
	private String tenant_owner;
	
	private String vehicle_type;
	
	private long contact_no;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlat_no() {
		return flat_no;
	}

	public void setFlat_no(int flat_no) {
		this.flat_no = flat_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTenant_owner() { return tenant_owner; }

	public void setTenant_owner(String tenant_owner) { 
		this.tenant_owner = tenant_owner; 
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public long getContact_no() {
		return contact_no;
	}

	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", flat_no=" + flat_no + ", name=" + name + ", tenant_owner=" + tenant_owner
				+ ", vehicle_type=" + vehicle_type + ", contact_no=" + contact_no + "]";
	}
	
}
