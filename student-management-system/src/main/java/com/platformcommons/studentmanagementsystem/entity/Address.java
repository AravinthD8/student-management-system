package com.platformcommons.studentmanagementsystem.entity;

import org.hibernate.annotations.Audited.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table( name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String addressType;
	@NotBlank(message = "Address line is required")
	private String addressLine;
	@NotBlank(message = "City is required")
	private String city;
	private String state;
	private String pincode;
	@ManyToOne
	@JoinColumn( name = "student_id")
	private Student student;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
