package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	private static final Log logger = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Mario", 25));
		people.add(new Person("Oriana", 34));
		people.add(new Person("Magroberth", 38));
		people.add(new Person("Lees", 38));

		logger.info("HELLO FROM SERVICE");
		return people;
	}

}
