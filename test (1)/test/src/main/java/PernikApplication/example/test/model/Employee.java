package PernikApplication.example.test.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "EMPLOYEE")
@EqualsAndHashCode(callSuper = false)
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonView
    private int id;

    @JsonView
    @Column(name = "name")
    private String name;

    @JsonView
    @Column(name = "address")
    private String address;

    @JsonView
    @Column(name = "departmnet")
    private String departmnet;

    @JsonView
    @Column(name = "join_date")
    private String join_date;

    @JsonView
    @Column(name = "status")
    private String status;

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getDepartmnet() {
        return departmnet;
    }
    public String getJoin_date() {
        return join_date;
    }
    public String getStatus() {
        return status;
    }
}
