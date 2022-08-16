package com.example.school_db.Advice;

import com.example.school_db.DTO.ApiResponse;
import com.example.school_db.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherControllerAdvice {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));

    }@ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> ApiResponseException(ApiException apiException){
        String message=apiException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));
    }

    @ExceptionHandler(value= Exception.class)
    public ResponseEntity<ApiResponse> Exception(Exception exception){
        exception.printStackTrace();
        return ResponseEntity.status(500).body(new ApiResponse("Server error", 500));
    }
}
