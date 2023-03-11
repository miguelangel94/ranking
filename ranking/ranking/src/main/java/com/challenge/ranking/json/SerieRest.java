package com.challenge.ranking.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SerieRest implements Serializable {
    private static final long serialVersionUID = 8725949484031409482L;
    private Long id;
    private String name;

    private String streamingPlatform;

    private String cover;

    private String sinopsis;
    private float averageScore;

    private List<ScoreRest> scoreRestList;





}
