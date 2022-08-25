package PernikApplication.example.test.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "test_java")
@EqualsAndHashCode(callSuper = false)
@Builder
public class TestJava implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonView
    private int id;

    @JsonView
    @Column(name = "nama")
    private String nama;

    @JsonView
    @Column(name = "alamat")
    private String alamat;

    @Column(name = "nilai")
    private int nilai;
}
