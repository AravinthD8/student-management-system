package com.platformcommons.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platformcommons.studentmanagementsystem.entity.Course;

public interface CourseRepository extends JpaRepository<Course , Long> {

}
