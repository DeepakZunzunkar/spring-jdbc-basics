package com.dz.app;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext context = new ClassPathXmlApplicationContext("com/dz/app/config.xml");
    	
    	 
    	 JdbcTemplate jdbcTemplate=context.getBean("jdbcTemplate",JdbcTemplate.class);
    	 //insert query
    	 String query="insert into adpEmployee(firstname,lastname,gender,birthDate,salary,status,active,createdby,createdon) "
    			 	  +" values (?,?,?,?,?,?,?,?,?)";
    	 
    	 //fire query
    	 int result=jdbcTemplate.update(query,"golu","rathod","M","1993-02-10",5000.0,"A","A","dz",new Date());
    	 System.out.println(result);
    	 
    }
}
