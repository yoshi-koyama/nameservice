package com.example.nameservice;

import java.util.Objects;

/**
 * ユーザーテーブル用エンティティ
 */
public class User {

    private Integer id;

    private String name;

    private String email;

    public User(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * コンストラクタ
     * データベースに登録する前にインスタンス化するときに使う
     * ID は自動採番されるので null でよい
     *
     * @param name  名前
     * @param email メールアドレス
     */
    public User(String name, String email) {
        this.id = null;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "User{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", email='" + email + '\'' +
          '}';
    }
}
