package com.enumcrm.service;

import com.enumcrm.dao.CustomerDAO;
import com.enumcrm.domain.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {

  private final CustomerDAO customerDAO;

  public CustomerService(CustomerDAO customerDAO) {
    this.customerDAO = customerDAO;
  }

  public void createCustomer(String firstName,
                             String lastName,
                             String email) throws SQLException {
    customerDAO.create(new Customer(firstName, lastName, email));
  }

  public List<Customer> getCustomers() throws SQLException {
    return customerDAO.getAll();
  }

  public Customer getByEmail(String email) throws SQLException {
    return customerDAO.getByEmail(email);
  }

public void createCustomerTable() throws SQLException {
	customerDAO.createTable();
	
}
}
