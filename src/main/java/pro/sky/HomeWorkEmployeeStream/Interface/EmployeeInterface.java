package pro.sky.HomeWorkEmployeeStream.Interface;

import pro.sky.HomeWorkEmployeeStream.Model.Employee;

import java.util.Collection;

public interface EmployeeInterface {

    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();


}
