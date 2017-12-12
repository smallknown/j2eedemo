package dao;

import bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 */
public class UserDao {
    /**
     * 增加用户
     * @param user
     */
    public void add(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/customer?characterEncoding=UTF-8",
                    "root", "root");

            String sql = "insert into t_customer values(null,?,?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1,user.getName());
            ps.setString(2,user.getGender());
            ps.setString(3,user.getPhone());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getDescription());
            ps.execute();

          /*  ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                user.setId(id);

            }*/

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 查找所有的用户数据
     * @return
     * @param start
     * @param count
     */
    public List<User> getUserList(int start, int count) {
        List<User> users = new ArrayList<User>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/customer?characterEncoding=UTF-8",
                    "root", "root");

            String sql = "select * from t_customer order by id desc limit ?,?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String description = rs.getString(6);

                user.setId(id);
                user.setName(name);
                user.setGender(gender);
                user.setPhone(phone);
                user.setEmail(email);
                user.setDescription(description);
                users.add(user);
            }

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users;
    }

    /**
     * 查找所有的用户数据
     * @return
     * @param id
     */
    public User getUser(int id) {
        User user = new User();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/customer?characterEncoding=UTF-8",
                    "root", "root");

            String sql = "select * from t_customer where id = ? ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int pid = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String description = rs.getString(6);

                user.setId(pid);
                user.setName(name);
                user.setGender(gender);
                user.setPhone(phone);
                user.setEmail(email);
                user.setDescription(description);
            }

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 获取总数
     * @return
     */
    public int getTotal() {
        int total = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/customer?characterEncoding=UTF-8",
                    "root", "root");

            String sql = " select count(*) from  t_customer ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return total;
    }

    /**
     * 更新数据
     * @param user
     */
    public int update(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/customer?characterEncoding=UTF-8",
                    "root", "root");

            String sql = "update t_customer set name=?,gender=?,phone=?,email=?,description=? where id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getGender());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getDescription());
            ps.setInt(6,user.getId());
            ps.execute();

          /*  ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                user.setId(id);

            }*/

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

    public int delete(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/customer?characterEncoding=UTF-8",
                    "root", "root");

            String sql = " delete from t_customer where id = ? ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

    public List<User> query(String name, String gender, String phone, String email) {
        StringBuilder sql = new StringBuilder();
        List<User> users = new ArrayList<User>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/customer?characterEncoding=UTF-8",
                    "root", "root");

            sql.append("select * from t_customer where 1=1");
            if (name!=null&&!name.trim().isEmpty()){
                sql.append(" and name like ?");
            }
            if (gender!=null&&!gender.trim().isEmpty()){
                sql.append(" and gender=?");
            }
            if (phone!=null&&!phone.trim().isEmpty()){
                sql.append(" and phone like ?");
            }
            if (email!=null&&!email.trim().isEmpty()){
                sql.append(" and email like ?");
            }
            PreparedStatement ps = c.prepareStatement(sql.toString());
            if (name!=null&&!name.trim().isEmpty()){
                ps.setString(1,"%"+name+"%");
            }
            if (gender!=null&&!gender.trim().isEmpty()){
                if (name!=null&&!name.trim().isEmpty()){
                    ps.setString(2,gender);
                }else {
                    ps.setString(1,gender);
                }
            }
            if (phone!=null&&!phone.trim().isEmpty()){
                if (gender!=null&&!gender.trim().isEmpty()){
                    if (name!=null&&!name.trim().isEmpty()){
                        ps.setString(3,"%"+phone+"%");
                    }else {
                        ps.setString(2,"%"+phone+"%");
                    }
                }else {
                    ps.setString(1,"%"+phone+"%");
                }
            }
            if (email!=null&&!email.trim().isEmpty()){
                if (phone!=null&&!phone.trim().isEmpty()){
                    if (gender!=null&&!gender.trim().isEmpty()){
                        if (name!=null&&!name.trim().isEmpty()){
                            ps.setString(4,"%"+email+"%");
                        }else {
                            ps.setString(3,"%"+email+"%");
                        }
                    }else {
                        ps.setString(2,"%"+email+"%");
                    }
                }else {
                    ps.setString(1,"%"+email+"%");
                }
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                int id = rs.getInt(1);
                String name1 = rs.getString(2);
                String gender1 = rs.getString(3);
                String phone1 = rs.getString(4);
                String email1 = rs.getString(5);
                String description1 = rs.getString(6);

                user.setId(id);
                user.setName(name1);
                user.setGender(gender1);
                user.setPhone(phone1);
                user.setEmail(email1);
                user.setDescription(description1);
                users.add(user);
            }

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users;
    }
}
