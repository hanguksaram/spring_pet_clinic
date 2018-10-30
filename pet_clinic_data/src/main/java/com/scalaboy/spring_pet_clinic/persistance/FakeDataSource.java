package com.scalaboy.spring_pet_clinic.persistance;

public class FakeDataSource {
    private final String user;
    private final String password;
    private final String url;

    public FakeDataSource(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
