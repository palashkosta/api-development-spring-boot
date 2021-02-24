package com.sample.firstrestapp.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
    
    private static List<User> users = new ArrayList<User>();

    private static int usersCount = 5;

    static {
        users.add(new User(1, "Pal", new Date()));
        users.add(new User(2, "Palv2", new Date()));
        users.add(new User(3, "Palv3", new Date()));
        users.add(new User(4, "Palv4", new Date()));
        users.add(new User(5, "PalSuper", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User addUser(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user: users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteUserById(int id) {
        Iterator<User> iterator =  users.iterator();
        while(iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
