package com.example.nameservice.mapper;

import com.example.nameservice.User;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
//    @DataSet(value = "datasets/users.yml")
    @Sql(
      scripts = {"classpath:sqlannotation/delete-users.sql", "classpath:sqlannotation/insert-users.sql"},
      executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Transactional
    void 指定したIDのユーザーを取得できること() {
        Optional<User> actual = userMapper.findById(1);
        assertThat(actual).hasValue(new User(1, "清水", "shimizu@example.com"));

        Optional<User> actual2 = userMapper.findById(2);
        assertThat(actual2).hasValue(new User(2, "小山", "koyama@example.com"));

        Optional<User> actual3 = userMapper.findById(3);
        assertThat(actual3).hasValue(new User(3, "田中", "tanaka@example.com"));
    }

    @Test
    @DataSet(value = "datasets/users.yml")
    @Transactional
    void 存在しないIDを指定した場合は空のOptionalが返ること() {
        Optional<User> actual = userMapper.findById(100);
        assertThat(actual).hasValue(new User(1, "shimizu", "shimizu@example.com"));

    }

}
