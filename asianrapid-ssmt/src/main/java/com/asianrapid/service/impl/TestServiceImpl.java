package com.asianrapid.service.impl;

import com.asianrapid.commons.AsianrapidResult;
import com.asianrapid.commons.BSTableParam;
import com.asianrapid.commons.BSTableResult;
import com.asianrapid.commons.RuntimeException;
import com.asianrapid.dao.StudentMapper;
import com.asianrapid.po.Student;
import com.asianrapid.po.StudentExample;
import com.asianrapid.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private StudentMapper studentMapper;

//	@Autowired
//	private StudentCellStyle studentCellStyle;

	private static final Logger logger = Logger.getLogger(TestService.class);

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED
	,readOnly = true)
	public BSTableResult listStudent(BSTableParam param, String name, String score) {
		
		BSTableResult result = new BSTableResult();
		StudentExample example = new StudentExample();
		StudentExample.Criteria criteria = example.createCriteria();
//		if (param.getSearch() != null && !"".equals(param.getSearch())) {
//			criteria.andNameLike("%" + param.getSearch() + "%");
//		}
		if (name != null){
		    criteria.andNameLike("%" + name + "%");
        }
        if (score != null){
            criteria.andScoreEqualTo(score);
        }
		criteria.andIsDeletedEqualTo(0);
		PageHelper ph = new PageHelper();
		ph.startPage(param.getPage(), param.getRows());
		List<Student> list = studentMapper.selectByExample(example);
		PageInfo pi = new PageInfo<>(list);
		result.setRows(list);
		result.setTotal(pi.getTotal());

		logger.info("查询student表未删除的列");
		return result;
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public AsianrapidResult insertStudent(Student student) {
		try {
			studentMapper.insert(student);
			logger.debug("插入student记录， name=" + student.getName());
			return AsianrapidResult.ok();
		} catch (Exception e) {
			logger.error(e.getMessage());
//			throw new RuntimeException("异常", e);
			return AsianrapidResult.build(500, "服务器异常", null);
		}
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED
			,readOnly = true)
	public AsianrapidResult loadStudent(Integer id) {
		try {
			StudentExample example = new StudentExample();
			StudentExample.Criteria criteria = example.createCriteria();
			criteria.andStuIdEqualTo(id);
			criteria.andIsDeletedEqualTo(0);
			List<Student> list = studentMapper.selectByExample(example);
			logger.info("查询student，id=" + id);
			return AsianrapidResult.ok(list.get(0));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return AsianrapidResult.build(500, "服务器异常", null);
		}
		
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public AsianrapidResult updateStudent(Student student) {
		try {
			studentMapper.updateByPrimaryKeySelective(student);
			logger.debug("更新student表，用户名=" + student.getName());
			return AsianrapidResult.ok();
		} catch (Exception e) {
//			e.printStackTrace();
			logger.error(e.getMessage());
			return AsianrapidResult.build(500, "服务器异常", null);
		}
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public AsianrapidResult deleteStudent(Integer id) {
		try {
			Student student = new Student();
			student.setStuId(id);
			student.setIsDeleted(1);
			int key = studentMapper.updateByPrimaryKeySelective(student);
			
			if (key == 1) {
				logger.debug("删除student，id=" + id);
				return AsianrapidResult.ok();
			}
			
			logger.error("没有删除student， id=" + id);
			return AsianrapidResult.build(500, "删除记录有瑕疵", null);
		} catch (Exception e) {
//			e.printStackTrace();
			logger.error(e.getMessage());
			throw new RuntimeException("删除用户异常", e);
//			return AsianrapidResult.build(500, "服务器异常", null);
		}
	}

	@Override
	public AsianrapidResult printStudentList(String url) {
		try {
//			StudentExample example = new StudentExample();
//			StudentExample.Criteria criteria = example.createCriteria();
//			criteria.andIsDeletedEqualTo(0);
//			List<Student> list = studentMapper.selectByExample(example);
//			studentCellStyle.exportExcel(new FileOutputStream(url), list);
//			logger.info("导出student表为excel表格");
			return AsianrapidResult.ok();
		} catch (Exception e) {
//			e.printStackTrace();
			logger.error(e.getMessage());
			return AsianrapidResult.build(500, "服务器异常", null);
		}
	}

    @Override
    @Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED
            ,readOnly = true)
    public BSTableResult searchStus(String name, String score) {
        BSTableResult result = new BSTableResult();
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andScoreEqualTo(score);

        List<Student> students = studentMapper.selectByExample(example);

        result.setRows(students);
        result.setTotal(Long.valueOf(students.size()));

        logger.info("查询name=" + name +  ",score=" + score + "的student信息");

        return result;
    }


}
