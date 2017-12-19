package com.nice.employees;

import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

/**
 * @author Evgeny Borisov
 */
public class EmployeeService {
    @Autowired
    @Setter(PROTECTED)
    private EmployeeDao employeeDao;

    @Autowired
    @Setter(PROTECTED)
    private EmployeeWebService webService;



    public Employee findOldestOne() throws InterruptedException {
        List<Employee> all = employeeDao.findAll();
        all.sort(Comparator.comparing(Employee::getAge).reversed());
        return all.get(0);
    }

    public void fireMostExpensiveEmployee() throws InterruptedException {
        List<Employee> all = employeeDao.findAll();
        //todo find most expensive one
        webService.fireEmployee(all.get(0));



    }
}
