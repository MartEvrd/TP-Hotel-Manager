package com.epita.spring.tphotelmanagement.exposition.exception;

import java.util.Date;

public class ExceptionDto {
    private String errorMessage;
    private Date errorDate;
    private String errorCode;

    public ExceptionDto(String errorMessage, Date errorDate, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorDate = errorDate;
        this.errorCode = errorCode;
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
