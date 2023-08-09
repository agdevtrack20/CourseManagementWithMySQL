package com.training.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.CourseDao;
import com.training.entities.Course;


@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseDao courseDao;
	
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@Override
	public Course getCourseById(int id) {
		return courseDao.findById(id).get();
	}

	@Override
	public String addCourse(Course course) {
		courseDao.save(course);
		return "added";
	}


	@Override
	public String updateCourse(int id,Course course) {
		List<Course> courses=courseDao.findAll();
		for(Course c: courses) {
			if(c.getId()==id) {
				courseDao.save(course);
				return "added";
			}
		}
		return "not added";
	}
	
	
	@Override
	public String deleteCourse(int id) {
		List<Course> courses=courseDao.findAll();
		Iterator<Course> itr= courses.iterator();
		while(itr.hasNext()) {
			Course tc = itr.next();
			if(tc.getId()==id) {
				courseDao.delete(tc);
				return "deleted";
				
			}
		}
		return "course not found ! not able to delete";
	}
	
}
