//package com.indah.freshGoodiesBackend.responses;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//@Getter
//@Setter
//public class Response2<T> {
//    //yang dikeluarin di postman
//    private int statusCode;
//    private String message;
//    boolean success = false;
//    private T data;
//    //T artinya thing atau generic atau bisa menerima tipe data apapun atau any
//
//    public Response2(int statCode, String StatusDesc){
//        statusCode = statCode;
//        message = StatusDesc;
//
//        if (statusCode == HttpStatus.OK.value()){
//            success = true;
//        }
//    }
//
//    //beda di parameter menggunakan method overloading
//    public static <T> ResponseEntity<Response<Object>> failedResponse(String message){
//
//    }
//    public static <T> ResponseEntity<Response<T>> failedResponse(T data){
//
//    }
//    public static <T> ResponseEntity<Response<T>> failedResponse(int statusCode, String message){
//
//    }
//    public static <T> ResponseEntity<Response<T>> failedResponse(String message, T data){
//
//    }
//
//
//
//
//}
