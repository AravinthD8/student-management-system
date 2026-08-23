package com.platformcommons.studentmanagementsystem.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platformcommons.studentmanagementsystem.dto.StudentLoginRequest;
import com.platformcommons.studentmanagementsystem.entity.Course;
import com.platformcommons.studentmanagementsystem.entity.Student;
import com.platformcommons.studentmanagementsystem.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
		return ResponseEntity.ok(studentService.createStudent(student));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student student = studentService.getStudent(id);
		if (student == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(student);

	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
		Student updatedStudent = studentService.updateStudent(id, student);
		return ResponseEntity.ok(updatedStudent);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/login")
	public ResponseEntity<?> studentLogin(@RequestBody StudentLoginRequest request) {
		Student student = studentService.validateStudent(request.getStudentCode(), request.getDateOfBirth());
		if (student == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid student code or date of birth");
		}
		return ResponseEntity.ok("Student validation successful");
	}

	@PostMapping("/{studentId}/courses/{courseId}")
	public ResponseEntity<Student> assignCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
		return ResponseEntity.ok(studentService.assignCourse(studentId, courseId));
	}

	@GetMapping("/search")
	public ResponseEntity<List<Student>> searchStudentsByName(@RequestParam String name) {
		return ResponseEntity.ok(studentService.searchStudentsByName(name));
	}

	@GetMapping("/search/course")
	public ResponseEntity<List<Student>> searchStudentsByCourse(@RequestParam String courseName) {
		return ResponseEntity.ok(studentService.searchStudentsByCourse(courseName));
	}

	@GetMapping("/{studentId}/courses/search")
	public ResponseEntity<Set<Course>> searchStudentCourses(@PathVariable Long studentId, @RequestParam String topic) {
		return ResponseEntity.ok(studentService.searchStudentCourses(studentId, topic));
	}

	@DeleteMapping("/{studentId}/courses/{courseId}")
	public ResponseEntity<Void> leaveCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
		studentService.leaveCourse(studentId, courseId);
		return ResponseEntity.noContent().build();
	}

}
