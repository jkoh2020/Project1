package model;

import java.util.Date;

public class Reimbursement {
	private int reimbursementID;
	private int employeeID;
	private String name;
	private String title;
	private String description;
	private String amount;
	private String status = "pending";
	
	public Reimbursement() {
		
	}
	
	public Reimbursement(int reID, String status) {
		super();
		
		this.reimbursementID = reID;
		this.status = status;
	}
	
	public Reimbursement(String status) {
		super();
		this.status = status;
	}
	

	public Reimbursement (int id, int reimbursementID, String name, String title, String description, String amount, String status) {
		super();
		this.employeeID = id;
		this.reimbursementID = reimbursementID;
		this.name = name;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.status = status;
	}
	
	public Reimbursement (String name, String title, String description, String amount, String status, int id) {
		super();
		//this.employeeID = employeeID;
		this.name = name;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.employeeID = id;
	}
	
	public Reimbursement (int reID, String name, String title, String description, String amount, String status, int id) {
		super();
		this.reimbursementID = reID;
		this.name = name;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.employeeID = id;
	}
	
	public Reimbursement(String name, String title, String description, String amount) {
		this.name = name;
		this.title = title;
		this.description = description;
		this.amount = amount;
	}

	
	public int getReimbursementID() {
		return reimbursementID;
	}
	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
