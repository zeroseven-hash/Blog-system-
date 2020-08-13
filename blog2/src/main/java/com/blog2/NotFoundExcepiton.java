package com.blog2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//异常处理
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExcepiton extends RuntimeException {
    public NotFoundExcepiton() {
    }
    public NotFoundExcepiton(String message) {
        super(message);
    }
    public NotFoundExcepiton(String message, Throwable cause) {
        super(message, cause);
    }
}