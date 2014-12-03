package scm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBLocal {

    public String IP = "localhost";
    public String UN = "root";
    public String PW = "123";
    private static Connection c;

    public static Connection getMyConnection() throws Exception {

        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/local_rr", "root", "123");
        }
        return c;
    }

    public static void InsertEditDelete(String sql) throws Exception {
        getMyConnection().createStatement().executeUpdate(sql);
    }

    public static ResultSet Search(String sql) throws Exception {
        return getMyConnection().createStatement().executeQuery(sql);
    }
}
