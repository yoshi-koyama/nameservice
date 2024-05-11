package com.example.nameservice.integrationtest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserApiIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DataSet(value = "datasets/users.yml")
    @Transactional
    void 指定したIDのユーザーが存在するときにそのユーザーを取得できること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1"))
          .andExpect(MockMvcResultMatchers.status().isOk())
          // text block を使って json をアサーションする
          .andExpect(MockMvcResultMatchers.content().json("""
            {
              "id": 1,
              "name": "清水",
              "email": "shimizu@example.com"
            }
            """));
    }
}
