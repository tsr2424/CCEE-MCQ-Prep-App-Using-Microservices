package com.ranetejas03.quiz_service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseDTO {

	private Integer id;
	private String response;
}
