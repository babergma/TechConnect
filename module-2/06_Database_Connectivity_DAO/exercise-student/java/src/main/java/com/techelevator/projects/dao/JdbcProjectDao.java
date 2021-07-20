package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

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
	 *
	 * @param projectId the id of the project to get from the datastore
	 * @return a filled out project object
	 */
	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT * FROM project WHERE projectId = ?;";
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
		project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		project.setFromDate(rowSet.getDate("to_date").toLocalDate());
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> allProjects = new ArrayList<>();

		String sql = "SELECT * " +
				"FROM projects ";
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
////		String sql = "INSERT INTO project (name, from_date, to_date) " +
////				"VALUES (?, ?, ?) RETURNING project_id;";
////		Long newId = jdbcTemplate.queryForObject(sql, Long.class,
////				newProject.getParkName(), newProject.getDateEstablished(), newProject.getArea(), park.getHasCamping());
////
		return getProject(newProject);
	}

	/**
	 * Removes a project from the datastore, which requires deleting
	 * records from multiple tables.
	 *
	 * @param projectId the id of the project to remove
	 */
	@Override
	public void deleteProject(Long projectId) {
		String sql = "DELETE FROM park_state WHERE park_id = ?;";
		jdbcTemplate.update(sql, projectId);
//		sql = "DELETE FROM park WHERE park_id = ?";
//		jdbcTemplate.update(sql, parkId);
	}
	

}
