package com.codingshuttle.SecurityApp.SecurityApplication.advices;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class APIResponse<T> {


    private LocalDateTime localDateTime;
    private T data;
    private ApiError apiError;

    public APIResponse() {
        this.localDateTime = LocalDateTime.now();
    }

    public APIResponse(ApiError apiError) {
        this();
        this.apiError = apiError;
    }

    public APIResponse(T data) {
        this();
        this.data = data;
    }

//    public LocalDateTime getLocalDateTime() {
//        return localDateTime;
//    }
//
//    public void setLocalDateTime(LocalDateTime localDateTime) {
//        this.localDateTime = localDateTime;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public ApiError getApiError() {
//        return apiError;
//    }
//
//    public void setApiError(ApiError apiError) {
//        this.apiError = apiError;
//    }


}