package com.sanitas.StubRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StubRunnerApplication.class)
public class BaseClass {

    @Autowired
    VisitController visitController;

    @Before
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(visitController);
    }
}
