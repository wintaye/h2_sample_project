package com.enumcrm;

import java.sql.SQLException;


import com.enumcrm.dao.CustomerDAO;
import com.enumcrm.service.CustomerService;

public class App {
  private static final String THEO = "Theo";
  private static final String LEDGER = "Ledger";
  private static final String THEO_LEDGER_EMAIL =
      "theo.ledger@business.com";
  private static final String JESSICA = "Jessica";
  private static final String CORINO = "Corino";
  private static final String JESSICA_CORINO_EMAIL =
      "jessica.corino@selusa.com";

  private static final CustomerService customerService =
      new CustomerService(new CustomerDAO());

  public static void main(String[] args) throws SQLException{
	customerService.createCustomerTable();
    customerService.createCustomer(THEO, LEDGER, THEO_LEDGER_EMAIL);
    customerService.createCustomer(JESSICA, CORINO, JESSICA_CORINO_EMAIL);
    printAllCustomers();
    printCustomerByEmail(JESSICA_CORINO_EMAIL);
    printCustomerByEmail(THEO_LEDGER_EMAIL);
  }

  private static void printAllCustomers() throws SQLException {
    System.out.println("Printing all customers...");
    customerService.getCustomers()
        .forEach(System.out::println);
  }

  private static void printCustomerByEmail(String email) throws SQLException {
    System.out.println("Printing customer by email...");
    System.out.println(customerService.getByEmail(email));
  }
}
