package com.nice.employees;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Evgeny Borisov
 */
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> findAll() throws InterruptedException {
        Thread.sleep(2000);
        return null;
    }

    @Override
    public Employee findOne() {
        return null;
    }

    @Override
    public List<Employee> findFilteredI(Predicate predicate) {
        return null;
    }
}
