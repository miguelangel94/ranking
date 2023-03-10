package com.challenge.ranking.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRest  implements Serializable {

    private static final long serialVersionUID = 180802329613616000L;

    private Long id;

    private String name;
}
