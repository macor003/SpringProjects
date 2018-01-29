package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {

	// Entity --> Model
	public CourseModel entityToModel(Course courseEntity) {
		CourseModel courseModel = new CourseModel();

		courseModel.setName(courseEntity.getName());
		courseModel.setDescription(courseEntity.getDescription());
		courseModel.setPrice(courseEntity.getPrice());
		courseModel.setHours(courseEntity.getHours());

		return courseModel;

	}

	// Model --> Entity
	public Course modelToEntity(CourseModel courseModel) {
		Course courseEntity = new Course();

		courseEntity.setName(courseModel.getName());
		courseEntity.setDescription(courseModel.getDescription());
		courseEntity.setPrice(courseModel.getPrice());
		courseEntity.setHours(courseModel.getHours());

		return courseEntity;

	}

}
