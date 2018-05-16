package com.pino.login.exception;

public class RepeatUserException extends LoginException{
    public RepeatUserException(String message){
        super(message);
    }

    public RepeatUserException(String message, Throwable cause){
        super(message, cause);
    }
}
