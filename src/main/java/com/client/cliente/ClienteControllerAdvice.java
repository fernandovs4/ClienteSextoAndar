package com.client.cliente;

import com.client.cliente.exception.ClienteNotFoundException;
import com.client.cliente.exception.CpfAlreadyRegisteredException;
import com.client.common.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.time.LocalDateTime;


@ControllerAdvice
public class ClienteControllerAdvice {
    @ExceptionHandler(CpfAlreadyRegisteredException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO cpfAlreadyRegisteredException(CpfAlreadyRegisteredException ex) {
        ErrorDTO error = new ErrorDTO();
        error.setMessage(ex.getMessage());
        error.setCode(400);
        error.setTime(LocalDateTime.now());
        return error;
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO clienteNotFoundException(ClienteNotFoundException ex){
        ErrorDTO error = new ErrorDTO();
        error.setMessage(ex.getMessage());
        error.setCode(404);
        error.setTime(LocalDateTime.now());
        return error;
    }

}


