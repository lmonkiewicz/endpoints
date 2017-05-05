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
    ResponseValue random(){
        return new ResponseValue(Math.random());
    }

    @GetMapping("/timestamp")
    ResponseValue timestamp() {
        return new ResponseValue(System.currentTimeMillis());
    }

    @GetMapping("/uuid")
    ResponseValue uuid() {
        return new ResponseValue(UUID.randomUUID().toString());
    }

    @GetMapping("/hello")
    ResponseValue hello(@RequestHeader(name="Name") String name) {
        return new ResponseValue(String.format("Hello %s!", name));
    }

    @GetMapping("/error/{code}")
    ResponseEntity<Void> alwaysError(@PathVariable Integer code){
        return ResponseEntity.status(code).build();
    }



}
