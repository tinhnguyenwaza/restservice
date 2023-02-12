package com.demospringboot.model;

public class Employee {
	private int id;
	private String name;
	private String tille;
		
	public Employee() {
		super();
	}
	public Employee(int id, String name, String tille) {
		super();
		this.id = id;
		this.name = name;
		this.tille = tille;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTille() {
		return tille;
	}
	public void setTille(String tille) {
		this.tille = tille;
	}
	
	
}