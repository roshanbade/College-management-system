package com.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No Book found with this id!")
public class NoBooksFoundUnderThisId extends RuntimeException{

}
