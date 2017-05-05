package com.lmonkiewicz.endpoints.server.crud;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by lmonkiewicz on 05.05.2017.
 */
@Data
public class Task {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private boolean done = false;
}
