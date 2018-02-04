package com.udemy.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.service.ExerciseService;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	private static final Log logger = LogFactory.getLog(ExerciseServiceImpl.class);

	@Override
	public String getMessage() {
		logger.info(" ** Exercise Service **");
		return null;
	}

}
