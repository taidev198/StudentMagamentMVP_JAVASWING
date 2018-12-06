package database;

import java.sql.*;

public class ConnectDataHelper {
   private  static Connection conn = null;
   private static ConnectDataHelper instance= null;

    private ConnectDataHelper()  throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, SQLException {
        String password = "03031998";
        String userName = "root";
        String url = "jdbc:mysql://localhost/data";
        conn = DriverManager.getConnection(url, userName, password);
   }

   public static ConnectDataHelper getInstance()  throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, SQLException {
       if (instance == null)
           instance = new ConnectDataHelper();
       return instance;
   }

    public  Connection connectDB() throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, SQLException {
          Class.forName("com.mysql.jdbc.Driver").newInstance();
        return conn;
    }

    public  void closeDB(){
        if (conn != null){
            try {
                conn.close();
                System.out.println("Disconnceted");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
