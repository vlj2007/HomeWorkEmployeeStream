package pro.sky.HomeWorkEmployeeStream.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.HomeWorkEmployeeStream.Interface.DepartmentInterface;
import pro.sky.HomeWorkEmployeeStream.Model.Employee;
import pro.sky.HomeWorkEmployeeStream.Exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;


@Service
public class DepartmentServiceImpl implements DepartmentInterface {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Map<Integer, List<Employee>> findAllDepartmentAll() {
        final Map<Integer, List<Employee>> employees = employeeService.myList(employeeService.getEmployeeMap())
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return employees;
    }

    @Override
    public Employee findEmployeeMaxSalaryInDepartment(int departmentId) {
        return employeeService.myList(employeeService.getEmployeeMap())
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeMinSalaryInDepartment(int departmentId) {
        return employeeService.myList(employeeService.getEmployeeMap())
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findAllDepartment(int departmentId) {
        List<Employee> departmentEmployees = employeeService.getEmployeesList()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());

        if (departmentEmployees.isEmpty()) {
            throw new EmployeeNotFoundException();
        } else
            return departmentEmployees;
    }

    @Override
    public List<Employee> getAllByDepartment(int departmentId) {
        List<Employee> temp = employeeService.getEmployeesList()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
        return temp;
    }
}
