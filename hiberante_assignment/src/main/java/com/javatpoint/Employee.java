package com.javatpoint;
import javax.persistence.*;

@Entity
@Table(name="emp107")
public class Employee {  
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)	
private int employeeId;  
private String name,email;  
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="Address")
private Address address;
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}  
}  