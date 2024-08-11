package org.example.finalexamprep2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao {

    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void deleteById(int id);
}

