package com.dz.app.employee.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dz.app.employee.dao.EmployeeDao;
import com.dz.app.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	private JdbcTemplate template;
	
	@Override
	public int save(Employee employee) {
		
		String query="insert into employee(ename,email,age,salary)"
			 	  +" values (?,?,?,?)";
	
		int result =template.update(query,employee.getName(),employee.getEmail(),employee.getAge(),employee.getSalary());
		
		return result;
	}

		
	@Override
	public int update(Employee employee) {
		
		String query="update employee set ename=?,email=?,age=?,salary=? where eid=?";
		int result =template.update(query,employee.getName(),employee.getEmail(),employee.getAge(),employee.getSalary(),employee.getId());
		return result;
	}

	@Override
	public int delete(int eid) {
		String query="delete from employee where eid=?";
		int result =template.update(query,eid);
		return result;
	}

	@Override
	public Employee getById(int id) {
		String query="select * from employee where eid=?";
		/*RowMapper<Employee> rowMapper=new RowMapperImpl();
		Employee result =template.queryForObject(query,rowMapper,id);*/
		
		Employee result =template.queryForObject(query,new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee=new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setEmail(rs.getString(3));
				employee.setAge(rs.getInt(4));
				employee.setSalary(rs.getDouble(5));
				return employee;
			}
		},id);
		
		return result;
	}

	@Override
	public List<Employee> getAll() {
		
		String query="select * from employee";
		List<Employee> result =template.query(query,new RowMapperImpl());
		return result;
	}
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
