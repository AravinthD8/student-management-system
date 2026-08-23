package com.platformcommons.studentmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.platformcommons.studentmanagementsystem.entity.Course;
import com.platformcommons.studentmanagementsystem.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

// CREATE
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

// GET BY ID
	public Course getCourse(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

// GET ALL
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

// UPDATE
	public Course updateCourse(Long id, Course course) {

		Course existingCourse = courseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Course not found"));

		existingCourse.setCourseName(course.getCourseName());
		existingCourse.setDescription(course.getDescription());
		existingCourse.setCourseType(course.getCourseType());
		existingCourse.setDuration(course.getDuration());
		existingCourse.setTopics(course.getTopics());

		return courseRepository.save(existingCourse);
	}

// DELETE
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
}