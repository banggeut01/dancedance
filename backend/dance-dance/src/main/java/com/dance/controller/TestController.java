package com.dance.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dance.dto.Test;
import com.dance.service.ITestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/humans/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000, exposedHeaders = "Authorization", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Api(value = "Stretching", description = "Resouces Management 2020")
public class TestController {

	public static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private ITestService testservice;
	
	@ApiOperation(value = "테스트", response = Test.class)
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> test() throws Exception {
		logger.info("1-------------test-----------------------------" + new Date());
		HttpHeaders headers = new HttpHeaders();
		Map<String, Object> resultMap = new HashMap<>();
		
		Test test = testservice.test();
		
		if(test==null)
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		
		resultMap.put("id", test.getId());
		resultMap.put("name", test.getName());

		return new ResponseEntity<Map<String, Object>>(resultMap, headers, HttpStatus.OK);
	}
	
}
