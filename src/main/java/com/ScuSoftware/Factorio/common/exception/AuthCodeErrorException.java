package com.ScuSoftware.Factorio.common.exception;

public class AuthCodeErrorException extends RuntimeException {
    public AuthCodeErrorException(){
        super();
    }

    public AuthCodeErrorException(String message){
        super(message);
    }
}