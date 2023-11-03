package pro.sky.HomeWorkEmployeeStream.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWorkEmployeeStream.Interface.DepartmentInterface;
import pro.sky.HomeWorkEmployeeStream.Interface.EmployeeInterface;
import pro.sky.HomeWorkEmployeeStream.Model.Employee;
import pro.sky.HomeWorkEmployeeStream.ServiceImpl.DepartmentServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentServiceImpl service;


    public DepartmentController(DepartmentServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findAllDepartmentAll() {
        return service.findAllDepartmentAll();
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalaryInDepartment(@RequestParam int departmentId){
        return service.findEmployeeMaxSalaryInDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalaryInDepartment(@RequestParam int departmentId) {
        return service.findEmployeeMinSalaryInDepartment(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getAllByDepartment(@RequestParam("departmentId") int departmentId) {
        return service.getAllByDepartment(departmentId);
    }

}















