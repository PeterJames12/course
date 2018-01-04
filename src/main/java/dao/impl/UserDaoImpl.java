package dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String URL = "jdbc:sqlite:miracle.sqlite";
    private Dao<User, Integer> dao;

    {
        try {
            ConnectionSource source = new JdbcConnectionSource(URL);
            dao = DaoManager.createDao(source, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() throws SQLException {
        return dao.queryBuilder()
                .orderBy("name", true)
                .query();
    }

    @Override
    public int save(User user) throws SQLException {
        return dao.create(user);
    }

    @Override
    public int update(User user) throws SQLException {
        return dao.update(user);
    }

    @Override
    public void delete(int userId) throws SQLException {
        dao.deleteById(userId);
    }
}
