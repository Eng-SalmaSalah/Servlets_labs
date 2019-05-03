/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilityClasses;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author salma
 */
public class UserDao {

    private MysqlDataSource mysqlDataSource;
    private Connection connection;
    //--------------------------------------
    private PreparedStatement preparedStatement;
    //---------------------------------------
    private ResultSet resultSet;
    //----------------------------------------
    User user;
   

    public UserDao() {

        try {
            mysqlDataSource = EstablishConnection.getConnetion();
            connection = mysqlDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String name, String password) {
        try {
            String logInQuery = "select * from users where userName = ? "
                    + "and userPass = ?";
            preparedStatement = connection.prepareStatement(logInQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

//    public static void main(String[] args) {
//        UserDao dao= new UserDao();
//        dao.checkUser("salma","999999999");
//        
//    }
}
