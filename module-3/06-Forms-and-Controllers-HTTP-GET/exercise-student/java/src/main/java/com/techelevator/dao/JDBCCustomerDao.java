package com.techelevator.dao;

import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Customer;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * JDBCCustomerDao
 */
@Component
public class JDBCCustomerDao implements CustomerDao {

    private static final String SELECT_CUSTOMERS_SQL = "SELECT c.first_name, c.last_name, c.email, c.activebool FROM customer c";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCustomerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Customer> searchAndSortCustomers(String search, String sort){
        List<Customer> matchingCustomers = new ArrayList<>();
        String customerSearchSql = SELECT_CUSTOMERS_SQL + " WHERE c.last_name ILIKE ? order by c.last_name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(customerSearchSql, "%" + search + "%");
        while (results.next()) {
            matchingCustomers.add(mapRowToCustomer(results));
        }
        return matchingCustomers;
    }

    private Customer mapRowToCustomer(SqlRowSet results) {
        return new Customer(results.getString("first_name"), results.getString("last_name"), results.getString("email"), results.getBoolean("activebool"));
    }
}