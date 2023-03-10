package com.challenge.ranking.exceptions;


import com.challenge.ranking.responses.RankingResponse;
import com.challenge.ranking.utils.constants.ExceptionConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@SuppressWarnings({ "rawtypes", "unchecked" })
public class RankingRestExceptionHandler {

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public RankingResponse unhandledErrors(HttpServletRequest req, Exception ex) {
		return new RankingResponse(ExceptionConstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
	}

	@ExceptionHandler({ RankingException.class })
	@ResponseBody
	public RankingResponse handleLmException(final HttpServletRequest request, final HttpServletResponse response,
			final RankingException ex) {
		response.setStatus(ex.getCode());
		return new RankingResponse(ExceptionConstants.ERROR, String.valueOf(ex.getCode()), ex.getMessage(),
				ex.getErrorList());
	}
}
