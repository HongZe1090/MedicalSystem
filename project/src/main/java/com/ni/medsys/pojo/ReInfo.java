package com.ni.medsys.pojo;

public class ReInfo {
    private String username;
    private String id;
    private String Token;
    private int type;

    public ReInfo(String username, String id, String token, int type) {
        this.username = username;
        this.id = id;
        Token = token;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
