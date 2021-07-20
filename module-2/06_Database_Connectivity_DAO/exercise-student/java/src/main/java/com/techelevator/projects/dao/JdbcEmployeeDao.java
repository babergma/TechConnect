package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Gets all employees from the datastore and returns them in a List
	 *
	 * @return all the employees as Employee objects in a List
	 */
	@Override
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlGetAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date"
				+ " FROM employee";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
		while (result.next()){
			Employee employee = mapRowToEmployee(result);
			employees.add(employee);
		}
		return employees;
	}
	private Employee mapRowToEmployee(SqlRowSet result) {
		Employee employee = new Employee();
		employee.setId(result.getLong("employee_id"));
		employee.setDepartmentId(result.getLong("department_id"));
		employee.setFirstName(result.getString("first_name"));
		employee.setLastName(result.getString("last_name"));
		employee.setBirthDate(result.getDate("birth_date").toLocalDate());
		employee.setHireDate(result.getDate("hire_date").toLocalDate());


		return employee;
	}
	/**
	 * Find all employees whose names contain the search strings. Returned employees should
	 * match both first and last name search strings. If a search string is blank,
	 * ignore it. If both strings are blank, return all employees.
	 * Be sure to use ILIKE for case-insensitive search matching!
	 *
	 * @param firstNameSearch the string to search for in the first_name, ignore if blank
	 * @param lastNameSearch the string to search for in the last_name, ignore if blank
	 * @return all employees whose name matches as Employee objects in a List
	 */
	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String sqlFindEmployeeByName = "";
		lastNameSearch = "%" + lastNameSearch + "%";
		firstNameSearch = "%" + firstNameSearch + "%";
		SqlRowSet results;

		sqlFindEmployeeByName = "SELECT * FROM employee Where first_name ILIKE ? AND last_name ILIKE ?";
		results = jdbcTemplate.queryForRowSet(sqlFindEmployeeByName, firstNameSearch, lastNameSearch);
		while (results.next()) {
			Employee theEmp = mapRowToEmployee(results);
			employees.add(theEmp);
		}
		return employees;
	}

	/**
	 * Get all of the employees that are on the project with the given id.
	 *
	 * @param projectId the project id to get the employees from
	 * @return all the employees assigned to that project as Employee objects in a List
	 */
	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT * FROM employee e JOIN project_employee pe ON e.employee_id = pe.employee_id WHERE pe.project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while (results.next()) {
			Employee theEmp = mapRowToEmployee(results);
			employees.add(theEmp);
		}
		return employees;
	}

	/**
	 * Assign an employee to a project
	 *
	 * @param projectId the project to put the employee on
	 * @param employeeId the employee to assign
	 */
	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlAddEmpToProj = "INSERT INTO project_employee(project_id, employee_id) VALUES(?, ?)";
		jdbcTemplate.update(sqlAddEmpToProj, projectId, employeeId);
	}

	/**
	 * Unassign the employee from a project.
	 *
	 * @param projectId the project to remove the employee from
	 * @param employeeId the employee to remove
	 */
	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlRemoveEmpFromProj = "DELETE FROM project_employee WHERE employee_id = ? AND project_id = ?";
		jdbcTemplate.update(sqlRemoveEmpFromProj, employeeId, projectId);
	}

	/**
	 * Get all of the employees that aren't assigned to any project.
	 *
	 * @return all the employees not on a project as Employee objects in a List
	 */
	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String sqlGetEmployeesWOPRoj = "SELECT DISTINCT employee.* FROM employee LEFT OUTER JOIN project_employee ON employee.employee_id = project_employee.employee_id LEFT OUTER JOIN project "
				+ " ON project_employee.project_id = project.project_id "
				+ " WHERE project.project_id IS NULL ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesWOPRoj);
		while (results.next()) {
			Employee theEmp = mapRowToEmployee(results);
			employees.add(theEmp);
		}
		return employees;
	}


}
