package com.example;

public interface ExternalApi {
    String getData();

    void sendData(String payload); // <-- Make sure this is present!
}
