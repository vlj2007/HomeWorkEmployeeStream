package pro.sky.HomeWorkEmployeeStream.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWorkEmployeeStream.Interface.DepartmentInterface;
import pro.sky.HomeWorkEmployeeStream.Interface.EmployeeInterface;
import pro.sky.HomeWorkEmployeeStream.Model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentController service;

    public DepartmentController(DepartmentInterface service) {
        this.service = (DepartmentController) service;


    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findAllDepartmentAll() {
        return service.findAllDepartmentAll();
    }





}















