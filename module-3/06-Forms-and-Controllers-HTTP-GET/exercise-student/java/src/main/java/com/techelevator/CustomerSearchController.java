package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.model.Customer;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/customer")
    public String showCustomerSearchForm() {
        return "customerList";
    }

    @RequestMapping("/customer/search")
    public String showOrderedCustomerSearch(HttpServletRequest request) {
        String name = request.getParameter("name");
        String sortBy = request.getParameter("sortBy");
        List<Customer> results = customerDao.searchAndSortCustomers(name, sortBy);
        request.setAttribute("customers", results);

        return "customerList";
    }

}