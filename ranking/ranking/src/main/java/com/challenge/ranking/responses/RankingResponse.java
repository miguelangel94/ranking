package com.challenge.ranking.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class RankingResponse<T> implements Serializable {

	private String status;
	private String code;
	private String message;
	private T data;

	private static final long serialVersionUID = 7302319210373510173L;

	public RankingResponse(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}


}
