package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Get a project from the datastore that has the given id.
	 * If the id is not found, return null.
	 * @return a filled out project object
	 */
	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date " +
				"FROM project " +
				"WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		if (results.next()) {
			project = mapRowToProject(results);
		}
		return project;
	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		project.setId(rowSet.getLong("project_id"));
		project.setName(rowSet.getString("name"));
		if (rowSet.getDate("from_date") != null) {
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		}
		if (rowSet.getDate("to_date") != null) {
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> allProjects = new ArrayList<>();

		String sql = "SELECT * " +
				"FROM project ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			//add object to a list
			allProjects.add(mapRowToProject(results));
		}
		return allProjects;
	}

	/**
	 * Inserts a new project into the datastore.
	 *
	 * @param newProject the project object to insert
	 * @return the project object with its new id filled in
	 */
	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date) " +
				"VALUES (?, ?, ?) RETURNING project_id;";
		Long newId = jdbcTemplate.queryForObject(sql, Long.class,
				newProject.getName(), newProject.getFromDate(), newProject.getToDate());

		return getProject(newId);
	}

	/**
	 * Removes a project from the datastore, which requires deleting
	 * records from multiple tables.
	 */
	@Override
	public void deleteProject(Long project_id) {
		String sql = "DELETE FROM project_employee WHERE project_id = ?;";
		jdbcTemplate.update(sql, project_id);
		sql = "DELETE FROM project WHERE project_id = ?";
		jdbcTemplate.update(sql, project_id);
	}
	

}
