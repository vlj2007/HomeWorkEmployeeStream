package pro.sky.HomeWorkEmployeeStream.Interface;

import pro.sky.HomeWorkEmployeeStream.Model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentInterface {

    List<Employee> getAllByDepartment(int departmant);

    Map<Integer, List<Employee>> getAll();

    Map<Integer, List<Employee>> findAllDepartmentAll();



}
