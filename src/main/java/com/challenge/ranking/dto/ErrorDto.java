package com.challenge.ranking.dto;

import java.io.Serializable;

import lombok.Data;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
@Data
public class ErrorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String value;

}
