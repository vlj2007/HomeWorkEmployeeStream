package pro.sky.HomeWorkEmployeeStream.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.sky.HomeWorkEmployeeStream.Interface.EmployeeInterface;
import pro.sky.HomeWorkEmployeeStream.Model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Runner implements CommandLineRunner {
    private final EmployeeInterface service;

    public Runner(EmployeeInterface service) {
        this.service = service;
    }

    @Autowired
    private EmployeeInterface employeeInterface;

    @Override
    public void run(String... args) throws Exception {

        employeeInterface.add("vladimir", "Volkov", 1, 20);
        employeeInterface.add("Igor", "Verbludev", 2, 20);
        employeeInterface.add("luba", "Ivanova", 2, 20);
        employeeInterface.add("Pavel", "Krishtop", 3, 20);
        employeeInterface.add("Jo", "lisun", 3, 20);
        employeeInterface.add("Robert", "Alenchev", 3, 20);
        employeeInterface.add("Joke", "Smith", 4, 20);
    }





}
