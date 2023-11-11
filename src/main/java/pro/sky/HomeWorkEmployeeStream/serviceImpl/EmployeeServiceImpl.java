package pro.sky.HomeWorkEmployeeStream.serviceImpl;

import org.springframework.stereotype.Service;
import pro.sky.HomeWorkEmployeeStream.exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWorkEmployeeStream.exception.EmployeeNotFoundException;
import pro.sky.HomeWorkEmployeeStream.exception.EmployeeStorageIsFullException;
import pro.sky.HomeWorkEmployeeStream.api.EmployeeInterface;
import pro.sky.HomeWorkEmployeeStream.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeInterface{

    public final int NUMBER_OF_EMPLOYEES = 15;
//    private Map<String, Employee> employeeMap;

    private Map<String, Employee> employeeMap = new HashMap<>();

    @Override
    public List<Employee> myList(Map<String, Employee> employeeMap) {
        final List<Employee> employee = new ArrayList<>();
        for (Employee employees : employeeMap.values()) {
            employee.add(employees);
        }
        return employee;
    }


    @Override
    public Map<String, Employee> getEmployeeMap(){
        return employeeMap;
    }
    @Override
    public List<Employee> getEmployeesList() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public Employee add(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        String name = firstName + lastName;

        if (getEmployeeMap().size() > NUMBER_OF_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников");
        }

        if (getEmployeeMap().containsKey(name)) {
            throw new EmployeeAlreadyAddedException("уже есть такой сотрудник");
        }

        getEmployeeMap().put(name, employee);
        return employee;

    }

    @Override
    public Employee remove(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        String name = firstName + lastName;
        if (getEmployeeMap().containsKey(name)) {
            return getEmployeeMap().remove(employee);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int department, double salary) {
        return Optional.ofNullable(getEmployeeMap().get(firstName + lastName)).orElseThrow(EmployeeNotFoundException::new);
    }

}
