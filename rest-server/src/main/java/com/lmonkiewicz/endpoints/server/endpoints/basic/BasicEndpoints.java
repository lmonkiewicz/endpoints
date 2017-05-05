package com.lmonkiewicz.endpoints.server.endpoints.basic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by lmonkiewicz on 05.05.2017.
 */
@RestController
@RequestMapping("/basic")
class BasicEndpoints {

    @GetMapping("/randomNumber")
    Double random(){
        return Math.random();
    }

    @GetMapping("/timestamp")
    Long timestamp() {
        return System.currentTimeMillis();
    }

    @GetMapping("/uuid")
    String uuid() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("/hello")
    String hello(@RequestHeader(name="Name") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/error/{code}")
    ResponseEntity<Void> alwaysError(@PathVariable Integer code){
        return ResponseEntity.status(code).build();
    }



}
