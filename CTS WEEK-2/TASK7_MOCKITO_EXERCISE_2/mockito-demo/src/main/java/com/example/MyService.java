package com.example;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public void save(String value) {
        api.sendData(value); // <-- make sure this line matches the interface
    }
}
