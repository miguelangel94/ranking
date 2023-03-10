package com.challenge.ranking.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import com.challenge.ranking.dto.ErrorDto;


public class NotFoundException extends RankingException {
	private static final long serialVersionUID = -6870732210014274010L;

	public NotFoundException(final String message) {
		super(HttpStatus.NOT_FOUND.value(), message);
	}

	public NotFoundException(final String message, final ErrorDto data) {
		super(HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
	}
}
