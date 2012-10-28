package com.xiaoluo.service.impl;

import java.util.List;

import com.xiaoluo.bean.PageBean;
import com.xiaoluo.bean.Person;
import com.xiaoluo.dao.PersonDAO;
import com.xiaoluo.dao.impl.PersonDAOImpl;
import com.xiaoluo.service.PersonService;

public class PersonServiceImpl implements PersonService
{
	private PersonDAO personDAO = new PersonDAOImpl();
	
	/**
	 * pageSize为每页显示的记录数
	 * page为当前显示的网页
	 */
	@Override
	public PageBean getPageBean(int pageSize, int page)
	{
		PageBean pageBean = new PageBean();
		
		String hql = "from Person";
		
		int allRows = personDAO.getAllRowCount(hql);
		
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		
		int currentPage = pageBean.getCurPage(page);
		
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		
		List<Person> list = personDAO.queryByPage(hql, offset, pageSize);
		
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		
		return pageBean;
	}
}
