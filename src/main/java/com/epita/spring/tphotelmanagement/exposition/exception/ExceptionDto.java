package com.epita.spring.tphotelmanagement.exposition.exception;

import java.util.Date;

public class ExceptionDto {
    private String errorType;
    private String errorMessage;
    private Date errorDate;
    private String errorCode;

    public ExceptionDto(String errorType, String errorMessage, Date errorDate, String errorCode) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
        this.errorDate = errorDate;
        this.errorCode = errorCode;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(Date errorDate) {
        this.errorDate = errorDate;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
