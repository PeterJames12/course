package demo;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setName("Alex");
        user.setAbout("Something...");
        userService.save(user);

        List<User> users = userService.findAll();
        users.forEach(System.out::println);
    }
}
