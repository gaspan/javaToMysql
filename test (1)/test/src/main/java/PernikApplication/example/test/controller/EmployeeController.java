package PernikApplication.example.test.controller;

import PernikApplication.example.test.model.Employee;
import PernikApplication.example.test.model.TestJava;
import PernikApplication.example.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll() {
        try {
            List<Employee> returnEmployees = employeeService.getEmployee();
            return ResponseEntity.status(HttpStatus.OK).body(returnEmployees);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @PostMapping("/save")
    public String save(@RequestBody Employee employee) {
        try {
            int status = employeeService.saveEmployee(employee);
            if (status == 1) {
                return "Success";
            } else {
                return "gagal";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @PutMapping("/update-status/{id}")
    public String updateStatusEmployee(@PathVariable("id") int id,
                                         @Param("status") String status) {
        try {
            int isSuccess =  employeeService.updateStatusEmployee(id, status);
            if (isSuccess == 1) {
                return "Success update status employee";
            } else {
                return "Failed";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @GetMapping("/detail-employee")
    public Employee getDetailEmployee(@Param("id") int id, @Param("nama") String nama) {
        try {
            return employeeService.getEmployeeByIdOrName(id, nama);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
