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
		String sqlInsertUser =
				"INSERT INTO users(first_name, last_name, email, role, created) "
						+ "VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertUser, newUser.getFirstName(),
				newUser.getLastName(),
				newUser.getEmail(), newUser.getRole(), newUser.getCreated());
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<>();
		String sqlGetAllUsers =
				"SELECT id, first_name, last_name, email, role, created FROM users";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllUsers);
		while (results.next()) {
			allUsers.add(mapRowToUser(results));
		}

		return allUsers;
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
