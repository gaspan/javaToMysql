package PernikApplication.example.test.controller;

import PernikApplication.example.test.model.TestJava;
import PernikApplication.example.test.service.TestService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TestController {

    @Autowired
    private TestService testService;
    @GetMapping("/gettestjava/{id}")
    public ResponseEntity<TestJava> getTestById(@PathVariable("id") int id) {
        final Logger LOGGER = (Logger) LoggerFactory.getLogger(TestController.class);
        try {
            TestJava returnTestJava = testService.getTestJavaById(id);
            LOGGER.error("id", id);
            LOGGER.error("data", returnTestJava);
            return ResponseEntity.status(HttpStatus.OK).body(returnTestJava);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
