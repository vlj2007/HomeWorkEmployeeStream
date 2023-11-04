package pro.sky.HomeWorkEmployeeStream.Interface;

import pro.sky.HomeWorkEmployeeStream.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentInterface {

    List<Employee> getAllByDepartment(int departmentId);

    Map<Integer, List<Employee>> findAllDepartmentAll();

    Employee findEmployeeMaxSalaryInDepartment(int departmentId);

    Employee findEmployeeMinSalaryInDepartment(int departmentId);

    List<Employee> findAllDepartment(int departmentId);


}
