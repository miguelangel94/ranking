package com.challenge.ranking.exceptions;

import java.util.Arrays;

import com.challenge.ranking.dto.ErrorDto;
import org.springframework.http.HttpStatus;


public class InternalServerErrorException extends RankingException {
	private static final long serialVersionUID = -6870732210014274010L;

	public InternalServerErrorException(final String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

	public InternalServerErrorException(final String message, final ErrorDto data) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
	}
}
