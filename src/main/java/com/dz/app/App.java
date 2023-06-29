package com.dz.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dz.app.employee.dao.EmployeeDao;
import com.dz.app.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 /*System.out.println("____________XML Base Config_______________________\n");
    	 ApplicationContext context = new ClassPathXmlApplicationContext("com/dz/app/config.xml");*/
    	 
    	 System.out.println("____________Annotation Base Config___________________\n");
   	 	 ApplicationContext context = new AnnotationConfigApplicationContext(JavaBaseConfig.class);
    	 
    	 /* JdbcTemplate jdbcTemplate=context.getBean("jdbcTemplate",JdbcTemplate.class);
    	 //insert query
    	 String query="insert into adpEmployee(firstname,lastname,gender,birthDate,salary,status,active,createdby,createdon) "
    			 	  +" values (?,?,?,?,?,?,?,?,?)";
    	 
    	 //fire query
    	 int result=jdbcTemplate.update(query,"golu","rathod","M","1993-02-10",5000.0,"A","A","dz",new Date());
    	 System.out.println(result);*/
    	 
    	 EmployeeDao empDao = context.getBean("employeeDao",EmployeeDao.class);
    	 
    	 /*System.err.println("_________add________________"); 
    	 Employee employee=new Employee("gagan","gaga@dz.com",22,0.0);
    	 int rslt=empDao.save(employee);
    	 System.out.println("Employee added.."+rslt);*/
    	 
    	 /*System.err.println("_________update________________");
    	 Employee employee=new Employee(16,"gagan","gagan@dz.com",23,10000);
    	 int rslt=empDao.update(employee);
    	 System.out.println("Employee updated.."+rslt);*/
    	 
    	 /*System.err.println("_________delete________________");
    	 int rslt=empDao.delete(13);
    	 System.out.println("Employee deleted.."+rslt);*/
    	 
    	 /*System.err.println("_________get single record ________________");
    	 Employee emp=empDao.getById(16);
    	 System.out.println(emp);*/
    	 
    	 System.err.println("_________get multiple record ________________");
    	 empDao.getAll().stream().forEach(emp->{
    		 System.out.println(emp);
    	 });
    	 
    	 
    }
}
