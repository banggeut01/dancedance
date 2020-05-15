package com.dance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dance.dao.TestDaoImpl;
import com.dance.dto.Test;


@Service
public class TestServiceImpl implements ITestService {
	
	@Autowired
	private TestDaoImpl testdao;


	@Override
	@Transactional(readOnly=true)
	public Test test() {
		return testdao.test();
	}


}
