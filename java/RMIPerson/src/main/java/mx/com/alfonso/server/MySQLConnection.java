package mx.com.alfonso.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    // Variables
    private static final String IP = "192.168.1.69";
    private static final String PORT = "3306";
    private static final String DATABASE = "rmi";
    private static final String URL = "jdbc:mysql://"
            + IP
            + ":" + PORT
            + "/" + DATABASE +
            "?useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "password123A_";

    // Methods
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    };

}
