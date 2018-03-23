package com.asianrapid.service;

import com.asianrapid.po.Student;
import org.springframework.stereotype.Service;

import com.asianrapid.commons.AsianrapidResult;
import com.asianrapid.commons.BSTableParam;
import com.asianrapid.commons.BSTableResult;

@Service
public interface TestService {

	BSTableResult listStudent(BSTableParam param, String name, String score);
	AsianrapidResult insertStudent(Student student);
	AsianrapidResult loadStudent(Integer id);
	AsianrapidResult updateStudent(Student student);
	AsianrapidResult deleteStudent(Integer id);
	AsianrapidResult printStudentList(String url);

	BSTableResult searchStus(String name, String score);
}
