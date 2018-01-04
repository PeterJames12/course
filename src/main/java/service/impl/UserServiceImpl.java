package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() throws SQLException {
        UserDao userDao = new UserDaoImpl();
        return userDao.findAll();
    }

    @Override
    public int save(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        return userDao.save(user);
    }

    @Override
    public int update(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        return userDao.update(user);
    }

    @Override
    public void delete(int userId) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.delete(userId);
    }
}
