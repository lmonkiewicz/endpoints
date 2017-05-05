package com.lmonkiewicz.endpoints.server.endpoints.basic;


import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

/**
 * Created by lmonkiewicz on 05.05.2017.
 */
public class BasicBase   {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new BasicEndpoints());
    }
}
