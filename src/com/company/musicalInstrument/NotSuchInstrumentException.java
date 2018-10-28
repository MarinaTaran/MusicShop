package com.company.musicalInstrument;

public class NotSuchInstrumentException extends Exception {
    String message;

    public NotSuchInstrumentException(String message) {
        this.message = message;
    }

    public void printMyMessage(){
        System.out.println(message);
    }
}
