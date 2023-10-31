package pro.sky.HomeWorkEmployeeStream.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.HomeWorkEmployeeStream.Exception.EmployeeNotFoundException;
import pro.sky.HomeWorkEmployeeStream.Exception.EmployeeStorageIsFullException;
import pro.sky.HomeWorkEmployeeStream.Exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWorkEmployeeStream.Interface.EmployeeInterface;
import pro.sky.HomeWorkEmployeeStream.Model.Employee;
import pro.sky.HomeWorkEmployeeStream.bootstrap.Runner;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {



    public final int NUMBER_OF_EMPLOYEES = 10;
    private Map<String, Employee> employeeMap;
    private List<Employee> employeeInterface;

//    public Map<integer, Employee> employeeMap = new HashMap<>(Map.of(
//            1,
//            new Employee(
//
//                    "vladimir",
//                    "Volkov",
//                    1,
//                    30_000),
//
//            2,
//            new Employee(
//                    "Igor",
//                    "Verbludev",
//                    2,
//                    50_000),
//
//            2,
//            new Employee(
//                    "luba",
//                    "Ivanova",
//                    2,
//                    25_000)
//
//
//    ));


    public EmployeeServiceImpl(Map<String, Employee> employeeMap, List<Employee> employeeInterface) {
        this.employeeMap = employeeMap;
        this.employeeInterface = employeeInterface;
    }

    public Map<String, Employee> getEmployeeMap(){
        return employeeMap;
    }


    public List<Employee> getEmployeesList() {
        return employeeInterface;
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

    @Override
    public Map<Integer, List<Employee>> findAll() {
        return null;
    }




}

