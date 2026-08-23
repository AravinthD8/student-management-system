package com.platformcommons.studentmanagementsystem.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platformcommons.studentmanagementsystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student ,Long> {
	
	Optional<Student> findByStudentCodeAndDateOfBirth(String StudentCode, LocalDate dateOfBirth);
	List<Student> findByNameContainingIgnoreCase(String name);
	List<Student> findByCoursesCourseNameContainingIgnoreCase(String courseName);

}
