package com.ecommerceservice.model.user;

public class RoleModel {
	private String role;
	private String operation;
	public RoleModel() {

	}
	public RoleModel(String role, String operation) {
		super();
		this.role = role;
		this.operation = operation;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

}
