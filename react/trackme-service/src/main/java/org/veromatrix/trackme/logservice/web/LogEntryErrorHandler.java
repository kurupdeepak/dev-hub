package org.veromatrix.trackme.logservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.veromatrix.trackme.logservice.transfer.ErrorResponseTO;

@ControllerAdvice
public class LogEntryErrorHandler {

    public ErrorResponseTO handleEntryServiceException(EntryServiceException e, WebRequest request){
        ErrorResponseTO error = new ErrorResponseTO();
        error.setE(e);
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.name());
        error.setApiPath(request.getDescription(false));
        return  error;
    }

    public ErrorResponseTO handleGlobalException(EntryServiceException e,WebRequest request){
        ErrorResponseTO error = new ErrorResponseTO();
        error.setE(e);
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
        error.setApiPath(request.getDescription(false));
        return  error;
    }
}
