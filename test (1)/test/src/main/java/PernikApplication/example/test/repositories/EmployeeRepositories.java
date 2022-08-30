package PernikApplication.example.test.repositories;

import PernikApplication.example.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepositories extends JpaRepository<Employee, Integer>, CrudRepository<Employee, Integer> {

    @Query("select e from Employee e")
    List<Employee> getEmployees();

    @Query("select e from Employee e where e.id=:id or e.name=:name")
    Employee getEmployeeByIdOrName(@Param("id") int id, @Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE EMPLOYEE SET status=:status WHERE id=:id", nativeQuery = true)
    Integer updateStatusEmployee(@Param("id") int id, @Param("status") String status);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EMPLOYEE (name, address, departmnet, join_date, status) VALUES (:name, :address, :department, :join_date, :status)", nativeQuery = true)
    Integer saveEmployee(@Param("name") String name, @Param("address") String address,
                          @Param("department") String department, @Param("join_date") String join_date,
                          @Param("status") String status);


}
