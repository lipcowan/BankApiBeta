package dev.lipco.daos;

import dev.lipco.entities.Customer;

import java.util.Set;

// where we place our crud operators
public interface CustomerDAO {
    // CREATE
    Customer createCustomer(Customer customer);

    // READ
    Set<Customer> getAllCustomers();
    Customer getCustomerById(int customerId);

    // UPDATE
    Customer updateCustomer(Customer customer);

    // DELETE
    boolean deleteCustomerById(int customerId);
}
