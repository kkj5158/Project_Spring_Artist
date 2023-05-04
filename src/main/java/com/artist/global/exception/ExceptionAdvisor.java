package com.artist.global.exception;

import com.artist.model.dto.http.DefaultRes;
import com.artist.model.dto.http.StatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvisor {





    // IllegalArgumentException 예외 처리

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        String errorMsg = ex.getMessage();

        return ResponseEntity.badRequest().body(DefaultRes.res(StatusCode.BAD_REQUEST, errorMsg));


    }




}
