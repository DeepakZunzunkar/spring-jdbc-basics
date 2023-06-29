package com.dz.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dz.app.employee.dao.EmployeeDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext context = new ClassPathXmlApplicationContext("com/dz/app/config.xml");
    	 
    	 
    	 /* JdbcTemplate jdbcTemplate=context.getBean("jdbcTemplate",JdbcTemplate.class);
    	 //insert query
    	 String query="insert into adpEmployee(firstname,lastname,gender,birthDate,salary,status,active,createdby,createdon) "
    			 	  +" values (?,?,?,?,?,?,?,?,?)";
    	 
    	 //fire query
    	 int result=jdbcTemplate.update(query,"golu","rathod","M","1993-02-10",5000.0,"A","A","dz",new Date());
    	 System.out.println(result);*/
    	 
    	 EmployeeDao empDao = context.getBean("employeeDao",EmployeeDao.class);
    	 
    	 //add
    	 /*
    	  System.err.println("_________add________________"); 
    	  Employee employee=new Employee("jivan","jee@one.com",25,30000);
    	 int rslt=empDao.save(employee);
    	 System.out.println(rslt);*/
    	 
    	 //update 
    	 /*System.err.println("_________update________________");
    	 Employee employee=new Employee(12,"kaylash","kaylash@dz.com",31,80000);
    	 int rslt=empDao.update(employee);
    	 System.out.println(rslt);*/
    	 
    	 //delete
    	 /*System.err.println("_________delete________________");
    	 int rslt=empDao.delete(15);
    	 System.out.println(rslt);*/
    	 
    	 /*System.err.println("_________get single record ________________");
    	 Employee emp=empDao.getById(14);
    	 System.out.println(emp);*/
    	 
    	 System.err.println("_________get multiple record ________________");
    	 empDao.getAll().stream().forEach(emp->{
    		 System.out.println(emp);
    	 });
    	 
    	 
    }
}
