package pro.sky.HomeWorkEmployeeStream.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.HomeWorkEmployeeStream.Interface.DepartmentInterface;
import pro.sky.HomeWorkEmployeeStream.Model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentInterface {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getAllByDepartment(int id) {
        List<Employee>  temp = employeeService.getEmployeesList().stream()
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());
        return temp;
    }

    @Override
    public Map<Integer, List<Employee>> getAll() {
        return employeeService.findAll();
    }

}
