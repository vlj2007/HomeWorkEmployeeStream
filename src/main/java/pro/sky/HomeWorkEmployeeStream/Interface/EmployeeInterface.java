package pro.sky.HomeWorkEmployeeStream.Interface;

import pro.sky.HomeWorkEmployeeStream.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeInterface {

    Employee add(String firstName, String lastName, int department, double salary);

    Employee remove(String firstName, String lastName, int department, double salary);

    Employee find(String firstName, String lastName, int department, double salary);

//    Map<Integer, List<Employee>> findAll();

    List<Employee> getEmployeesList();

    Map<String, Employee> getEmployeeMap();

    List<Employee> myList(Map<String, Employee> employeeMap);

}
