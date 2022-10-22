package team.one.hhuz.handlar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;
import team.one.hhuz.exceptions.AlreadyExistException;
import team.one.hhuz.exceptions.GenericNotFoundException;
import team.one.hhuz.exceptions.UserNotFoundException;
import team.one.hhuz.handlar.errorResponse.ApiErrorResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import java.util.Arrays;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handle404(GenericNotFoundException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.NOT_FOUND);
    } @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handle404(UserNotFoundException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.NOT_FOUND);
    }@ExceptionHandler(UnsupportedMediaTypeStatusException.class)
    public ResponseEntity<ApiErrorResponse> handle404(UnsupportedMediaTypeStatusException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiErrorResponse> handle400(ValidationException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<ApiErrorResponse> handle403(IllegalAccessException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.FORBIDDEN);
    }    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handle303(AlreadyExistException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiErrorResponse> handle500(NullPointerException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}