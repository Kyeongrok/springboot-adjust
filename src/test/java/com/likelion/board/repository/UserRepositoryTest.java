package com.likelion.board.repository;

import com.likelion.board.dao.UserDao;
import com.likelion.board.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserDao userDao;

    User user1 = new User("1", "kyeonghwan", "1123");
    User user2 = new User("2", "sohyun", "1234");
    User user3 = new User("3", "sujin", "4321");

    @Test
    void addAndGet() throws SQLException {

        userDao.add(user1);

    }
}