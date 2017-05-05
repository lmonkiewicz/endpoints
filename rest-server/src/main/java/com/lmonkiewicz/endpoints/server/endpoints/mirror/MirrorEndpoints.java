package com.lmonkiewicz.endpoints.server.endpoints.mirror;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by lmonkiewicz on 05.05.2017.
 */
@RestController
@RequestMapping("/mirror")
class MirrorEndpoints {

    @PostMapping("/json")
    Map<String,Object> json(@RequestBody Map<String, Object> json){
        return json;
    }

}
