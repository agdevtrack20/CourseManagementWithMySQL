package com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.entities.Course;

public interface CourseDao extends JpaRepository<Course,Integer> {

}
