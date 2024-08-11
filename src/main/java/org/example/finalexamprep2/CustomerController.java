package org.example.finalexamprep2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerDao.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer, Model model) {
        // Validate unique customer ID
        if (customerDao.findById(customer.getId()) != null) {
            model.addAttribute("errorMessage", "The record you are trying to add is already existing. Choose a different customer number");
            List<Customer> customers = customerDao.findAll();
            model.addAttribute("customers", customers);
            return "index";
        }
        customerDao.save(customer);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editCustomerForm(@RequestParam("id") int id, Model model) {
        Customer customer = customerDao.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer) {
        customerDao.deleteById(customer.getId());
        customerDao.save(customer);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id) {
        customerDao.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/projectedInvestment")
    public String projectedInvestmentForm(@RequestParam("id") int id, Model model) {
        Customer customer = customerDao.findById(id);
        if (customer != null) {
            List<InvestmentProjection> projections = calculateProjection(customer);
            model.addAttribute("projections", projections);
            model.addAttribute("customer", customer);
        }
        return "projectedInvestment";
    }

    private List<InvestmentProjection> calculateProjection(Customer customer) {
        List<InvestmentProjection> projections = new ArrayList<>();
        double rate = customer.getType().equals("Savings De-luxe") ? 0.15 : 0.10;
        double startingAmount = customer.getDeposit();

        for (int year = 1; year <= customer.getYear(); year++) {
            double interest = startingAmount * rate;
            double endingBalance = startingAmount + interest;
            projections.add(new InvestmentProjection(year, startingAmount, interest, endingBalance));
            startingAmount = endingBalance;
        }
        return projections;
    }
}