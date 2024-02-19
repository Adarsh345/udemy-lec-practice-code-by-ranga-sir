package com.in23minutes.rest.webservices.restfulwebservices.restAdviseExceptionHandler.gernalException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GaneralException {
    private LocalDateTime timeStamp;
    private String message;

}
