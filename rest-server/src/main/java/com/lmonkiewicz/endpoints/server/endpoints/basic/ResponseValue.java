package com.lmonkiewicz.endpoints.server.endpoints.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Created by lmonkiewicz on 06.05.2017.
 */
@Builder
@Getter
@AllArgsConstructor
class ResponseValue {
    private Object value;
}
