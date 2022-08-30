package PernikApplication.example.test.service;

import PernikApplication.example.test.model.Employee;
import PernikApplication.example.test.repositories.EmployeeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepositories employeeRepositories;

    public List<Employee> getEmployee() {
        try {
            return employeeRepositories.getEmployees();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public Employee getEmployeeByIdOrName(int id, String name) {
        try {
            return employeeRepositories.getEmployeeByIdOrName(id, name);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public int updateStatusEmployee(int id, String status) {
        try {
            return employeeRepositories.updateStatusEmployee(id, status);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public int saveEmployee(Employee employee) {
        return employeeRepositories.saveEmployee(employee.getName(), employee.getAddress(),
                employee.getDepartmnet(), employee.getJoin_date(), employee.getStatus());
    }
}
