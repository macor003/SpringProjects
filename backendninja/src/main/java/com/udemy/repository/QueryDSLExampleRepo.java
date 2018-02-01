package com.udemy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

@Repository("queryDSLEcampleRepo")
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;

	@PersistenceContext
	private EntityManager em;

	public void find() {
		JPAQuery<Course> query = new JPAQuery<Course>(em);

		Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();

		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
	}

}
