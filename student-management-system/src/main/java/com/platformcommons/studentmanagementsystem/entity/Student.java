package com.platformcommons.studentmanagementsystem.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;

@Entity
@Table( name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name is required")
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	private String gender;
	@NotBlank(message ="Stude code is required")
	@Column(unique = true , nullable = false)
	private String studentCode;
	@Email(message = "Invalid email format")
	private String email;
	private String mobileNumber;
	private String parentNames;
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Address> addresses = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name ="student_courses",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name ="course_id"))
	private Set<Course> courses = new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getParentNames() {
		return parentNames;
	}
	public void setParentNames(String parentNames) {
		this.parentNames = parentNames;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
	
	
	
	
	

}
