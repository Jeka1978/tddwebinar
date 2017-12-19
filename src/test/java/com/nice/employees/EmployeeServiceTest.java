package com.nice.employees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class EmployeeServiceTest {
    EmployeeDao mockDao;
    @Before
    public void setUp() throws Exception {
       mockDao = Mockito.mock(EmployeeDao.class);
        List<Employee> employees = Arrays.asList(
                new Employee("Ithak", 110),
                new Employee("Moshe Rabeynu", 120),
                new Employee("Lanister", 38));

        Mockito.when(mockDao.findAll()).thenReturn(employees);
    }

    @Test
    public void findOldestOne() throws Exception {



        EmployeeService employeeService = new EmployeeService();
        employeeService.setEmployeeDao(mockDao);
        Employee oldestOne = employeeService.findOldestOne();
        Assert.assertEquals("Moshe Rabeynu",oldestOne.getName());
//        Mockito.verify(mockDao, Mockito.times(1)).findOne();
    }

    @Test
    public void mostExpensiveEmployeeWasFired() throws Exception {
        EmployeeWebService mock = Mockito.mock(EmployeeWebService.class);
        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
        Mockito.verify(mock).fireEmployee(captor.capture());
        Assert.assertEquals("Lanister",captor.capture().getName());
    }
}





