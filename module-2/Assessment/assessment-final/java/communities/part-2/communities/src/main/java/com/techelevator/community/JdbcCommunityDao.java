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
		String sqlInsertPost =
				"INSERT INTO communities(name, latitude, longitude, created, live) "
						+ "VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertPost, newCommunity.getName(), newCommunity.getLatitude(),
				newCommunity.getLongitude(), newCommunity.getCreated(),
				newCommunity.isLive());
	}

	@Override
	public List<Community> getAllCommunities() {
		List<Community> allCommunities = new ArrayList<>();
		String sqlGetAllCommunities =
				"SELECT id, name, latitude, longitude, created, live FROM communities";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCommunities);
		while (results.next()) {
			allCommunities.add(mapRowToCommunity(results));
		}

		return allCommunities;
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
