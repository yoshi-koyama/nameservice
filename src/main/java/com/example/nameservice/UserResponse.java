package com.example.nameservice;

/**
 * ユーザー情報取得時に使うレスポンスパラメータ
 */
public class UserResponse {

    private String message;

    public UserResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
