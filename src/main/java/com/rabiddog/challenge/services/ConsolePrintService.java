package com.rabiddog.challenge.services;

public class ConsolePrintService {
    public static void printNestedError(Exception e){
        System.err.printf("Nested error is '%s'%n", e.getMessage());
    }

    public static void printError(String message){
        System.err.println(message);
    }
}
