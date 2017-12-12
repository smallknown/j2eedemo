package service;

import bean.User;
import dao.UserDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 */
public class UserService {
    UserDao userDao = new UserDao();

    public void add(User user)
    {
        userDao.add(user);
    }

    public List<User> getUserList(int start,int count)
    {
        return userDao.getUserList(start,count);
    }

    public int getTotal()
    {
        return userDao.getTotal();
    }

    public User getUser(int id)
    {
        return userDao.getUser(id);
    }

    public int update(User user) {
        return userDao.update(user);
    }

    public int  delete(int id) {
        return userDao.delete(id);
    }

    public List<User> query(String name, String gender, String phone, String email) {
        return userDao.query(name,gender,phone,email);
    }
}
