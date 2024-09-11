package org.ubots.domain.models.team;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public enum Team {
    CARDS("CARDS"),
    LOAN("LOAN"),
    GENERAL("GENERAL");

    @Getter
    private final String description;

}
