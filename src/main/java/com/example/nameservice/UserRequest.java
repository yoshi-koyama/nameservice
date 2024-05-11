package com.example.nameservice;

/**
 * ユーザー情報登録時に使うリクエストパラメータ
 */
public class UserRequest {

    private String name;

    private String email;

    public UserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
