package com.ncgroup2.eventmanager.dao.impl;

import com.ncgroup2.eventmanager.dao.CustomerDAO;
import com.ncgroup2.eventmanager.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Repository
public class CustomerDAOImpl extends JdbcDaoSupport implements CustomerDAO {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insertCustomer(Customer customer) {
        LocalDate localDate = LocalDate.now();

        String sql = "INSERT INTO Customer("+
                "id, name, second_name, phone, login, password, email, status, key, registration_date)"+
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        getJdbcTemplate().update(sql,
                new Object[]{
                customer.getId(), customer.getLogin(), customer.getPassword(),
                        "text","text","text","text","text","text", localDate
        });
    }

    @Override
    public Customer getCustomer(int id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return (Customer)getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Customer>(){
            @Override
            public Customer mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Customer cust = new Customer();
                cust.setId(rs.getInt("id"));
                cust.setLogin(rs.getString("login"));
                cust.setPassword(rs.getString("password"));
                return cust;
            }
        });
    }
}
