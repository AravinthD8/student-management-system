package com.platformcommons.studentmanagementsystem.dto;

import java.time.LocalDate;

public class StudentLoginRequest {

	private String studentCode;
	private LocalDate dateOfBirth;

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}