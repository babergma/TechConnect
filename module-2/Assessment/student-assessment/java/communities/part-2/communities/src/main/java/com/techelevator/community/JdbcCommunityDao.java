package com.techelevator.community;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcCommunityDao implements CommunityDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcCommunityDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Community newCommunity) {
		// Implement this method to save communities to database
	}

	@Override
	public List<Community> getAllCommunities() {
		// Implement this method to pull in all communities from database

		return null;
	}

	private Community mapRowToCommunity(SqlRowSet results) {
		Community communityRow = new Community();
		communityRow.setId(results.getLong("id"));
		communityRow.setName(results.getString("name"));
		communityRow.setLatitude(results.getBigDecimal("latitude"));
		communityRow.setLongitude(results.getBigDecimal("longitude"));
		communityRow.setCreated(results.getDate("created").toLocalDate());
		communityRow.setLive(results.getBoolean("live"));
		return communityRow;
	}

}
