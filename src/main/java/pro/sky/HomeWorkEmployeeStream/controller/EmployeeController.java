package pro.sky.HomeWorkEmployeeStream.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWorkEmployeeStream.Interface.EmployeeInterface;
import pro.sky.HomeWorkEmployeeStream.model.Employee;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeInterface service;

    public EmployeeController(EmployeeInterface service) {
        this.service = service;

    }

    @GetMapping(path = "/add")
    public Employee employeeAdd(@RequestParam(required = true) String firstName,
                                @RequestParam(required = true) String lastName,
                                @RequestParam(required = true) int department,
                                @RequestParam(required = true) double salary) {
        return service.add(firstName, lastName,  department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee employeeRemove(@RequestParam(required = true) String firstName,
                                   @RequestParam(required = true) String lastName,
                                   @RequestParam(required = true) int department,
                                   @RequestParam(required = true) double salary) {
        return service.remove(firstName, lastName,  department, salary);
    }

    @GetMapping(path = "/find")
    public Employee employeeFind(@RequestParam(required = true) String firstName,
                                 @RequestParam(required = true) String lastName,
                                 @RequestParam(required = true) int department,
                                 @RequestParam(required = true) double salary) {
        return service.find(firstName, lastName, department, salary);
    }

    @GetMapping
    public List<Employee> findAll() {
        return Collections.unmodifiableList((List<Employee>) service.getEmployeesList());
    }
}
