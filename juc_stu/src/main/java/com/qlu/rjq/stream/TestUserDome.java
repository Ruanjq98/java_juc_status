package com.qlu.rjq.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ruanjq
 * @version 1.0
 * @date 2021/8/2317:30
 **/

public class TestUserDome {
    public static void main(String[] args) {

        User user = new User(1,"a",21);
        User user1 = new User(1,"b",21);
        User user2 = new User(1,"c",21);
        User user3 = new User(1,"d",21);
        User user4 = new User(1,"e",21);
        List<User> list = Arrays.asList(user, user1, user2, user3, user4);

    }
    @Test
    void test(){

    }
}
