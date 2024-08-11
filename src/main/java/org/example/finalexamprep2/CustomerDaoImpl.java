package org.example.finalexamprep2;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> result = customers.stream().filter(c -> c.getId() == id).findFirst();
        return result.orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void deleteById(int id) {
        customers.removeIf(c -> c.getId() == id);
    }
}

