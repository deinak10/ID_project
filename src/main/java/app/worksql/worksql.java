package app.worksql;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class worksql {
    private static final String URL = "jdbc:mysql://localhost:3306/transfers?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "vlad10051999";
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver driver;
        try { driver = new FabricMySQLDriver();
        }catch (SQLException e){
            System.out.println("Ошибка при создании драйвера");
            return;
        }
        try{DriverManager.registerDriver(driver);
        }catch (SQLException e){
            System.out.println("Не удалось зарегистрировать драйвер");
            return;
        }
        try{ connection = DriverManager.getConnection(URL, USERNAME ,PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось создать соединение");
            return;
        }
        finally {
            if (connection != null){
                connection.close();
            }
        }
    }
}
/*
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class worksql {
    private static final String URL = "jdbc:mysql://localhost:3306/transfers?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "vlad10051999";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver driver;
        connection = DriverManager.getConnection(URL, USERNAME ,PASSWORD);

    }
}

*/