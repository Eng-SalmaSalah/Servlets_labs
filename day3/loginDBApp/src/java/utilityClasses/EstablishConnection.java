/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilityClasses;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author salma
 */
public class EstablishConnection {

    static MysqlDataSource mysqlDataSource = null;

    public EstablishConnection() {

    }

    static {
        try {
            Properties properties = new Properties();
            FileInputStream fileInput = null;
            if (mysqlDataSource == null) {
                fileInput = new FileInputStream("F:\\ITI\\matrial\\Mobile courses\\2-servlets\\labs\\day3\\loginDBApp\\db.properties");
                properties.load(fileInput);
                mysqlDataSource = new MysqlDataSource();
                mysqlDataSource.setURL(properties.getProperty("URL"));
                mysqlDataSource.setUser(properties.getProperty("userName"));
                mysqlDataSource.setPassword(properties.getProperty("password"));

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static MysqlDataSource

    getConnetion() {
        return mysqlDataSource;
    }
}
