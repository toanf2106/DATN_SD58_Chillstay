package org.example.datn_chillstay_2025.Exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
  public ResponseEntity<DetailError> handleAll(Exception ex, WebRequest req) {
    return new ResponseEntity<>(
        new DetailError(LocalDateTime.now(), ex.getMessage(), req.getDescription(false)),
        HttpStatus.INTERNAL_SERVER_ERROR
    );
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
  public ResponseEntity<DetailError> handleNotFound(Exception ex, WebRequest req) {
    return new ResponseEntity<>(
        new DetailError(LocalDateTime.now(), ex.getMessage(), req.getDescription(false)),
        HttpStatus.NOT_FOUND
    );
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatusCode status, WebRequest req) {

    String messages = ex.getFieldErrors().stream()
        .map(e -> e.getDefaultMessage())
        .collect(Collectors.joining(", "));

    return new ResponseEntity<>(
        new DetailError(LocalDateTime.now(), messages, req.getDescription(false)),
        HttpStatus.BAD_REQUEST
    );
  }
}
