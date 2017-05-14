package test;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import netctoss.controller.dao.AdminDAO;
import netctoss.controller.entity.Admin;

public class TestCose {
   
@Test
  public void test1() throws SQLException{
	ApplicationContext ac = 
			new ClassPathXmlApplicationContext("springmvc.xml");
	
	DataSource ds = ac.getBean("ds",DataSource.class);
	System.out.println(ds.getConnection());
	
	
}

@Test
  public void test2(){
	ApplicationContext ac = 
			new ClassPathXmlApplicationContext("springmvc.xml");
	
	AdminDAO dao = ac.getBean("adminDAO",AdminDAO.class);
	Admin admin = dao.findByAdminCode("caocao");
	System.out.println(admin);
	
	
	
}


	
}
