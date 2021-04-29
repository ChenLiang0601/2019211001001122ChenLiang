package com.ChenLiang.dao;

import com.ChenLiang.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into user(id,username,password,email,sex,birthday) values(?,?,?,?,?,?) " ;
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, user.getUsername());
        st.setString(5, user.getPassword());
        st.setString(2, user.getEmail());
        st.setString(3, user.getSex());
        st.setDate(4, (Date) user.getBirthday());
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirthday(rs.getDate("birthday"));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from user where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,user.getId());
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirthday(rs.getDate("birthday"));
        }
        return 0;
    }


    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update [user] set username=?,password=?,email=?,sex=?,birthday=? where id=?";
        PreparedStatement st=con.prepareStatement(sql);

        st.setString(1, user.getUsername());
        st.setString(2, user.getPassword());
        st.setString(3, user.getEmail());
        st.setString(4, user.getSex());
        st.setDate(5,  user.getBirthday());
        st.setString(6,user.getId());
        System.out.println(st);

        return st.executeUpdate();
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select * from user where id =?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next())
        {
            user = new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirthday(rs.getDate("birthday"));

        }
        return user;
    }


    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        System.out.println(username);
        System.out.println(password);
        String sql_1="select * from [user] where username=? and password=?";

               /* "select * from [user] "+
                "WHERE username='"+username+"'"+" AND "+
                "password = '"+password+"'"+
                ';';*/
        PreparedStatement st=con.prepareStatement(sql_1);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs= st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirthday(rs.getDate("birthday"));

        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from user where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return UserList;
    }


    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from user where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return UserList;
    }


    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from user where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return UserList;
    }


    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from user where sex=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthdate"));
        }
        return UserList;
    }


    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from user where birthday=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1, (Date) birthDate);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirthday(rs.getDate("birthday"));

        }
        return UserList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from user ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirthday(rs.getDate("birthday"));

        }
        return UserList;
    }


}
