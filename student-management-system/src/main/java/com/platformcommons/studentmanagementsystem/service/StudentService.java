package com.platformcommons.studentmanagementsystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.platformcommons.studentmanagementsystem.entity.Address;
import com.platformcommons.studentmanagementsystem.entity.Course;
import com.platformcommons.studentmanagementsystem.entity.Student;
import com.platformcommons.studentmanagementsystem.repository.CourseRepository;
import com.platformcommons.studentmanagementsystem.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;

	public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student getStudent(Long id) {
		return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student updateStudent(Long id, Student student) {

		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found"));

		existingStudent.setName(student.getName());
		existingStudent.setDateOfBirth(student.getDateOfBirth());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setMobileNumber(student.getMobileNumber());
		existingStudent.setParentNames(student.getParentNames());
		existingStudent.setGender(student.getGender());
		existingStudent.setStudentCode(student.getStudentCode());

		return studentRepository.save(existingStudent);
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	public Student validateStudent(String studentCode, LocalDate dateOfBirth) {
		return studentRepository.findByStudentCodeAndDateOfBirth(studentCode, dateOfBirth).orElse(null);
	}

	public Student assignCourse(Long studentId, Long courseId) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student not found"));
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
		student.getCourses().add(course);
		return studentRepository.save(student);
	}

	public List<Student> searchStudentsByName(String name) {
		return studentRepository.findByNameContainingIgnoreCase(name);
	}

	public List<Student> searchStudentsByCourse(String courseName) {
		return studentRepository.findByCoursesCourseNameContainingIgnoreCase(courseName);
	}

	public Set<Course> searchStudentCourses(Long studentId, String topic) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student not found"));
		return student.getCourses().stream()
				.filter(course -> course.getTopics().toLowerCase().contains(topic.toLowerCase()))
				.collect(Collectors.toSet());
	}

	public void leaveCourse(Long studentId, Long courseId) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student not found"));
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
		student.getCourses().remove(course);
		studentRepository.save(student);
	}
}
