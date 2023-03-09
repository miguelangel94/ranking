package com.challenge.ranking.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScoreRest implements Serializable {

    private static final long serialVersionUID = 4916713904971425156L;
    private float score;
    private String serieName;
    private String userName;
}
