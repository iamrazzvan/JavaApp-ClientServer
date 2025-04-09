package com.networking.request;

public class GetTeamByNameRequest implements Request {
    private final String name;

    public GetTeamByNameRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
