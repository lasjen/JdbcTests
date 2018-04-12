package eritec.demo.oracle.db;

import oracle.jdbc.OracleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class OracleConnectionFactory {

   public final static String DB_URL = "jdbc:oracle:thin:@localhost:151/orcl";
   public final static String DB_USERNAME = "devdata";
   public final static String DB_PASSWORD = "dev";

   private static Connection conn = null;

   private static Connection getConn(String db_url, String db_usr, String db_pw) throws ClassNotFoundException, SQLException {
      Connection conn = null;
      DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
      conn = DriverManager.getConnection(db_url, db_usr, db_pw);
      conn.setAutoCommit(false);
      return conn;
   }

   public static Connection getConnection() throws ClassNotFoundException, SQLException {
      conn = getConn(DB_URL, DB_USERNAME, DB_PASSWORD);
      System.out.println("DB Connection created successfully");
      return conn;
   }

   public static OracleConnection getOracleConnection() throws ClassNotFoundException, SQLException {
      conn = getConn(DB_URL, DB_USERNAME, DB_PASSWORD);
      System.out.println("DB Connection created successfully");
      return (OracleConnection)  conn;
   }

   public static Connection getConnection(String db_url, String db_usr, String db_pw) throws ClassNotFoundException, SQLException {
      conn = getConn(db_url, db_usr, db_pw);
      System.out.println("DB Connection created successfully");
      return conn;
   }

   public static OracleConnection getOracleConnection(String db_url, String db_usr, String db_pw) throws ClassNotFoundException, SQLException {
      conn = getConn(db_url, db_usr, db_pw);
      System.out.println("DB Connection created successfully");
      return (OracleConnection) conn;
   }

}