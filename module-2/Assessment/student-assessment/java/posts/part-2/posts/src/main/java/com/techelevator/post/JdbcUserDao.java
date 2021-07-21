package com.techelevator.post;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcUserDao implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcUserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(User newUser) {
		// Implement this method to save user to database
	}

	@Override
	public List<User> getAllUsers() {
		// Implement this method to pull in all users from database

		return null;
	}

	private User mapRowToUser(SqlRowSet results) {
		User userRow = new User();
		userRow.setId(results.getLong("id"));
		userRow.setFirstName(results.getString("first_name"));
		userRow.setLastName(results.getString("last_name"));
		userRow.setEmail(results.getString("email"));
		userRow.setRole(results.getString("role"));
		userRow.setCreated(results.getDate("created").toLocalDate());
		return userRow;
	}

}
