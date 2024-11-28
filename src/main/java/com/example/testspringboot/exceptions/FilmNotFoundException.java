package com.example.testspringboot.exceptions;

public class FilmNotFoundException extends Throwable {
    public FilmNotFoundException(String message) {
        super(message);
    }

}
