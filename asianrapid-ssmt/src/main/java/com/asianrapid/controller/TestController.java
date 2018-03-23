package com.asianrapid.controller;

import java.util.Date;

import com.asianrapid.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asianrapid.commons.AsianrapidResult;
import com.asianrapid.commons.BSTableParam;
import com.asianrapid.commons.BSTableResult;
import com.asianrapid.service.TestService;

@RequestMapping("/student")
@Controller
public class TestController {

	@Autowired
	private TestService testService;

//	@RequestMapping("/searchList")
//	@ResponseBody
//	public BSTableResult searchList(@RequestParam(value = "name", required = false, defaultValue = "") String name,
//									@RequestParam(value = "score", required = false, defaultValue = "") String score){
//		BSTableResult result = testService.searchStus(name, score);
//		return result;
//	}
	
	@RequestMapping("/list")
	@ResponseBody
	public BSTableResult listStudent(BSTableParam  param,
									 @RequestParam(value = "name", required = false) String name,
									 @RequestParam(value = "score", required = false) String score) {
		BSTableResult result = testService.listStudent(param, name, score);
		return result;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public AsianrapidResult listStudent(@RequestBody Student student) {
		System.out.println(student.getName());
		student.setIsDeleted(0);
		student.setCreated(new Date());
		student.setUpdated(new Date());
		AsianrapidResult result = testService.insertStudent(student);
		return result;
	}
	
	@RequestMapping("/load")
	@ResponseBody
	public AsianrapidResult listStudent(@RequestParam(value = "stuId") Integer id) {
		System.out.println(id);
		AsianrapidResult result = testService.loadStudent(id);
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public AsianrapidResult updateStudent(@RequestBody Student student) {
		student.setUpdated(new Date());
		AsianrapidResult result = testService.updateStudent(student);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public AsianrapidResult deleteStudent(@RequestParam(value = "stuId") Integer id) {
		AsianrapidResult result = testService.deleteStudent(id);
		return result;
	}
	
//	@RequestMapping("/print")
//	@ResponseBody
//	public AsianrapidResult deleteStudent(@RequestParam(value = "url") String url) {
//		AsianrapidResult result = testService.printStudentList(url);
//		return result;
//	}
}
