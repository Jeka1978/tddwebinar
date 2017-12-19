package com.nice.employees;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Evgeny Borisov
 */
public interface EmployeeDao {
    List<Employee> findAll() throws InterruptedException;

    Employee findOne();

    List<Employee> findFilteredI(Predicate predicate);


}
