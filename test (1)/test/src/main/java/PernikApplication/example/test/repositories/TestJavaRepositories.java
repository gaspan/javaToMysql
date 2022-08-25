package PernikApplication.example.test.repositories;

import PernikApplication.example.test.model.TestJava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestJavaRepositories extends JpaRepository<TestJava, Integer> {

    @Query("select t from TestJava t where t.id=:id")
    TestJava getTestJavaById(@Param("id") int id);
}
