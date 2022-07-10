package com.learning.restfulwebservices.service;

import com.learning.restfulwebservices.exception.Error;
import com.learning.restfulwebservices.exception.UserNotFoundException;
import com.learning.restfulwebservices.model.User;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private static final Map<Long, User> USER_MAP = new HashMap<>();
    private static long id;

    static {
        User foo = new User();
        foo.setId(++id);
        foo.setName("Foo");
        foo.setBirthdate(ZonedDateTime.now());

        User bar = new User();
        bar.setId(++id);
        bar.setName("Foo");
        bar.setBirthdate(ZonedDateTime.now());

        USER_MAP.put(foo.getId(), foo);
        USER_MAP.put(bar.getId(), bar);
    }

    public List<User> getUsers() {
        return new ArrayList<>(USER_MAP.values());
    }

    public User getUser(long id) {
        User user = USER_MAP.get(id);
        if (user == null) throw new UserNotFoundException(Error.USER_NOT_FOUND_BY_ID);
        return user;
    }

    public User createUser(User user) {
        user.setId(++id);
        USER_MAP.put(user.getId(), user);
        return user;
    }

    public User deleteUser(long id) {
        User user = USER_MAP.get(id);
        if (user == null) throw new UserNotFoundException(Error.USER_NOT_FOUND_BY_ID);
        return USER_MAP.remove(id);
    }
}
