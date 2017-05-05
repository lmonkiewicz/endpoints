package com.lmonkiewicz.endpoints.server.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Created by lmonkiewicz on 05.05.2017.
 */
@Slf4j
public class MonkeyInterceptor implements HandlerInterceptor {

    public static final String TIME_DELAY_PARAM = "t";
    public static final String ERROR_THRESHOLD = "r";
    public static final String ERROR_CODE = "e";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Optional.ofNullable(request.getParameter(TIME_DELAY_PARAM))
                .map(Long::valueOf)
                .filter(time -> time > 0)
                .ifPresent(this::sleep);

        final boolean shouldGenerateError = Optional.ofNullable(request.getParameter(ERROR_THRESHOLD))
                .map(Double::valueOf)
                .map(r -> r > Math.random())
                .orElse(false);

        if (shouldGenerateError) {
            final Integer errorCode = Optional.ofNullable(request.getParameter(ERROR_CODE))
                    .map(Integer::valueOf)
                    .orElse(500);

            response.sendError(errorCode);
            return false;
        }
        else {
            return true;
        }
    }

    private void sleep(Long time) {
        try {
            log.info("Sleeping {} ms", time);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.error("Error while sleeping", e);
        }
    }
}
