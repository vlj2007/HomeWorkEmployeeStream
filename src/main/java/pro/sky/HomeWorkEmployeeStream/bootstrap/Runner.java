package pro.sky.HomeWorkEmployeeStream.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.sky.HomeWorkEmployeeStream.Interface.EmployeeInterface;
import pro.sky.HomeWorkEmployeeStream.serviceImpl.EmployeeServiceImpl;

@Component
public class Runner implements CommandLineRunner {

    public Runner(EmployeeInterface service) {
    }

    @Autowired
    private EmployeeInterface employeeList;

    @Override
    public void run(String... args) throws Exception {
        employeeList.add("vladimir", "Volkov", 1, 40_000);
        employeeList.add("Igor", "Verbludev", 2, 20_010);
        employeeList.add("luba", "Ivanova", 2, 62_000);
        employeeList.add("Pavel", "Krishtop", 3, 120_000);
        employeeList.add("Jo", "lisun", 3, 13_720);
        employeeList.add("Robert", "Alenchev", 3, 23_420);
        employeeList.add("Max", "Luter", 4, 60_013);
        employeeList.add("Anna", "Li", 4, 80_000);
        employeeList.add("Antony", "Amolett", 4, 203_970);
    }

}
