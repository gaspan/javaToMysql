package PernikApplication.example.test.service;

import PernikApplication.example.test.model.TestJava;
import PernikApplication.example.test.repositories.TestJavaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestJavaRepositories testJavaRepositories;
    public TestJava getTestJavaById(int id) {
        try {
            return testJavaRepositories.getTestJavaById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
