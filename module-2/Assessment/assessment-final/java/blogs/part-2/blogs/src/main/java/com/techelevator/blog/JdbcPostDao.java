package com.techelevator.blog;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcPostDao implements PostDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcPostDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Post newPost) {
		String sqlInsertPost =
				"INSERT INTO posts(name, body, published, created) "
						+ "VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertPost, newPost.getName(),
				newPost.getBody(), newPost.isPublished(),newPost.getCreated());
	}

	@Override
	public List<Post> getAllPosts() {
		List<Post> allPosts = new ArrayList<>();
		String sqlGetAllPosts = "SELECT id, name, body, published, created FROM posts";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllPosts);
		while(results.next()) {
			allPosts.add(mapRowToPost(results));
		}

		return allPosts;
	}
	private Post mapRowToPost(SqlRowSet results) {
		Post postRow = new Post();
		postRow.setId(results.getLong("id"));
		postRow.setName(results.getString("name"));
		postRow.setBody(results.getString("body"));
		postRow.setPublished(results.getBoolean("published"));
		postRow.setCreated(results.getDate("created").toLocalDate());
		return postRow;
	}

}
